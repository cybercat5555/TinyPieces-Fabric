package tinypieces.tinypiecesfabric.mixins;

import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import tinypieces.tinypiecesfabric.mixinducks.AnimalLittersAccess;

@Mixin(PigEntity.class)
public class PigLitters implements AnimalLittersAccess {

	@Override
	public int getLitterSize(ServerWorld world) {
		return world.getRandom().nextInt(4)+1;
	}
}
