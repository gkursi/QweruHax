package qweruHax.mixin;

import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import qweruHax.Client;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qweruHax.module.modules.ChatHandler;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {


    @Inject(method="sendPacket",at=@At("HEAD"),cancellable = true)
    private void onSendPacket(Packet< ? > p, CallbackInfo ci){

        if(p instanceof ChatMessageC2SPacket cm2s){
            if(ChatHandler.handle(cm2s.chatMessage())) ci.cancel();
        }


        // code for onPacket2s
        boolean returnable = Client.INSTANCE.onPacket2S(p);
        if(returnable){
            ci.cancel();
        }
    }


}