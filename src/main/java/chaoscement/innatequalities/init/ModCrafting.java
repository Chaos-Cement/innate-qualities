package chaoscement.innatequalities.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void register() {
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.oreLivingIron), "III", "MMM", "III", 'I', Blocks.IRON_ORE, 'M', Blocks.MOSSY_COBBLESTONE);
	}
}
