package qweruHax.module.modules;

import qweruHax.module.ModuleBase;
import org.lwjgl.glfw.GLFW;
import qweruHax.util.Defs;

public class NoFloatKick extends ModuleBase {

    public NoFloatKick() {
        super("NoFloatKick", Defs.NULLKeybind, Category.UTIL);
    }

    public int tickCounter = 0;

    @Override
    public void onTick() {
        if(nullCheck()) return;
        tickCounter++;
        if(tickCounter==30) {
            tickCounter=0;
            mc.player.setVelocity(0,-0.04,0);
        }
    }
    @Override
    public void onDisable(){
        if(nullCheck()){return;}
    }
}
