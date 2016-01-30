package io.github.mribby.papermario;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = PaperMarioMod.MOD_ID, name = "Paper Mario Mod", version = "0.1")
public class PaperMarioMod {
    public static final String MOD_ID = "papermario";
    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PaperMarioItems.registerItems();
        Recipes.registerRecipes();
        MinecraftForge.EVENT_BUS.register(new PaperMarioEventHandler());

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MOD_ID);
        network.registerMessage(MessageLifeShroom.class, MessageLifeShroom.class, 0, Side.CLIENT);
    }
}
