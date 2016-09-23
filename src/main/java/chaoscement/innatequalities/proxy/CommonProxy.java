package chaoscement.innatequalities.proxy;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import chaoscement.innatequalities.init.ModBlocks;
import chaoscement.innatequalities.init.ModCrafting;
import chaoscement.innatequalities.init.ModItems;
import chaoscement.innatequalities.util.GenerationHandler;
import chaoscement.innatequalities.util.features.TestTree;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		InnateQualities.logger.info("<" + InnateQualities.modID + "> Initializing and registering blocks");	
		ModBlocks.init();
		ModBlocks.register();
		InnateQualities.logger.info("<" + InnateQualities.modID + "> Initializing and registering items");	
		ModItems.init();
		ModItems.register();

	}
	
	public void init(FMLInitializationEvent event) {
		InnateQualities.logger.info("<" + InnateQualities.modID + "> Registering GenerationHandler with WorldGenerator");	
		GameRegistry.registerWorldGenerator(new GenerationHandler(), 1);
		InnateQualities.logger.info("<" + InnateQualities.modID + "> Registering recipes");
		ModCrafting.registerShapedCrafting();
		ModCrafting.registerSmelting();
	}
	
	public void registerItemRenderer(Item item) {

	}
	
}
