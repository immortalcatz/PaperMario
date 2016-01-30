package io.github.mribby.papermario;

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
