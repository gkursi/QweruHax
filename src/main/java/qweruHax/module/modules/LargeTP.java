package qweruHax.module.modules;

import qweruHax.Client;
import qweruHax.module.ModuleBase;
import qweruHax.util.Defs;
import qweruHax.util.Network;

public class LargeTP extends ModuleBase {
    public LargeTP() {
        super("LargeTP", Defs.NULLKeybind, Category.NORENDER);
    }

    public static void tp(float x, float y, float z){
        if(mc.player==null||mc.world==null) return;
        double px = mc.player.getPos().x;
        double py = mc.player.getPos().y;
        double pz = mc.player.getPos().z;
        for(int i = 0; i<8; i++){
            Network.PacketHelper.sendMove(px, py, pz, mc.player.isOnGround());
            sendMessage("(C -> S)");
        }
        Network.PacketHelper.sendMove(x, y, z, mc.player.isOnGround());
        sendMessage("Current pos: "+px+", "+py+", "+pz+", target pos: "+x+", "+y+", "+z);
    }
}
