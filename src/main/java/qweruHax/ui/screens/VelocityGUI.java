package qweruHax.ui.screens;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import qweruHax.Client;
import qweruHax.module.ModuleBase;
import qweruHax.module.ModuleManager;
import qweruHax.module.VelocityModuleBase;
import qweruHax.module.VelocityModuleManager;

import java.util.ArrayList;
import java.util.List;

public class VelocityGUI extends Screen {
    protected VelocityGUI() {
        super(Text.of("VelocityGUI"));
    }

    private final List<ButtonWidget> buttonWidgets = new ArrayList<>();

    @Override
    protected void init() {
        int yOff = 2;
        for(VelocityModuleBase base : VelocityModuleManager.getModules()){

            String drawableText = "";
            if(base.toggled){
                drawableText = base.getName()+" (ENABLED)";
            }else {
                drawableText = base.getName()+" (DISABLED)";
            }

            ButtonWidget modBtn = new ButtonWidget(2, yOff, 204, 20, Text.of(drawableText), button -> {
                base.toggle();
            });

            this.addDrawableChild(modBtn);
            buttonWidgets.add(modBtn);
            yOff+=22;
        }
    }

    @Override
    public void tick() {
        int index = 0;
        for(VelocityModuleBase m : VelocityModuleManager.getModules()){

            String drawableText = "";
            if(m.toggled){
                drawableText = m.getName()+" (ENABLED)";
            }else {
                drawableText = m.getName()+" (DISABLED)";
            }

            buttonWidgets.get(index).setMessage(Text.of(drawableText));

            index++;
        }
    }
}
