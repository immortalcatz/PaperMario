package io.github.mribby.papermario.item.crafting;

import io.github.mribby.papermario.item.IPaperMarioItem;
import io.github.mribby.papermario.item.PaperMarioItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipeMistake implements IRecipe {
    private static boolean isFindingRecipe = false;
    private final ItemStack mistake1 = new ItemStack(PaperMarioItems.mistake, 1, 0);
    private final ItemStack mistake2 = new ItemStack(PaperMarioItems.mistake, 1, 1);
    private ItemStack result;

    @Override
    public boolean matches(InventoryCrafting crafting, World world) {
        if (isFindingRecipe) return false;

        Item item1 = null;
        Item item2 = null;

        for (int i = 0; i < crafting.getSizeInventory(); i++) {
            ItemStack stack = crafting.getStackInSlot(i);
            if (stack == null) continue;

            if (stack.getItem() instanceof IPaperMarioItem) {
                if (item1 == null) {
                    item1 = stack.getItem();
                } else if (item2 == null) {
                    item2 = stack.getItem();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (item1 == null || item1 == item2) {
            return false;
        } else if (item1 == PaperMarioItems.sleepy_sheep && item2 == null) {
            result = mistake2;
            return true;
        } else {
            result = mistake1;
            isFindingRecipe = true;
            ItemStack output = CraftingManager.getInstance().findMatchingRecipe(crafting, world);
            isFindingRecipe = false;
            return output == null;
        }
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting crafting) {
        return result;
    }

    @Override
    public int getRecipeSize() {
        return 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}
