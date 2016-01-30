package io.github.mribby.papermario;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class PaperMarioEventHandler {
    private static final float LIFE_SHROOM_HEAL_AMOUNT = Utils.getHealthFloatFromHP(10);

    @SubscribeEvent
    public void onEntityLivingDeath(LivingDeathEvent event) {
        EntityLivingBase entity = event.entityLiving;
        boolean isCanceled = false;

        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            if (player.inventory.consumeInventoryItem(PaperMarioItems.life_shroom)) {
                isCanceled = true;
            }
        } else {
            ItemStack stack = entity.getHeldItem();

            if (stack != null && stack.getItem() == PaperMarioItems.life_shroom) {
                entity.setCurrentItemOrArmor(0, null);
                isCanceled = true;
            }
        }

        if (isCanceled) {
            entity.setHealth(LIFE_SHROOM_HEAL_AMOUNT);
            PaperMarioMod.network.sendToDimension(new MessageLifeShroom(entity), entity.dimension);
            event.setCanceled(true);
        }
    }
}
