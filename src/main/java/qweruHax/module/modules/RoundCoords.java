package qweruHax.module.modules;

import qweruHax.mixin.PlayerMoveC2SPacketAccessor;
import qweruHax.module.ModuleBase;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class
RoundCoords extends ModuleBase {

    public RoundCoords() {
        super("RoundCoords", GLFW.GLFW_KEY_L, Category.LO);
    }

    double roundCoord(double coord){
        // sendMessage("roundCoord executed"); // debug
        return ((int)(coord * 100)) / 100.0;
    }

    @Override
    public boolean onPacket2S(Packet p) {
        if(p instanceof PlayerMoveC2SPacket){
            double rx = roundCoord(((PlayerMoveC2SPacket) p).getX(mc.player.getX()));
            double rz = roundCoord(((PlayerMoveC2SPacket) p).getZ(mc.player.getZ()));
            // sendMessage("Rounded coords: "+rx+", "+rz); // debug
            ((PlayerMoveC2SPacketAccessor) p).setX(rx);
            ((PlayerMoveC2SPacketAccessor) p).setZ(rz);
            double px = rx*1000%10;
            double pz = rz*1000%10;
            boolean isPacketValid = px==0&&pz==0;
            if(!isPacketValid) sendMessage("Floating point error, at: "+px+", "+pz);
            return !isPacketValid;
        }
        return false;
    }

}
