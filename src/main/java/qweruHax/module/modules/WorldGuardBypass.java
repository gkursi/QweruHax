package qweruHax.module.modules;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import qweruHax.module.ModuleBase;
import qweruHax.util.Defs;

public class WorldGuardBypass extends ModuleBase { // skid from https://github.com/IMXNOOBX/FuFuClient/
    public WorldGuardBypass() {
        super("WGBypass", Defs.NULLKeybind, Category.LO);
    }
    static boolean restoreTick = false;

    @Override
    public void onTick() {
        if(nullCheck()) return;
        boolean forwardKey = mc.options.forwardKey.isPressed();
        boolean backwardKey = mc.options.backKey.isPressed();
        boolean leftKey = mc.options.leftKey.isPressed();
        boolean rightKey = mc.options.rightKey.isPressed();
        boolean downKey = mc.options.sprintKey.isPressed(); //mc.options.sneakKey.isPressed();
        boolean upKey = mc.options.jumpKey.isPressed(); //mc.options.sprintKey.isPressed();

        Vec3d pos = new Vec3d(0, 0, 0);

        if(forwardKey) {
            pos = pos.add(new Vec3d(0, 0, 0.1));
        } else if(backwardKey) {
            pos = pos.add(new Vec3d(0, 0, -0.1));
        } else if (leftKey) {
            pos = pos.add(new Vec3d(-0.1, 0, 0));
        } else if (rightKey) {
            pos = pos.add(new Vec3d(0.1, 0, 0));
        } else if (downKey) {
            pos = pos.add(new Vec3d(0, -0.1, 0));
        }
        else if (upKey) {
            pos = pos.add(new Vec3d(0, 0.1, 0));
        }

        if(pos.length() <= 0) // Credits https://github.com/JorianWoltjer/LiveOverflowMod/
            return;

        pos = pos.normalize();

        if (!(pos.x == 0 && pos.z == 0)) {  // Rotate by looking yaw (won't change length)
            double moveAngle = Math.atan2(pos.x, pos.z) + Math.toRadians(mc.player.getYaw() + 90);
            double x = Math.cos(moveAngle);
            double z = Math.sin(moveAngle);
            pos = new Vec3d(x, pos.y, z);
        }

        if(!mc.player.isOnGround()) {
            double y = -0.02;
            pos = new Vec3d(pos.x, y, pos.z);
        }

        pos = pos.multiply(0.05);  // Scale to maxDelta

        Vec3d newPos = new Vec3d(mc.player.getX() + pos.x, mc.player.getY() + pos.y, mc.player.getZ() + pos.z);

        // Max: 0.0626
        if ((newPos.x >= mc.player.prevX + 0.05 || newPos.y >= mc.player.prevY + 0.05|| newPos.z >= mc.player.prevZ + 0.05) || (newPos.x <= mc.player.prevX - 0.05 || newPos.y <= mc.player.prevY - 0.05 || newPos.z <= mc.player.prevZ - 0.05)) {
            newPos = newPos.add(pos);
            restoreTick = true;
        }

        if(!restoreTick) { // (forwardKey || backwardKey || rightKey || leftKey || upKey || downKey)
            sendMessage("Sending movement packet: " + String.format("%.02f", (mc.player.prevX - newPos.x)) + "x " + String.format("%.02f", (mc.player.prevY - newPos.y)) + "y " + String.format("%.02f", (mc.player.prevZ - newPos.z)) + "z, restoreTick: "+restoreTick);
            mc.getNetworkHandler().getConnection().send(
                    new PlayerMoveC2SPacket.Full(
                            newPos.x,// pos.x,
                            newPos.y,// pos.y,
                            newPos.z,// pos.z,
                            mc.player.getYaw(),
                            mc.player.getPitch(),
                            mc.player.isOnGround())
            );
        }

        if(restoreTick) {
            // mc.player.setPosition(mc.player.getX(), -42069, mc.player.getZ());
            mc.getNetworkHandler().getConnection().send(new PlayerMoveC2SPacket.Full( // make the server teleport you back
                    newPos.x,
                    newPos.y + 1337.0,
                    newPos.z,
                    mc.player.getYaw(),
                    mc.player.getPitch(),
                    mc.player.isOnGround())
            );
            restoreTick = false;
        }
    }
}
