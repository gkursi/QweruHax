package qweruHax.module.modules;

import qweruHax.module.ModuleBase;
import org.lwjgl.glfw.GLFW;

public class NoWorldBorder extends ModuleBase {
    public NoWorldBorder() {
        super("NoBorder", GLFW.GLFW_KEY_U, Category.UTIL);
    }
}
