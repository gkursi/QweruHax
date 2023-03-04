package qweruHax.module.velocitymodules;

import net.minecraft.entity.player.PlayerEntity;
import qweruHax.module.VelocityModuleBase;

public class PositiveX extends VelocityModuleBase {
    public PositiveX() {
        super("PositiveX");
    }
    public static int value = 10;


    public static void onEnable() {
        PlayerEntity player = mc.player;
        if(player == null) return;
        player.setVelocity(player.getVelocity().x + value, player.getVelocity().y, player.getVelocity().z);

    }
    @Override
    public void onTick() {
        PlayerEntity player = mc.player;
        if(player == null) return;
        player.setVelocity(player.getVelocity().x - value, player.getVelocity().y, player.getVelocity().z);
    }
}
