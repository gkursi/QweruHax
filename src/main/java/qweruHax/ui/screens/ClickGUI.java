package qweruHax.ui.screens;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import qweruHax.module.ModuleBase;
import qweruHax.module.ModuleManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Optional;

import static qweruHax.Client.mc;

public class ClickGUI extends Screen {


    public ClickGUI() {
        super(Text.of("qweruHax options"));
    }

    public ArrayList<ButtonWidget> drawableList = new ArrayList<>();
    private final int sWidth = mc.getWindow().getScaledWidth();
    private final int sHeight = mc.getWindow().getScaledHeight();

    @Override
    protected void init() {
        ButtonWidget velocityBtn = new ButtonWidget(sWidth-206, sHeight-23, 204, 20, Text.of("Velocity"), button -> {
            this.client.setScreen(new VelocityGUI());
        });

        this.addDrawableChild(velocityBtn);


        int xOff = 2;
        int yOff = 2;
        for(ModuleBase m : ModuleManager.getModules()){

            String drawableText = "";
            if(m.toggled){
                drawableText = m.getName()+" (ENABLED)";
            }else {
                drawableText = m.getName()+" (DISABLED)";
            }

            if(m.category.name=="Utility"){
                xOff+=0;
            } else if (m.category.name=="LiveOverflow") {
                xOff+=204*2+20;
            }

            ButtonWidget modBtn = new ButtonWidget(xOff, yOff, 204, 20, Text.of(drawableText), button -> {
                m.toggle();
            });

            this.addDrawableChild(modBtn);
            drawableList.add(modBtn);
            yOff+=20+5;
            xOff=0;
            if(yOff>this.height) {
                yOff = 2;
                xOff+=204+20;
            }
        }
    }

    @Override
    public void tick() {

        int index = 0;
        for(ModuleBase m : ModuleManager.getModules()){

            String drawableText = "";
            if(m.toggled){
                drawableText = m.getName()+" (ENABLED)";
            }else {
                drawableText = m.getName()+" (DISABLED)";
            }

            drawableList.get(index).setMessage(Text.of(drawableText));

            index++;
        }
    }
}
