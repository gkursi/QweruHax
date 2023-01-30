package qweruHax;

import qweruHax.module.ModuleBase;
import qweruHax.module.ModuleManager;
import qweruHax.module.VelocityModuleBase;
import qweruHax.module.VelocityModuleManager;
import qweruHax.ui.hud.Hud;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;
import org.lwjgl.glfw.GLFW;

public class Client implements ModInitializer {


    public static final Client INSTANCE = new Client();
    public static MinecraftClient mc = MinecraftClient.getInstance();

    public static String NAME = "qweru hax";
    public static String VERSION = "0.1.1";

    public ModuleManager moduleManager;
    public VelocityModuleManager velocityModuleManager;
    Hud hud;


    @Override
    public void onInitialize() {
        moduleManager = new ModuleManager();
        hud = new Hud();
        velocityModuleManager = new VelocityModuleManager();
    }

    public void onKeyPress(int key, int action) {
        if(action == GLFW.GLFW_PRESS) {
            for (ModuleBase m : ModuleManager.getModules()) {
                if (m.getBind() == key) {
                    m.toggle();
                }
            }
        }
    }

    public void onTick() {
        if(nullCheck()){return;}
        for(ModuleBase m : ModuleManager.getModules()){
            if(m.isToggled()) {
                m.onTick();
            }
        }
        for(VelocityModuleBase m : VelocityModuleManager.getModules()){
            if(m.isToggled()){
                m.onTick();
            }
        }

    }
    public boolean nullCheck() {
        return mc.player == null || mc.world == null; // Borrowed from l4j cos good idea :)
        //https://github.com/Logging4J/AutoLog.CC/blob/master/src/main/java/cc/l4j/autolog/AutoLog.java
    }

    public boolean onPacket2S(Packet<?> packet) {
        boolean shouldCancelPacket = false;
        for(ModuleBase m : ModuleManager.getModules()){
            if(m.isToggled()) {
                boolean returnable = m.onPacket2S(packet);
                if(returnable) shouldCancelPacket=true;
            }
        }
        return shouldCancelPacket;
    }
    public void onPacketReceive(Packet<?> packet) {
        for(ModuleBase m : ModuleManager.getModules()){
            if(m.isToggled()) {
                m.onPacketReceive(packet);
            }
        }
    }
}
