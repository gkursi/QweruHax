package qweruHax.module.modules;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.text.MutableText;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;
import qweruHax.module.ModuleBase;

public class BlockFinder extends ModuleBase {
    public BlockFinder() {
        super("BlockFinder", GLFW.GLFW_KEY_J, Category.UTIL);
    }

    public static void checkBlock(BlockState blockState, BlockPos pos){
        Block block = blockState.getBlock();
        MutableText text = block.getName();
        String blockKey = text.toString();

        if (
                blockKey=="translation{key='block.minecraft.barrel', args=[]}"
                ||blockKey=="translation{key='block.minecraft.cobblestone', args=[]}"
                ||blockKey=="translation{key='block.minecraft.cobbled_deepslate', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.white_bed', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.red_bed', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.black_bed', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.yellow_bed', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.cyan_bed', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.grey_bed', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.glass_pane', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.white_stained_glass', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.orange_stained_glass', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.black_stained_glass', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.crafting_table', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.furnace', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.blast_furnace', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.smoker', args=[]}"
                        ||blockKey=="translation{key='block.minecraft.campfire', args=[]}"
        )
        {
            sendMessage("Player block detected at: "+pos.getX()+", "+pos.getY()+", "+pos.getZ());
        }else{
            sendMessage("unimportant block rendered at: "+pos.getX()+", "+pos.getY()+", "+pos.getZ());
        }
    }

    @Override
    public void onEnable() {
        mc.worldRenderer.reload();
    }
}
