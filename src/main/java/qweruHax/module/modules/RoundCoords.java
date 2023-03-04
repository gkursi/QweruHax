package qweruHax.module.modules;

import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import qweruHax.mixin.PlayerMoveC2SPacketAccessor;
import qweruHax.mixin.VehicleMoveC2SPacketAccessor;
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

        if(!(mc.player.getVehicle() instanceof BoatEntity boat)){return false;}

        if(p instanceof VehicleMoveC2SPacket){
            double boatX = ((int)(((VehicleMoveC2SPacket) p).getX() * 100)) / 100.0;
            double boatZ = ((int)(((VehicleMoveC2SPacket) p).getZ() * 100)) / 100.0;
            ((VehicleMoveC2SPacketAccessor) p).setX(boatX);
            ((VehicleMoveC2SPacketAccessor) p).setZ(boatZ);
            double px = boatX*1000%10;
            double pz = boatZ*1000%10;
            boolean isPacketValid = px==0&&pz==0;
            if(!isPacketValid) sendMessage("Floating point error, at: "+px+", "+pz);

            return !isPacketValid;
        }

        return false;
    }

}
