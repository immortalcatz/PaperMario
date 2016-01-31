package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemDizzyDial extends ItemBattle {
    public ItemDizzyDial() {
        super(Game.PM, Game.PMTTYD);
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".dizzyDial");
        setTextureName(PaperMarioMod.MOD_ID + ":dizzy_dial");
    }

    @Override
    protected boolean useItem(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition target) {
        return false;
    }
}
