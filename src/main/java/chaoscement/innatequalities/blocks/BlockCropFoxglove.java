package chaoscement.innatequalities.blocks;

import chaoscement.innatequalities.Reference;
import chaoscement.innatequalities.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropFoxglove extends BlockCrops {
	
	public BlockCropFoxglove() {
	
		setUnlocalizedName(Reference.InnateQualitiesCrops.CROPFOXGLOVE.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesCrops.CROPFOXGLOVE.getRegistryName());
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.seedFoxglove;
	}

	@Override
	protected Item getCrop() {
		return ModItems.flowerFoxglove; 
	}
}
