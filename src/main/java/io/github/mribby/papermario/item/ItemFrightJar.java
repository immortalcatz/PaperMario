package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemFrightJar extends ItemBattle {
    public ItemFrightJar() {
        super(Game.PM);
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".frightJar");
        setTextureName(PaperMarioMod.MOD_ID + ":fright_jar");
    }

    @Override
    protected boolean useItem(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition target) {
        return false;
    }
}
