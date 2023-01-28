package qweruHax.module.modules;

import qweruHax.module.ModuleBase;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;

public class SurvivalSpoof extends ModuleBase {

    public SurvivalSpoof() {
        super("SurvivalSpoof", GLFW.GLFW_KEY_Z, Category.UTIL);
    }

    @Override
    public void onTick() {
        mc.interactionManager.setGameMode(GameMode.SURVIVAL);
    }

    @Override
    public void onDisable(){
        if(nullCheck()){return;}
    }

}
