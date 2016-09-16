package chaoscement.innatequalities.proxy;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import chaoscement.innatequalities.init.ModBlocks;
import chaoscement.innatequalities.init.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy{

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		InnateQualities.logger.info("<" + InnateQualities.modID + "> Registering renders with client");	
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
}
