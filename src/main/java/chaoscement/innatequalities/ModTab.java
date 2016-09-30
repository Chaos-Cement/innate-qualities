package chaoscement.innatequalities;

import chaoscement.innatequalities.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModTab extends CreativeTabs {

	public ModTab() {
		super("tabMod");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return ModItems.ingotLivingIron;
	}

}
