package qweruHax.module.velocitymodules;

import net.minecraft.entity.player.PlayerEntity;
import qweruHax.module.VelocityModuleBase;

public class PlayerEntityVelocityMultiplier extends VelocityModuleBase {
    public PlayerEntityVelocityMultiplier() {
        super("PEVelMod=5");
    }




    public static boolean pubIsToggled() {
        return toggled;
    }

    public static boolean pubToggle = pubIsToggled();

    private final PlayerEntity player = mc.player;


}
