package io.github.mribby.papermario.item;

import io.github.mribby.papermario.Game;
import io.github.mribby.papermario.Utils;

public abstract class ItemDamage extends ItemBattle {
    private final float damage;

    public ItemDamage(int damage, Game... games) {
        super(games);
        this.damage = Utils.getHealthFloatFromHP(damage);
    }

    public float getDamage() {
        return damage;
    }

}
