package qweruHax.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public interface Defs {

    int NULLKeybind = GLFW.GLFW_KEY_INSERT;
    enum configuratorDefaults {
        // maybe in the future
    }

    static void sendMessage(String msg){
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of(msg)); // from auto log.cc as well cos yes
        }
    }
}
