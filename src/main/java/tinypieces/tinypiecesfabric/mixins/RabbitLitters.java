package tinypieces.tinypiecesfabric.mixins;

import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import tinypieces.tinypiecesfabric.mixinducks.AnimalLittersAccess;

@Mixin(RabbitEntity.class)
public class RabbitLitters implements AnimalLittersAccess {

	@Override
	public int getLitterSize(ServerWorld world) {
		return world.getRandom().nextInt(4)+1;
	}
}
