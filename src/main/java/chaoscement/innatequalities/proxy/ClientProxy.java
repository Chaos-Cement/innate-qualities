package chaoscement.innatequalities.proxy;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import chaoscement.innatequalities.init.ModBlocks;
import chaoscement.innatequalities.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy{

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		InnateQualities.logger.info("<" + InnateQualities.modID + "> Registering renders with client");	
		ModBlocks.registerRenders();
		ModItems.registerRenders();
	}
	
	@Override
	public void registerItemRenderer(Item item) {
		super.registerItemRenderer(item);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
