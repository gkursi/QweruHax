package qweruHax.module.modules;

import qweruHax.mixin.PlayerMoveC2SPacketAccessor;
import qweruHax.mixin.VehicleMoveC2SPacketAccessor;
import qweruHax.module.ModuleBase;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class
LiveOverflowBypass extends ModuleBase {

    public LiveOverflowBypass() {
        super("RoundCoords", GLFW.GLFW_KEY_L, Category.LO);
    }

    double roundCoord(double coord){
        return ((int)(coord * 100)) / 100.0;
    }

    @Override
    public void onPacket2S(Packet p) {
        if(p instanceof PlayerMoveC2SPacket){
            double rx = roundCoord(((PlayerMoveC2SPacket) p).getX(mc.player.getX()));
            double rz = roundCoord(((PlayerMoveC2SPacket) p).getZ(mc.player.getZ()));
            ((PlayerMoveC2SPacketAccessor) p).setX(rx);
            ((PlayerMoveC2SPacketAccessor) p).setZ(rz);
        }
    }

}
