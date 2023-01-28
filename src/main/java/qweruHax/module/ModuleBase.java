package qweruHax.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;
import net.minecraft.text.Text;

public class ModuleBase {
    public static MinecraftClient mc = MinecraftClient.getInstance();
    public String name;
    public Category category;
    public int bind;
    public static boolean toggled;

    public ModuleBase(String name, int bind, Category category) {
        this.name = name;
        this.bind = bind;
        this.category = category;

    }
    public String getName() {
        return name;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void onTick(){}

    public void onPacket2S(Packet<?> packet){}

    public void onPacketReceive(Packet<?> packet){}

    public void onEnable(){}

    public void onDisable(){}

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void toggle() {
        this.toggled = !toggled;

        if(toggled){
            onEnable();
        }else {
            onDisable();
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }
    public boolean nullCheck() {
        return mc.player == null||mc.world == null;
    }
    public static void sendMessage(String msg){
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of(msg)); // from auto log.cc as well cos yes
        }
    }
    public enum Category{
        LO("LiveOverflow"),
        UTIL("Utility"),
        VELOCITY("Velocity");


        public final String name;

        Category(String name){
            this.name = name;
        }
    }
}
