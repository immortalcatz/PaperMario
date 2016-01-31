package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDrink extends PaperMarioItem {
    private final float healAmount;
    private boolean alwaysDrinkable;

    public ItemDrink(int fpHealAmount, Game... games) {
        super(games);
        this.healAmount = Utils.getHealthFloatFromHP(fpHealAmount);
    }

    public float getHealAmount() {
        return healAmount;
    }

    public ItemDrink setAlwaysDrinkable() {
        alwaysDrinkable = true;
        return this;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }

        onDrink(stack, world, player);
        return stack;
    }

    protected void onDrink(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.heal(healAmount);
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.drink;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (canUse(stack, world, player)) {
            player.setItemInUse(stack, getMaxItemUseDuration(stack));
        }

        return stack;
    }

    protected boolean canUse(ItemStack stack, World world, EntityPlayer player) {
        return alwaysDrinkable || player.shouldHeal();
    }
}
