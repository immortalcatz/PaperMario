package io.github.mribby.papermario;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ItemBattle extends PaperMarioItem {
    public ItemBattle(Game... games) {
        super(games);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (useItem(UseType.GENERAL, stack, world, player, null)) {
            stack.stackSize--;
        }

        return stack;
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity) {
        if (useItem(UseType.ENTITY, stack, entity.worldObj, player, entity)) {
            stack.stackSize--;
            return true;
        }

        return false;
    }

    /**
     * @param useType Type of use (GENERAL, ENTITY)
     * @param stack Item stack
     * @param world World
     * @param player Player using the item
     * @param target Target entity (null if getUseType() != ENTITY)
     * @return true if used successfully (decreases stack size)
     */
    protected abstract boolean useItem(UseType useType, ItemStack stack, World world, EntityPlayer player, EntityLivingBase target);

    protected enum UseType {
        GENERAL, ENTITY
    }
}
