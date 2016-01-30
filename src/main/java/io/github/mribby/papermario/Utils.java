package io.github.mribby.papermario;

public class Utils {
    private static final float MAX_PLAYER_HEALTH = 20.0F;

    /**
     * Converts Paper Mario HP to Minecraft health
     * @param hp Paper Mario heart points (HP)
     * @return Minecraft health
     */
    public static int getHealthIntFromHP(int hp) {
        return (int) getHealthFloatFromHP(hp);
    }

    /**
     * Converts Paper Mario HP to Minecraft health
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
}
