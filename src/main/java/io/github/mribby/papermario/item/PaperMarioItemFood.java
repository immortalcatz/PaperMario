package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PaperMarioItemFood extends ItemFood implements IPaperMarioItem {
    private final int hpHealAmount, fpHealAmount;
    private final Game[] games;
    private final CreativeTabs[] tabs;

    public PaperMarioItemFood(int hpHealAmount, int fpHealAmount, boolean isWolfFood, Game... games) {
        super(Utils.getHealthIntFromHP(hpHealAmount), getSaturation(fpHealAmount), isWolfFood);
        this.hpHealAmount = hpHealAmount;
        this.fpHealAmount = fpHealAmount;
        this.games = games;
        this.tabs = PaperMarioItem.getTabs(games);
        setCreativeTab(tabs[0]);
    }

    public PaperMarioItemFood(int hpHealAmount, int fpHealAmount, Game... games) {
        this(hpHealAmount, fpHealAmount, false, games);
    }

    public int getHpHealAmount() {
        return hpHealAmount;
    }

    public int getFpHealAmount() {
        return fpHealAmount;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player) {
        --stack.stackSize;
        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        onFoodEaten(stack, world, player);
        return stack;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.getFoodStats().addStats(this, stack);
    }

    @Override
    public Game[] getGames() {
        return games;
    }

    @Override
    public CreativeTabs[] getCreativeTabs() {
        return tabs;
    }

    private static float getSaturation(int fpHealAmount) {
        return (float) fpHealAmount / 10F;
    }
}
