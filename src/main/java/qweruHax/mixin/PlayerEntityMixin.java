package qweruHax.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import qweruHax.Client;
import qweruHax.module.ModuleManager;
import qweruHax.module.VelocityModuleBase;
import qweruHax.module.VelocityModuleManager;
import qweruHax.module.velocitymodules.PlayerEntityVelocityMultiplier;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(method = "getVelocityMultiplier", at = @At("HEAD"), cancellable = true)
    protected void getVelocityMultiplier(CallbackInfoReturnable<Float> cir){
        if(VelocityModuleManager.getModuleByName("VelocityMultiplier")!=null&&VelocityModuleManager.getModuleByName("VelocityMultiplier").isToggled()){
            cir.setReturnValue(5f);
        }
    }

    @Inject(method = "isPushedByFluids", at = @At("HEAD"), cancellable = true)
    public void isPushedByFluids(CallbackInfoReturnable<Boolean> cir){
        if(ModuleManager.getModuleByName("NoFluidPush")!=null && ModuleManager.getModuleByName("NoFluidPush").isToggled()){
            cir.setReturnValue(false);
        }
    }
}
