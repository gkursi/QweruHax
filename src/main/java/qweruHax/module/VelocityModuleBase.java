package qweruHax.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.Packet;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class VelocityModuleBase extends ModuleBase{
    public VelocityModuleBase(String name) {
        super(name, GLFW.GLFW_KEY_HOME, Category.VELOCITY);
    }
    public static int value = 10;

    public static boolean pubIsToggled() {
        return toggled;
    }

    public static boolean pubToggle = pubIsToggled();

    private final PlayerEntity player = mc.player;
    public void setSpeed(int speed){
        value = speed;
    }

}
