package chaoscement.innatequalities.init;

import chaoscement.innatequalities.InnateQualities;
import net.minecraft.item.Item;

public class ItemBase extends Item implements ItemModelProvider {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	@Override
	public void registerItemModel(Item item) {
		InnateQualities.proxy.registerItemRenderer(item);
	}
}
//	@Override
//	public ItemBase setCreativeTab(CreativeTabs tab) {
//		super.setCreativeTab(tab);
//		return this;
//	}
//}
