package qweruHax.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class Network {
    public static class PacketHelper {
        public static void sendNow(Packet<?> packet){
            MinecraftClient mc = MinecraftClient.getInstance();
            if(mc.player==null||mc.world==null) return;
            mc.player.networkHandler.sendPacket(packet);
        }

        public static void sendMove(double x, double y, double z, boolean onGround){
            MinecraftClient mc = MinecraftClient.getInstance();
            if(mc.player==null||mc.world==null) return;
            mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(x, y, z, onGround));
        }
    }

    public static class basic {
        public Object b = null;
        public static basic nBasic(){
            return new basic();
        }
    }
}
