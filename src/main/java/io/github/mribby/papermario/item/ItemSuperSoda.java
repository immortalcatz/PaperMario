package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemSuperSoda extends ItemDrink {
    public ItemSuperSoda() {
        super(5, Game.PM);
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".superSoda");
        setTextureName(PaperMarioMod.MOD_ID + ":super_soda");
    }

    @Override
    protected void onDrink(ItemStack stack, World world, EntityPlayer player) {
        super.onDrink(stack, world, player);

        if (!world.isRemote) {
            player.removePotionEffect(Potion.poison.getId());
            player.removePotionEffect(Potion.weakness.getId());
        }
    }

    @Override
    protected boolean canUse(ItemStack stack, World world, EntityPlayer player) {
        return super.canUse(stack, world, player) || player.getActivePotionEffect(Potion.poison) != null || player.getActivePotionEffect(Potion.weakness) != null;
    }
}
