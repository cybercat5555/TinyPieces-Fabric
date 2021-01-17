package tinypieces.tinypiecesfabric.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tinypieces.tinypiecesfabric.mixinducks.AnimalLittersAccess;

@Mixin(AnimalEntity.class)
public abstract class AnimalLitters extends PassiveEntity implements AnimalLittersAccess {

	protected AnimalLitters(EntityType<? extends PassiveEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public int getLitterSize(ServerWorld world) {
		return 1;
	}

	AnimalEntity breedOther = null;
	@Redirect(
			method = "breed",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/server/world/ServerWorld;spawnEntityAndPassengers(Lnet/minecraft/entity/Entity;)V"
			)
	)
	private void replaceChildWithLitter(ServerWorld serverWorld, Entity entity) {
		int childrenAmount = getLitterSize(serverWorld);
		for (int i = 0; i < childrenAmount; i++) {
			PassiveEntity passiveEntity = this.createChild(serverWorld, breedOther);
			passiveEntity.setBaby(true);
			passiveEntity.refreshPositionAndAngles(randomDouble(serverWorld) + this.getX(), this.getY(), randomDouble(serverWorld) + this.getZ(), serverWorld.getRandom().nextFloat() * 360 - 180, 0.0F);
			serverWorld.spawnEntityAndPassengers(passiveEntity);
		}
		breedOther = null;
	}
	@Inject(
			method = "breed",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/server/world/ServerWorld;spawnEntityAndPassengers(Lnet/minecraft/entity/Entity;)V"
			)
	)
	private void captureBreedMethodArgument(ServerWorld serverWorld, AnimalEntity other, CallbackInfo ci) {
		// @Redirect doesn't support locals
		breedOther = other;
	}

	private double randomDouble(ServerWorld serverWorld) {
		return serverWorld.getRandom().nextDouble() * 2 - 1d;
	}
}
