package chaoscement.innatequalities.items;

import chaoscement.innatequalities.Reference;
import chaoscement.innatequalities.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemSeedFoxglove extends ItemSeeds {

	public ItemSeedFoxglove() {
		super(ModBlocks.cropFoxglove, Blocks.FARMLAND);
		setUnlocalizedName(Reference.InnateQualitiesItems.SEEDFOXGLOVE.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesItems.SEEDFOXGLOVE.getRegistryName()); 
	}

}
