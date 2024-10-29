package com.factoriaf5.kata;

import java.util.Set;
import java.util.TreeSet;

public class Character implements Attackable{
    private Integer health;
    private Integer level;
    private boolean alive;
    private Integer attackPower;
    private AttackerType attackerType;
    private Integer position;
    private final Set<Faction> factions;

    public Character(AttackerType attackerType) {
        this.alive = true;
        this.health = 1000;
        this.level = 1;
        this.attackPower = 200;
        this.attackerType = attackerType;
        this.position = 0;
        this.factions = new TreeSet<>();
    }

    public Integer getAttackRangeMeters() {
        return this.attackerType.getAttackRangeMeters();
    }

    public AttackerType getAttackerType() {
        return attackerType;
    }

    public void setAttackerType(AttackerType attackerType) {
        this.attackerType = attackerType;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Set<Faction> getFactions() {
        return factions;
    }

    public boolean joinFaction(Faction f){
        return this.factions.add(f);
    }

    public boolean leaveFaction(Faction f){
        return this.factions.remove(f);
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public Integer getAttackPower() {
        return attackPower;
    }

    public void setHealth(Integer health) {
        this.health = health;
        this.setAlive(this.health > 0);
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        this.health = this.alive?this.health:0;
    }

    public void setAttackPower(Integer attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public boolean acceptAttack(Character attacker) {
        if(!this.equals(attacker)&&Math.abs(this.position-attacker.getPosition())<=attacker.getAttackRangeMeters()&&!Character.areAllies(this, attacker)&&this.isAlive()){
            Integer damage = (int)(this.level-attacker.getLevel()>=5?this.attackPower*0.5:attacker.getLevel()-this.level>=5?this.attackPower*1.5:this.attackPower);
            this.setHealth((this.getHealth()-damage)<0?0:this.getHealth()-damage);
            return true;
        }else{
            return false;
        }
    }

    public static boolean areAllies(Character c1,Character c2){
        for(Faction f1:c1.factions){
            for(Faction f2:c2.factions){
                if(f1==f2)return true;
            }
        }
        return false;
    }

    public boolean attack(Character c){
        return c.acceptAttack(this);
    }

    public boolean attack(Prop p){
        return p.acceptAttack(this);
    }

    public boolean heal(Character c){
        if(c.getHealth()<1000&&c.isAlive()&&(this.equals(c)||Character.areAllies(this, c))){
            c.setHealth(1000);
            return true;
        }else{
            return false;
        }
    }
    
}
