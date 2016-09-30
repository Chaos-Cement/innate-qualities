package chaoscement.innatequalities.blocks;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOreLivingIron extends Block {

	public BlockOreLivingIron() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.InnateQualitiesBlocks.ORELIVINGIRON.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesBlocks.ORELIVINGIRON.getRegistryName());
		setHardness(3.0F);
		setCreativeTab(InnateQualities.CREATIVE_TAB);
	}

}
