package chaoscement.innatequalities.init;

import chaoscement.innatequalities.Reference;
import chaoscement.innatequalities.items.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	// Create item variable (unlocalized name)
	public static Item acorn;
	public static Item ingotLivingIron;

	public static void init() {
		// Add to init (<unlocalizedName> = new <registryName>)
		acorn = new ItemAcorn();
		ingotLivingIron = new ItemIngotLvingIron();
	}
	
	public static void register() {
		// Add to register (unlocalized name)
		GameRegistry.register(acorn);
		GameRegistry.register(ingotLivingIron);
	}
	
	public static void registerRenders() {
		// Add to registerRenders (unlocalized name)
		registerRender(acorn);
		registerRender(ingotLivingIron);
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
