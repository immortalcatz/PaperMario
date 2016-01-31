package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemSnowmanDoll extends ItemBattle {
    public ItemSnowmanDoll() {
        super(Game.PM);
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".snowmanDoll");
        setTextureName(PaperMarioMod.MOD_ID + ":snowman_doll");
    }

    @Override
    protected boolean useItem(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition target) {
        return false;
    }
}
