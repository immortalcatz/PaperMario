package io.github.mribby.papermario;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "papermario", name = "Paper Mario Mod", version = "0.1")
public class PaperMario {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Recipes.registerRecipes();
        PaperMarioItems.registerItems();
    }
}
