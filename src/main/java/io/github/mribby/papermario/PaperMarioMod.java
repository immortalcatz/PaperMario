package io.github.mribby.papermario;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import io.github.mribby.papermario.item.PaperMarioItems;
import io.github.mribby.papermario.item.crafting.Recipes;
import io.github.mribby.papermario.network.MessageLifeShroom;
import io.github.mribby.papermario.network.Proxy;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = PaperMarioMod.MOD_ID, name = "Paper Mario Mod", version = "0.1")
public class PaperMarioMod {
    public static final String MOD_ID = "papermario";

    @SidedProxy(clientSide = "io.github.mribby.papermario.network.ProxyClient", serverSide = "io.github.mribby.papermario.network.Proxy")
    public static Proxy proxy;
    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PaperMarioItems.registerItems();
        Recipes.registerRecipes();

        PaperMarioEventHandler eventHandler = new PaperMarioEventHandler();
        MinecraftForge.EVENT_BUS.register(eventHandler);
        FMLCommonHandler.instance().bus().register(eventHandler);

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MOD_ID);
        network.registerMessage(MessageLifeShroom.class, MessageLifeShroom.class, 0, Side.CLIENT);
    }
}
