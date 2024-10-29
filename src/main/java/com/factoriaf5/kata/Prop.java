package com.factoriaf5.kata;

public class Prop implements Attackable{
    private Integer health;
    private boolean destroyed;
    private Integer position;

    public Prop(Integer health) {
        this.destroyed = false;
        this.health = health;
        this.position = 0;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
        this.setDestroyed(health==0);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean acceptAttack(Character attacker) {
        if(Math.abs(this.position-attacker.getPosition())<=attacker.getAttackRangeMeters()&&!this.isDestroyed()){
            Integer damage = attacker.getAttackPower();
            this.setHealth((this.getHealth()-damage)<0?0:this.getHealth()-damage);
            return true;
        }else{
            return false;
        }
    }

}
