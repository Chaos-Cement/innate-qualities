package chaoscement.innatequalities.init;

import chaoscement.innatequalities.Reference;
import chaoscement.innatequalities.items.ItemAcorn;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item acorn;

	public static void init() {
		acorn = new ItemAcorn();
	}
	
	public static void register() {
		GameRegistry.register(acorn);
	}
	
	public static void registerRenders() {
		registerRender(acorn);
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
