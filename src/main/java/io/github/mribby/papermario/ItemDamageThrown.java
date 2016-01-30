package io.github.mribby.papermario;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemDamageThrown extends ItemDamage {
    public ItemDamageThrown(int damage, Game... games) {
        super(damage, games);
    }

    @Override
    protected boolean useItem(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition target) {
        if (target == null) {
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }

            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote) {
                world.spawnEntityInWorld(new EntitySnowball(world, player));
            }

            return true;
        }

        return false;
    }
}
