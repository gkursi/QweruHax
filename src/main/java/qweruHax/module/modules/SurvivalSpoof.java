package qweruHax.module.modules;

import qweruHax.module.ModuleBase;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;
import qweruHax.util.Defs;

public class SurvivalSpoof extends ModuleBase {

    public SurvivalSpoof() {
        super("SurvivalSpoof", Defs.NULLKeybind, Category.LO);
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
