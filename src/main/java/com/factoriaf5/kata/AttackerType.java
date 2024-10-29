package com.factoriaf5.kata;

public enum AttackerType{
    MELEE(2),
    RANGED(20);

    private final Integer attackRangeMeters;

    AttackerType(Integer attackRangeMeters){
        this.attackRangeMeters=attackRangeMeters;
    }

    public Integer getAttackRangeMeters() {
        return attackRangeMeters;
    }
}