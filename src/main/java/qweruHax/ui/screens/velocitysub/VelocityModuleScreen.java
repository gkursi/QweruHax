package qweruHax.ui.screens.velocitysub;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import qweruHax.module.VelocityModuleBase;

public class VelocityModuleScreen extends Screen {

    protected VelocityModuleBase target;

    protected VelocityModuleScreen(VelocityModuleBase target) {
        super(Text.of("VelocityModuleScreen"));
        this.target = target;
    }

    private final SliderWidget speed = new SliderWidget(this.width/2-100, 20, 200, 20,
            Text.literal(
                    target.name+" speed: "+
                            (
                                    (int) MathHelper.lerp(
                                            (float) 20,
                                            1,
                                            30
                                    )
                            )
            ),20) {
        @Override
        protected void updateMessage() {
            this.setMessage(
                    Text.literal(
                            target.name+" speed: "+
                        (
                                (int) MathHelper.lerp(
                                        (float) this.value,
                                        1,
                                        25
                                )
                        )
                    )
            );
        }

        @Override
        protected void applyValue() {
            target.setSpeed((
                    (int) MathHelper.lerp(
                            (float) this.value,
                            1,
                            25)
            ));
        }
    };

    @Override
    protected void init() {

    }
}
