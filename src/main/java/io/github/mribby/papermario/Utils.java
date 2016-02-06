package io.github.mribby.papermario;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class Utils {
    private static final float MAX_PLAYER_HEALTH = 20.0F;

    /**
     * Converts Paper Mario HP to Minecraft health
     *
     * @param hp Paper Mario heart points (HP)
     * @return Minecraft health
     */
    public static int getHealthIntFromHP(int hp) {
        return (int) getHealthFloatFromHP(hp);
    }

    /**
     * Converts Paper Mario HP to Minecraft health
     *
     * @param hp Paper Mario heart points (HP)
     * @return Minecraft health
     */
    public static float getHealthFloatFromHP(int hp) {
        if (hp == 0) return 1;

        float health;
        float divisor = 1F;

        do {
            divisor *= 2F;
            health = hp / divisor;
        } while (health >= MAX_PLAYER_HEALTH);

        return health;
    }

    public static int getArmorPosition(Item item) {
        if (item instanceof ItemArmor) {
            switch (((ItemArmor) item).armorType) {
                case 0:
                    return 4;
                case 1:
                    return 3;
                case 2:
                    return 2;
                case 3:
                    return 1;
            }
        }

        return 0;
    }
}
