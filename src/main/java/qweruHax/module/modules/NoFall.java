package qweruHax.module.modules;

import qweruHax.mixin.PlayerMoveC2SPacketAccessor;
import qweruHax.module.ModuleBase;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class NoFall extends ModuleBase {

    public NoFall() {
        super("NoFall", GLFW.GLFW_KEY_U, Category.UTIL);
    }

    @Override
    public boolean onPacket2S(Packet p) {
        if(p instanceof PlayerMoveC2SPacket move){
            ((PlayerMoveC2SPacketAccessor) move).setOnground(true);
        }
        return false;
    }

    @Override
    public void onDisable(){
        if(nullCheck()){return;}

    }

}
