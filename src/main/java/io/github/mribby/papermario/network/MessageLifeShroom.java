package io.github.mribby.papermario.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import java.util.Random;

public class MessageLifeShroom implements IMessage, IMessageHandler<MessageLifeShroom, IMessage> {
    private double posX, posY, posZ;
    private float width, height;
    
    public MessageLifeShroom() {}

    public MessageLifeShroom(Entity entity) {
        this.posX = entity.posX;
        this.posY = entity.posY;
        this.posZ = entity.posZ;
        this.width = entity.width;
        this.height = entity.height;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        posX = buf.readDouble();
        posY = buf.readDouble();
        posZ = buf.readDouble();
        width = buf.readFloat();
        height = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(posX);
        buf.writeDouble(posY);
        buf.writeDouble(posZ);
        buf.writeFloat(width);
        buf.writeFloat(height);
    }

    @Override
    public IMessage onMessage(MessageLifeShroom message, MessageContext ctx) {
        World world = FMLClientHandler.instance().getWorldClient();
        Random rand = world.rand;

        for (int i = 0; i < 7; ++i) {
            double x = message.posX + (double) (rand.nextFloat() * message.width * 2.0F) - (double) message.width;
            double y = message.posY + 0.5D + (double) (rand.nextFloat() * message.height);
            double z = message.posZ + (double) (rand.nextFloat() * message.width * 2.0F) - (double) message.width;
            double velX = rand.nextGaussian() * 0.02D;
            double velY = rand.nextGaussian() * 0.02D;
            double velZ = rand.nextGaussian() * 0.02D;
            world.spawnParticle("happyVillager", x, y, z, velX, velY, velZ);
        }

        return null;
    }
}
