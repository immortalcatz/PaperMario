package io.github.mribby.papermario;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDamageThrown extends ItemDamage {
    public ItemDamageThrown(int damage, Game... games) {
        super(damage, games);
    }

    @Override
    protected boolean useItem(UseType useType, ItemStack stack, World world, EntityPlayer player, EntityLivingBase target) {
        if (useType == UseType.GENERAL) {
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }

            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote) {
                //world.spawnEntityInWorld(new EntitySnowball(world, player));
            }

            return true;
        }

        return false;
    }
}
