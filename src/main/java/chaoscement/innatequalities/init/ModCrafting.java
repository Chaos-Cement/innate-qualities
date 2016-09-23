package chaoscement.innatequalities.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void registerShapedCrafting() {
		
		// Remove this one later
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.oreLivingIron), "III", "MMM", "III", 'I', Blocks.IRON_ORE, 'M', Blocks.MOSSY_COBBLESTONE);
	}
	
	public static void registerSmelting() {
		GameRegistry.addSmelting(ModBlocks.oreLivingIron, new ItemStack(ModItems.ingotLivingIron), 0.7f);;
	}
}
