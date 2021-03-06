package com.shnupbups.redstonebits;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

public class RedstoneBits implements ModInitializer {

	public static final BlockEntityType<PlacerBlockEntity> PLACER = Registry.register(Registry.BLOCK_ENTITY, new Identifier("redstonebits", "placer"), BlockEntityType.Builder.create(PlacerBlockEntity::new).build(null));
	public static final BlockEntityType<BreakerBlockEntity> BREAKER = Registry.register(Registry.BLOCK_ENTITY, new Identifier("redstonebits", "breaker"), BlockEntityType.Builder.create(BreakerBlockEntity::new).build(null));
	public static final BlockEntityType<CheckerBlockEntity> CHECKER = Registry.register(Registry.BLOCK_ENTITY, new Identifier("redstonebits", "checker"), BlockEntityType.Builder.create(CheckerBlockEntity::new).build(null));
	public static final Identifier BREAKER_CONTAINER = new Identifier("redstonebits","breaker_container");

	public void onInitialize() {
		ModBlocks.init();

		ContainerProviderRegistry.INSTANCE.registerFactory(BREAKER_CONTAINER, (syncId, identifier, player, buf) -> {
			BlockPos pos = buf.readBlockPos();
			return ((BreakerBlockEntity)player.getEntityWorld().getBlockEntity(pos)).createMenu(syncId,player.inventory,player);
		});
	}
}
