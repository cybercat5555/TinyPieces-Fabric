package tinypieces.tinypiecesfabric;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import tinypieces.tinypiecesfabric.blocks.TinyPiecesBlocks;

public class TinyPieces implements ModInitializer {

    public static final String MOD_ID = "tinypiecesfabric";

    @Override
    public void onInitialize() {
        TinyPiecesBlocks.init();
    }

    public static Identifier id(String name) {
        return id(MOD_ID, name);
    }

    public static Identifier id(String namespace, String name) {
        return new Identifier(namespace, name);
    }
}
