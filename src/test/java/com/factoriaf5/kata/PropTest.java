package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PropTest {
    @Test
    void isDestroyedWhenHealthIsSetToZero() {
        Prop p = new Prop(2000);
        p.setHealth(0);
        assertTrue(p.isDestroyed());
    }

    @Test
    void returnsPosition() {
        Prop p = new Prop(2000);
        p.setPosition(20);
        assertTrue(p.getPosition()==20);
    }

    @Test
    void HealthCannotBeLowerThanZeroWhenReceivingAnAttack() {
        Prop p = new Prop(2000);
        Character c = new Character(AttackerType.MELEE);
        c.setAttackPower(3000);
        p.acceptAttack(c);
        assertTrue(p.getHealth()==0);
    }
}
