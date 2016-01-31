package io.github.mribby.papermario.item.crafting;

import io.github.mribby.papermario.Chef;
import io.github.mribby.papermario.item.PaperMarioItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class RecipeMystery extends PaperMarioRecipe {
    public RecipeMystery() {
        super(1, new ItemStack(PaperMarioItems.miracle_dinner));
    }

    @Override
    public boolean matches(InventoryCrafting crafting, World world, ItemStack stack, Item item) {
        return !matches && item == PaperMarioItems.mystery;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting crafting) {
        List<ItemStack> recipes = Chef.values[random.nextInt(Chef.values.length)].getRecipes();
        return recipes.get(random.nextInt(recipes.size()));
    }
}
