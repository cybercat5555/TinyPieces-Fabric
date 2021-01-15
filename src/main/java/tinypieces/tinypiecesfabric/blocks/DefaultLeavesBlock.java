package tinypieces.tinypiecesfabric.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;

public class DefaultLeavesBlock extends LeavesBlock {

	public DefaultLeavesBlock(FabricBlockSettings settings) {
		super(settings
				.breakByHand(true)
				.breakByTool(FabricToolTags.SHEARS)
				.strength(0.2F)
				.ticksRandomly()
				.sounds(BlockSoundGroup.GRASS)
				.nonOpaque()
				.allowsSpawning((state, world, pos, type) -> type == EntityType.OCELOT || type == EntityType.PARROT)
				.suffocates((state, world, pos) -> false)
				.blockVision((state, world, pos) -> false));
	}

	public DefaultLeavesBlock() {
		this(FabricBlockSettings.of(Material.LEAVES));
	}
}
