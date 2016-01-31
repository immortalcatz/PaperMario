package io.github.mribby.papermario.item.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.Random;

public abstract class PaperMarioRecipe implements IRecipe {
    private final int size;
    private final ItemStack output;
    protected boolean matches;
    protected Random random;

    public PaperMarioRecipe(int size) {
        this(size, null);
    }

    public PaperMarioRecipe(int size, ItemStack output) {
        this.size = size;
        this.output = output;
    }

    public void reset(InventoryCrafting crafting, World world) {
        matches = false;
        random = world.rand;
    }

    @Override
    public boolean matches(InventoryCrafting crafting, World world) {
        reset(crafting, world);

        for (int i = 0; i < crafting.getSizeInventory(); i++) {
            ItemStack stack = crafting.getStackInSlot(i);

            if (stack != null) {
                matches = matches(crafting, world, stack, stack.getItem());
                if (!matches) return false;
            }
        }

        return matches;
    }

    public abstract boolean matches(InventoryCrafting crafting, World world, ItemStack stack, Item item);

    public abstract ItemStack getCraftingResult(InventoryCrafting crafting);

    @Override
    public int getRecipeSize() {
        return size;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output;
    }
}
