package io.github.mribby.papermario;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PaperMarioItem extends Item {
    private final Game[] games;
    private final CreativeTabs[] tabs;

    public PaperMarioItem(Game... games) {
        this.games = games;
        this.tabs = new CreativeTabs[games.length];
        for (int i = 0; i < games.length; i++) {
            this.tabs[i] = games[i].getCreativeTab();
        }
    }

    public Game[] getGames() {
        return games;
    }

    @Override
    public CreativeTabs[] getCreativeTabs() {
        return tabs;
    }
}
