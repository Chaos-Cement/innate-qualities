package chaoscement.innatequalities.items;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import net.minecraft.item.Item;

public class ItemAcorn extends Item {
	
	public ItemAcorn() {
		setUnlocalizedName(Reference.InnateQualitiesItems.ACORN.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesItems.ACORN.getRegistryName()); 
		setCreativeTab(InnateQualities.CREATIVE_TAB);
	}

}
