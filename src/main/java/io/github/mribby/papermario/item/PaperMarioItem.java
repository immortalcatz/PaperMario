package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PaperMarioItem extends Item implements IPaperMarioItem {
    private final Game[] games;
    private final CreativeTabs[] tabs;

    public PaperMarioItem(Game... games) {
        this.games = games;
        this.tabs = getTabs(games);
        setCreativeTab(tabs[0]);
    }

    public static CreativeTabs[] getTabs(Game... games) {
        CreativeTabs[] tabs = new CreativeTabs[games.length];
        for (int i = 0; i < games.length; i++) {
            tabs[i] = games[i].getCreativeTab();
        }
        return tabs;
    }

    @Override
    public Game[] getGames() {
        return games;
    }

    @Override
    public CreativeTabs[] getCreativeTabs() {
        return tabs;
    }
}
