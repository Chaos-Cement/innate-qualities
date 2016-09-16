package chaoscement.innatequalities.proxy;

import chaoscement.innatequalities.init.ModBlocks;
import chaoscement.innatequalities.init.ModItems;
import chaoscement.innatequalities.util.GenerationHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Init and register items");	
		ModItems.init();
		ModItems.register();
		System.out.println("Init and register blocks");
		ModBlocks.init();
		ModBlocks.register();
	}
	
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new GenerationHandler(), 2);
	}
	
}
