package chaoscement.innatequalities.init;

import chaoscement.innatequalities.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	// Create block variable (unlocalized name)
	public static Block oreLivingIron;
	
	public static void init() {
		// Add to init (<unlocalizedName> = new <registryName>)
		oreLivingIron = new BlockOreLivingIron();
		
	}
	
	public static void register() {
		registerBlock(oreLivingIron);
		
	}
	
	private static void registerBlock(Block block) {
		// Add to register (unlocalized name)
		GameRegistry.register(oreLivingIron);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders() {
		// Add to registerRenders (unlocalized name)
		registerRender(oreLivingIron);
	}
	
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}
