package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStrangeCake extends PaperMarioItemFood {
    public ItemStrangeCake() {
        super(0, 0, Game.PM);
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".strangeCake");
        setTextureName(PaperMarioMod.MOD_ID + ":strange_cake");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        //TODO
    }
}
