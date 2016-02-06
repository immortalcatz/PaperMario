package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemRepelGel extends ItemBattle {
    public ItemRepelGel() {
        super(Game.PM);
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".repelGel");
        setTextureName(PaperMarioMod.MOD_ID + ":repel_gel");
    }

    @Override
    protected boolean useItem(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition target) {
        if (target != null) return false;

        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 20 * 20));
        }

        return true;
    }
}
