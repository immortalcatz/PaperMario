package io.github.mribby.papermario;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RecipeSpaceFood extends PaperMarioRecipe {
    private final ItemStack spaceFood = new ItemStack(PaperMarioItems.space_food);
    private boolean hasDriedBoquet;
    private boolean hasHPFPItem;

    public RecipeSpaceFood() {
        super(2);
    }

    @Override
    public void reset(InventoryCrafting crafting, World world) {
        super.reset(crafting, world);
        hasDriedBoquet = false;
        hasHPFPItem = false;
    }

    @Override
    public boolean matches(InventoryCrafting crafting, World world, ItemStack stack, Item item) {
        if (item == PaperMarioItems.dried_bouquet) {
            if (hasDriedBoquet) return false;
            hasDriedBoquet = true;
        } else if (item instanceof PaperMarioItem) {//TODO
            if (hasHPFPItem) return false;
            hasHPFPItem = true;
        } else {
            return false;
        }

        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting crafting) {
        return spaceFood;
    }
}
