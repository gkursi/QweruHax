package qweruHax.mixin;

import qweruHax.Client;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Inject(method="sendPacket",at=@At("HEAD"),cancellable = true)
    private void onSendPacket(Packet< ? > p, CallbackInfo ci){
        boolean returnable = Client.INSTANCE.onPacket2S(p);
        if(returnable){
            ci.cancel();
        }
    }
}