package qweruHax.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qweruHax.ui.screens.ClickGUI;

@Mixin(GameMenuScreen.class)
public class PauseMenuClassMixin extends Screen {
    protected PauseMenuClassMixin() {
        super(Text.of("ClickGUI"));
    }

    @Inject(method = "initWidgets", at=@At("HEAD"), cancellable = true)
    public void initWidgets(CallbackInfo ci){
        this.addDrawableChild(new ButtonWidget(2, 2, 204, 20, Text.of("QweruHax"), button -> {
            this.client.setScreen(new ClickGUI());
        }));
    }
}
