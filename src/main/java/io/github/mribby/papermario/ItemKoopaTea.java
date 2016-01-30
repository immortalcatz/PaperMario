package io.github.mribby.papermario;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemKoopaTea extends ItemDrink {
    public ItemKoopaTea() {
        super(0, Game.PM, Game.PMTTYD, Game.SPM);
        setAlwaysDrinkable();
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".koopaTea");
        setTextureName(PaperMarioMod.MOD_ID + ":koopa_tea");
    }

    @Override
    protected void onDrink(ItemStack stack, World world, EntityPlayer player) {
        super.onDrink(stack, world, player);

        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 20 * 20, 1));
        }
    }
}
