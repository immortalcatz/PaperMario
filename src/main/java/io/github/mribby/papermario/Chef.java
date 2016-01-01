package io.github.mribby.papermario;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static io.github.mribby.papermario.Game.*;

public enum Chef {
    TAYCE_T(PM), ZESS_T(PMTTYD), SAFFRON(SPM), DYLLIS(SPM);

    public static final Chef[] values = Chef.values();
    private final List<ItemStack> recipes = new ArrayList<ItemStack>();
    private final Game game;

    Chef(Game game) {
        this.game = game;
    }

    public void addRecipe(ItemStack stack) {
        recipes.add(stack);
    }

    public List<ItemStack> getRecipes() {
        return recipes;
    }

    public Game getGame() {
        return game;
    }
}
