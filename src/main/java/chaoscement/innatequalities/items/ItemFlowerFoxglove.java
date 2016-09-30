package chaoscement.innatequalities.items;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import net.minecraft.item.Item;
 
public class ItemFlowerFoxglove extends Item {
	public ItemFlowerFoxglove() {
		setUnlocalizedName(Reference.InnateQualitiesItems.FLOWERFOXGLOVE.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesItems.FLOWERFOXGLOVE.getRegistryName()); 
		setCreativeTab(InnateQualities.CREATIVE_TAB);
	}
}
