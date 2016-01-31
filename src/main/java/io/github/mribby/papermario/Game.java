package io.github.mribby.papermario;

import io.github.mribby.papermario.item.PaperMarioItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public enum Game {
    PM, PMTTYD, SPM, PMSS;

    private CreativeTabs creativeTab;

    public CreativeTabs getCreativeTab() {
        if (creativeTab == null) {
            creativeTab = new CreativeTabs("papermario." + toString().toLowerCase()) {
                @Override
                public Item getTabIconItem() {
                    switch (Game.this) {
                        default:
                            return PaperMarioItems.mushroom;
                        case PMTTYD:
                            return PaperMarioItems.super_shroom;
                        case SPM:
                            return PaperMarioItems.ultra_shroom;
                    }
                }
            };
        }
        return creativeTab;
    }
}
