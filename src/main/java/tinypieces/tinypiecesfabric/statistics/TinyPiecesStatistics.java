package tinypieces.tinypiecesfabric.statistics;

import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tinypieces.tinypiecesfabric.TinyPieces;

public class TinyPiecesStatistics {

	public static Identifier EAT_APPLE_PIE_SLICE = register("eat_apple_pie_slice");
	public static Identifier EAT_HONEY_PIE_SLICE = register("eat_honey_pie_slice");
	public static Identifier EAT_CHERRY_PIE_SLICE = register("eat_cherry_pie_slice");

	public static Identifier register(String name) {
		return register(name, StatFormatter.DEFAULT);
	}

	public static Identifier register(String name, StatFormatter statFormatter) {
		Identifier identifier = TinyPieces.id(name);
		Identifier statistic = Registry.register(Registry.CUSTOM_STAT, identifier, identifier);
		Stats.CUSTOM.getOrCreateStat(identifier, statFormatter);
		return statistic;
	}

	public static void init() {
	}
}
