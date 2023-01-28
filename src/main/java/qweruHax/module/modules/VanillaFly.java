package qweruHax.module.modules;

import org.lwjgl.glfw.GLFW;
import qweruHax.module.ModuleBase;

public class VanillaFly extends ModuleBase {
    public VanillaFly() {
        super("VanillaFlight", GLFW.GLFW_KEY_G, Category.UTIL);
    }

    @Override
    public void onTick() {
        if (mc.player != null) {
            mc.player.getAbilities().allowFlying=true;
            mc.player.getAbilities().flying=true;
        }

    }

    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.getAbilities().allowFlying=false;
            mc.player.getAbilities().flying=false;
        }
    }
}
