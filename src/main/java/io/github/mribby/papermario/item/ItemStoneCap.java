package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.PaperMarioMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStoneCap extends ItemArmor implements IPaperMarioItem {
    private static final Game[] GAMES = {Game.PM};

    public ItemStoneCap() {
        super(PaperMarioItems.STONE_CAP_MATERIAL, PaperMarioMod.proxy.getArmorRenderIndex("stone_cap"), 0);
        setCreativeTab(Game.PM.getCreativeTab());
        setUnlocalizedName(PaperMarioMod.MOD_ID + ".stoneCap");
        setTextureName(PaperMarioMod.MOD_ID + ":stone_cap");
    }

    @Override
    public Game[] getGames() {
        return GAMES;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return PaperMarioMod.MOD_ID + ":textures/models/armor/stone_cap.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(PaperMarioItems.STONE_CAP_MODIFIER);

        if (!world.isRemote && world.getTotalWorldTime() % 20 == 0) {
            if (!player.capabilities.isCreativeMode) {
                stack.damageItem(1, player);//TODO
            }
        }
    }
}
