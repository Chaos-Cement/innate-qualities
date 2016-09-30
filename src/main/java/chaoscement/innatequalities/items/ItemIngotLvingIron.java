package chaoscement.innatequalities.items;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import net.minecraft.item.Item;

// Class to match registry name
public class ItemIngotLvingIron extends Item {
	
	// Constructor to match registry name
	public ItemIngotLvingIron() {
		// Use ALL CAPS reference (unlocalized name)
		setUnlocalizedName(Reference.InnateQualitiesItems.INGOTLIVINGIRON.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesItems.INGOTLIVINGIRON.getRegistryName()); 
		setCreativeTab(InnateQualities.CREATIVE_TAB);
	}

}
