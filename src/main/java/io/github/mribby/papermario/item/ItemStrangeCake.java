package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemStrangeCake extends PaperMarioItemFood {
    private static final Potion[] POTIONS = {Potion.damageBoost, Potion.invisibility, Potion.confusion};

    public ItemStrangeCake() {
        super(0, 0, Game.PM);
        setAlwaysEdible();
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".strangeCake");
        setTextureName(PaperMarioMod.MOD_ID + ":strange_cake");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            Potion potion = POTIONS[world.rand.nextInt(POTIONS.length)];
            player.addPotionEffect(new PotionEffect(potion.getId(), 20 * 20, 1));
        }
    }
}
