package qweruHax.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "shouldRenderName", at = @At("HEAD"), cancellable = true)
    public void shouldRenderName(CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(true);
    }

}
