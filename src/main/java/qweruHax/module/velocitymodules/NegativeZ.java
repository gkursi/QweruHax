package qweruHax.module.velocitymodules;

import net.minecraft.entity.player.PlayerEntity;
import qweruHax.module.VelocityModuleBase;

public class NegativeZ extends VelocityModuleBase {
    public NegativeZ() {
        super("NegativeZ");
    }
    @Override
    public void onEnable() {
        PlayerEntity player = mc.player;
        if(player == null) return;
        player.setVelocity(player.getVelocity().x, player.getVelocity().y, player.getVelocity().z-value);
    }
    @Override
    public void onTick() {
        PlayerEntity player = mc.player;
        if(player == null) return;
        player.setVelocity(player.getVelocity().x - value, player.getVelocity().y, player.getVelocity().z);
    }

}
