package io.github.mribby.papermario;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PaperMarioItemFood extends ItemFood implements IPaperMarioItem {
    private final Game[] games;
    private final CreativeTabs[] tabs;

    public PaperMarioItemFood(int hpHealAmount, int fpHealAmount, boolean isWolfFood, Game... games) {
        super(Utils.getHealthIntFromHP(hpHealAmount), getSaturation(fpHealAmount), isWolfFood);
        this.games = games;
        this.tabs = PaperMarioItem.getTabs(games);
        setCreativeTab(tabs[0]);
    }

    public PaperMarioItemFood(int hpHealAmount, int fpHealAmount, Game... games) {
        this(hpHealAmount, fpHealAmount, false, games);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player) {
        --stack.stackSize;
        player.getFoodStats().addStats(this, stack);
        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        onFoodEaten(stack, world, player);
        return stack;
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
