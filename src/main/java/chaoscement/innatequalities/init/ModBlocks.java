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
	
	// Ores
	public static Block oreLivingIron;
	
	// Trees
	public static Block treeElderLog;
	public static Block treeElderLeaf;
	
	// Crop blocks
	public static BlockCropFoxglove cropFoxglove;
	
	public static void init() {
		// Add to init (<unlocalizedName> = new <registryName>)
		
		// Ores
		oreLivingIron = new BlockOreLivingIron();
		
		// Trees
		treeElderLog = new BlockTreeElderLog();
		treeElderLeaf = new BlockTreeElderLeaf();
		
		// Crops
		cropFoxglove = new BlockCropFoxglove();
		
	}
	
	public static void register() {
		
		// Ores
		registerBlock(oreLivingIron);
		
		// Trees
		registerBlock(treeElderLog);
		registerBlock(treeElderLeaf);
		
		// Crops
		registerBlock(cropFoxglove, null);
		
	}
	

	private static void registerBlock(Block block) {
		// Add to register (unlocalized name)
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	private static <T extends Block> T registerBlock(T block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		if (itemBlock != null) {
			GameRegistry.register(itemBlock);

			if (block instanceof ItemModelProvider) {
				((ItemModelProvider)block).registerItemModel(itemBlock);
			}
		}

		return block;
	}
	
//	private static void registerBlock(Block block) {
//		// Add to register (unlocalized name)
//		GameRegistry.register(block);
//		ItemBlock item = new ItemBlock(block);
//		
//		if (item != null) {
//			item.setRegistryName(block.getRegistryName());
//			GameRegistry.register(item);
//			}
//	}
	
//	private static void registerBlock(Block block, ItemBlock itemBlock) {
//		// Add to register (unlocalized name)
//		GameRegistry.register(block);
//		GameRegistry.register(itemBlock);
//
//		if (block instanceof BlockBase) {
//			((BlockBase)block).registerItemModel(itemBlock);
//		}
//	}
	
	public static void registerRenders() {
		// Add to registerRenders (unlocalized name)
		
		// Ores
		registerRender(oreLivingIron);
		
		// Trees
		registerRender(treeElderLog);
		registerRender(treeElderLeaf);
		
		// Crops
		registerRender(cropFoxglove);
	}
	
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}
