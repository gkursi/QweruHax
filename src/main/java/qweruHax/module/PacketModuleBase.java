package qweruHax.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.lwjgl.glfw.GLFW;

public class PacketModuleBase extends ModuleBase{

    public static MinecraftClient mc = MinecraftClient.getInstance();
    public ClientPlayNetworkHandler networkHandler;

    public PacketModuleBase(String name) {
        super(name, GLFW.GLFW_KEY_HOME, Category.PACKET);
        if(!nullCheck()){
            this.networkHandler = mc.player.networkHandler;
        }
    }

    @Override
    public void onTick() {
        if(!nullCheck()&&networkHandler==null){
            this.networkHandler = mc.player.networkHandler;
        }

        // MUST USE super.onTick() IN ALL MODULES
    }
}
