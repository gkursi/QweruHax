package qweruHax.module.modules;

import qweruHax.module.ModuleBase;
import org.lwjgl.glfw.GLFW;

public class Fly extends ModuleBase {

    public Fly() {
        super("AntiFloatKick", GLFW.GLFW_KEY_C, Category.UTIL);
    }

    public int tickCounter = 0;

    @Override
    public void onTick() {
        tickCounter++;

        float y = 0;


        if (mc.player != null && mc.player.input.jumping) {
            y += 0.12;
        }
        if (mc.player != null && mc.player.input.sneaking) {
            y -= 0.12;
        }
        if(tickCounter==30) {
            y = -0.04f;
            tickCounter=0;
        }
        if (mc.player != null) {
            mc.player.setVelocity(0,0,0);
        }

        double x, z = 0;
        x = mc.player.getVelocity().x;
        z = mc.player.getVelocity().z;
        mc.player.setVelocity(x, y, z);
        if(mc.player.input.pressingForward){
            mc.player.forwardSpeed = 1f;
        } else if (mc.player.input.pressingBack) {
            mc.player.forwardSpeed = 1f;
        } else if (mc.player.input.pressingLeft) {
            mc.player.forwardSpeed = 1f;
        } else if (mc.player.input.pressingRight) {
            mc.player.forwardSpeed = 1f;
        }
    }
    @Override
    public void onDisable(){
        if(nullCheck()){return;}
    }
}
