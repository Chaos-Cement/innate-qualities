package chaoscement.innatequalities.blocks;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;

public class BlockTreeElderLog extends BlockRotatedPillar{

	public BlockTreeElderLog() {
		super(Material.WOOD);
		setUnlocalizedName(Reference.InnateQualitiesBlocks.TREEELDERLOG.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesBlocks.TREEELDERLOG.getRegistryName());
		setHardness(2.0F);
		setCreativeTab(InnateQualities.CREATIVE_TAB);
	}

}
