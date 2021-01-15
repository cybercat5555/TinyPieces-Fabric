package tinypieces.tinypiecesfabric.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.sound.BlockSoundGroup;

public class DefaultSaplingBlock extends SaplingBlock {

	public DefaultSaplingBlock(SaplingGenerator generator, Settings settings) {
		super(generator, settings
				.noCollision()
				.ticksRandomly()
				.breakInstantly()
				.sounds(BlockSoundGroup.GRASS)
		);
	}

	public DefaultSaplingBlock(SaplingGenerator generator) {
		this(generator, FabricBlockSettings.of(Material.PLANT));
	}
}
