package io.github.mribby.papermario.item.crafting;

import io.github.mribby.papermario.item.PaperMarioItemFood;
import io.github.mribby.papermario.item.PaperMarioItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RecipeSpaceFood extends PaperMarioRecipe {
    private final ItemStack spaceFood = new ItemStack(PaperMarioItems.space_food);
    private boolean hasDriedBoquet;
    private boolean hasHealingItem;

    public RecipeSpaceFood() {
        super(2);
    }

    @Override
    public void reset(InventoryCrafting crafting, World world) {
        super.reset(crafting, world);
        hasDriedBoquet = false;
        hasHealingItem = false;
    }

    @Override
    public boolean matches(InventoryCrafting crafting, World world, ItemStack stack, Item item) {
        if (item == PaperMarioItems.dried_bouquet) {
            if (hasDriedBoquet) return false;
            hasDriedBoquet = true;
        } else if (item instanceof PaperMarioItemFood) {
            PaperMarioItemFood food = (PaperMarioItemFood) item;
            if (food.getHpHealAmount() == 0 && food.getFpHealAmount() == 0) return false;
            if (hasHealingItem) return false;
            hasHealingItem = true;
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
