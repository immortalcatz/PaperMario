package io.github.mribby.papermario;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class ItemBattle extends PaperMarioItem {
    public ItemBattle(Game... games) {
        super(games);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (useItem(stack, world, player, null)) {
            stack.stackSize--;
        }

        return stack;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (useItem(stack, world, player, new MovingObjectPosition(x, y, z, side, Vec3.createVectorHelper(hitX, hitY, hitZ)))) {
            stack.stackSize--;
            return true;
        }

        return false;
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity) {
        if (useItem(stack, entity.worldObj, player, new MovingObjectPosition(entity))) {
            stack.stackSize--;
            return true;
        }

        return false;
    }

    /**
     * @param stack   Item stack
     * @param world   World
     * @param player  Player using the item
     * @param target  Target (air = null, block = MOP, entity = MOP)
     * @return true if used successfully (decreases stack size)
     */
    protected abstract boolean useItem(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition target);
}
