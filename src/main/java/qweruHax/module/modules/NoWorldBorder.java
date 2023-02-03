package qweruHax.module.modules;

import qweruHax.module.ModuleBase;
import org.lwjgl.glfw.GLFW;
import qweruHax.util.Defs;

public class NoWorldBorder extends ModuleBase {
    public NoWorldBorder() {
        super("NoBorder", Defs.NULLKeybind, Category.LO);
    }
}
