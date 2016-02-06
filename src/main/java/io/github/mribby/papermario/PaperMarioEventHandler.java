package io.github.mribby.papermario;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import io.github.mribby.papermario.item.PaperMarioItems;
import io.github.mribby.papermario.network.MessageLifeShroom;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class PaperMarioEventHandler {
    private static final float LIFE_SHROOM_HEAL_AMOUNT = Utils.getHealthFloatFromHP(10);

    @SubscribeEvent
    public void onEntityLivingDeath(LivingDeathEvent event) {
        EntityLivingBase entity = event.entityLiving;
        boolean revive = false;

        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            if (player.inventory.consumeInventoryItem(PaperMarioItems.life_shroom)) {
                revive = true;
            }
        } else {
            ItemStack stack = entity.getHeldItem();

            if (stack != null && stack.getItem() == PaperMarioItems.life_shroom) {
                entity.setCurrentItemOrArmor(0, null);
                revive = true;
            }
        }

        if (revive) {
            entity.setHealth(LIFE_SHROOM_HEAL_AMOUNT);
            PaperMarioMod.network.sendToDimension(new MessageLifeShroom(entity), entity.dimension);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onEntityLivingHurt(LivingHurtEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            ItemStack helmet = event.entityLiving.getEquipmentInSlot(Utils.getArmorPosition(PaperMarioItems.stone_cap));

            if (helmet != null && helmet.getItem() == PaperMarioItems.stone_cap) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            IAttributeInstance speedAttribute = event.player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);

            if (speedAttribute.getModifier(PaperMarioItems.STONE_CAP_MODIFIER.getID()) != null) {
                speedAttribute.removeModifier(PaperMarioItems.STONE_CAP_MODIFIER);
            }
        }
    }
}
