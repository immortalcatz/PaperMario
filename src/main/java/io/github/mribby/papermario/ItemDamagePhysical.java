package io.github.mribby.papermario;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemDamagePhysical extends ItemDamage {
    public ItemDamagePhysical(int damage, Game... games) {
        super(damage, games);
    }

    @Override
    protected boolean useItem(UseType useType, ItemStack stack, World world, EntityPlayer player, EntityLivingBase target) {
        if (useType == UseType.ENTITY) {
            if (!target.worldObj.isRemote) {
                target.attackEntityFrom(DamageSource.causePlayerDamage(player), getDamage());
            }

            return true;
        }

        return false;
    }
}
