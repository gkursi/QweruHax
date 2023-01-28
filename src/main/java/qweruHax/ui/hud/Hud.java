package qweruHax.ui.hud;

import qweruHax.Client;
import qweruHax.module.ModuleBase;
import qweruHax.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Comparator;


public class Hud {

    public static int color = Color.MAGENTA.getRGB();
    public static void draw(MatrixStack matrixStack, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        int sWidth = mc.getWindow().getScaledWidth();
        int sHeight = mc.getWindow().getScaledHeight();
        mc.textRenderer.drawWithShadow(matrixStack, Client.NAME + " "+ Client.VERSION,2,2,color);
        mc.textRenderer.drawWithShadow(matrixStack, "[XYZ] " + (int)Math.round(mc.player.getX()) +", " +(int)Math.round(mc.player.getY())+", "+ (int)Math.round(mc.player.getZ()),sWidth-mc.textRenderer.getWidth("[XYZ] " + (int)mc.player.getX() +", " +mc.player.getY()+", "+ (int)mc.player.getZ()), sHeight-mc.textRenderer.fontHeight,color);


        int y = 2+mc.textRenderer.fontHeight+4;
        int bindX = 100;
        ModuleManager.getModules().sort(Comparator.comparingInt((ModuleBase module) -> module.getName().length()).reversed());
        y+=mc.textRenderer.fontHeight+1;
        for(ModuleBase m : ModuleManager.getModules()) {
            mc.textRenderer.drawWithShadow(matrixStack, " [" + KeyEvent.getKeyText(m.getBind())+"]", bindX, 2, -1);
            bindX+=mc.textRenderer.getWidth(" <" + KeyEvent.getKeyText(m.getBind())+">");
            if(!m.isToggled()) return;
            mc.textRenderer.drawWithShadow(matrixStack, m.getName() + " <" + KeyEvent.getKeyText(m.getBind())+">",2,y,m.isToggled() ? color : -1);
            y+=mc.textRenderer.fontHeight+1;

        }
    }
}
