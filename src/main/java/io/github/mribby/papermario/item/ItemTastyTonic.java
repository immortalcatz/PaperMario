package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemTastyTonic extends ItemDrink {
    public ItemTastyTonic() {
        super(0, Game.PM, Game.PMTTYD);
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".tastyTonic");
        setTextureName(PaperMarioMod.MOD_ID + ":tasty_tonic");
    }

    @Override
    protected void onDrink(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.removePotionEffect(Potion.poison.getId());
            player.removePotionEffect(Potion.weakness.getId());
        }
    }

    @Override
    protected boolean canUse(ItemStack stack, World world, EntityPlayer player) {
        return player.getActivePotionEffect(Potion.poison) != null || player.getActivePotionEffect(Potion.weakness) != null;
    }
}
