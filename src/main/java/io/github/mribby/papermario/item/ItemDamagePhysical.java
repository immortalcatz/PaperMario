package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemDamagePhysical extends ItemDamage {
    public ItemDamagePhysical(int damage, Game... games) {
        super(damage, games);
    }

    @Override
    protected boolean useItem(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition target) {
        if (target.entityHit != null) {
            if (!world.isRemote) {
                target.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(player), getDamage());
            }

            return true;
        }

        return false;
    }
}
