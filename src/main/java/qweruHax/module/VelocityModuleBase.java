package qweruHax.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.Packet;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import qweruHax.util.Defs;

public class VelocityModuleBase extends ModuleBase{
    public VelocityModuleBase(String name) {
        super(name, Defs.NULLKeybind, Category.VELOCITY);
    }
    public static int value = 10;

    private final PlayerEntity player = mc.player;
    public void setSpeed(int speed){
        value = speed;
    }

}
