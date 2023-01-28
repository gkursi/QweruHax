package qweruHax.module.velocitymodules;

import net.minecraft.entity.player.PlayerEntity;
import qweruHax.module.VelocityModuleBase;

public class NegativeX extends VelocityModuleBase {
    public NegativeX() {
        super("NegativeX");
    }
    public static int value = 10;

    @Override
    public void onEnable() {
        PlayerEntity player = mc.player;
        if(player == null) return;
        player.setVelocity(player.getVelocity().x - value, player.getVelocity().y, player.getVelocity().z);
    }

    @Override
    public void onTick() {
        PlayerEntity player = mc.player;
        if(player == null) return;
        player.setVelocity(player.getVelocity().x - value, player.getVelocity().y, player.getVelocity().z);
    }
}
