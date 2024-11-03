package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    @Test
    public void testAreAllies() {
        Character c1;
        Character c2;
        c1 = new Character(AttackerType.MELEE);
        c2 = new Character(AttackerType.MELEE);
        c1.joinFaction(Faction.ARCANE_CONCLAVE);
        c2.joinFaction(Faction.ARCANE_CONCLAVE);
        assertTrue(Character.areAllies(c1, c2));
    }

    @Test
    public void testAreNotAllies() {
        Character c1;
        Character c2;
        c1 = new Character(AttackerType.MELEE);
        c2 = new Character(AttackerType.MELEE);
        c1.joinFaction(Faction.ARCANE_CONCLAVE);
        c2.joinFaction(Faction.CHILDREN_OF_CHAOS);
        assertFalse(Character.areAllies(c1, c2));
    }

    @Test
    public void testAlliesCanBeHealedIfHealthIsNotFull() {
        Character c1;
        Character c2;
        c1 = new Character(AttackerType.MELEE);
        c2 = new Character(AttackerType.MELEE);
        c1.joinFaction(Faction.ARCANE_CONCLAVE);
        c2.joinFaction(Faction.ARCANE_CONCLAVE);
        c2.setHealth(500);
        assertTrue(c1.heal(c2));
        assertTrue(c2.getHealth()==1000);
    }

    @Test
    public void testSelfCanBeHealedIfHealthIsNotFull() {
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        c1.setHealth(500);
        assertTrue(c1.heal(c1));
        assertTrue(c1.getHealth()==1000);
    }

    @Test
    public void testAlliesCannotBeHealedIfHealthIsFull() {
        Character c1;
        Character c2;
        c1 = new Character(AttackerType.MELEE);
        c2 = new Character(AttackerType.MELEE);
        c1.joinFaction(Faction.ARCANE_CONCLAVE);
        c2.joinFaction(Faction.ARCANE_CONCLAVE);
        assertFalse(c1.heal(c2));
    }

    @Test
    public void testSelfCannotBeHealedIfHealthIsFull() {
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        assertFalse(c1.heal(c1));
    }

    @Test
    public void testAlliesCannotBeHealedIfNotAlive() {
        Character c1;
        Character c2;
        c1 = new Character(AttackerType.MELEE);
        c2 = new Character(AttackerType.MELEE);
        c1.joinFaction(Faction.ARCANE_CONCLAVE);
        c2.joinFaction(Faction.ARCANE_CONCLAVE);
        c2.setAlive(false);
        assertFalse(c1.heal(c2));
    }

    @Test
    public void testSelfCannotBeHealedIfNotAlive() {
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        c1.setAlive(false);
        assertFalse(c1.heal(c1));
    }

    @Test
    public void testPropsCanBeAttacked() {
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        Prop p1;
        p1 = new Prop(2000);
        assertTrue(c1.attack(p1));
    }

    @Test
    public void testCharactersCanBeAttacked() {
        Character c1;
        Character c2;
        c1 = new Character(AttackerType.MELEE);
        c2 = new Character(AttackerType.MELEE);
        assertTrue(c1.attack(c2));
    }

    @Test
    public void testPropsCannotBeAttackedIfOutOfRange() {
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        Prop p1;
        p1 = new Prop(2000);
        p1.setPosition(20);
        assertFalse(c1.attack(p1));
    }

    @Test
    public void testCharactersCannotBeAttackedIfOutOfRange() {
        Character c1;
        Character c2;
        c1 = new Character(AttackerType.MELEE);
        c2 = new Character(AttackerType.MELEE);
        c1.setPosition(20);
        assertFalse(c1.attack(c2));
    }

    @Test
    public void testPropsCannotBeAttackedIfDestroyed() {
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        Prop p1;
        p1 = new Prop(2000);
        p1.setDestroyed(true);
        assertFalse(c1.attack(p1));
    }

    @Test
    public void testCharactersCannotBeAttackedIfDead() {
        Character c1;
        Character c2;
        c1 = new Character(AttackerType.MELEE);
        c2 = new Character(AttackerType.MELEE);
        c2.setAlive(false);
        assertFalse(c1.attack(c2));
    }

    @Test
    public void testCanJoinFactions(){
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        assertTrue(c1.joinFaction(Faction.ARCANE_CONCLAVE));
    }

    @Test
    public void testCanLeaveFactions(){
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        c1.joinFaction(Faction.ARCANE_CONCLAVE);
        assertTrue(c1.leaveFaction(Faction.ARCANE_CONCLAVE));
    }

    @Test
    public void testDamageCalculationWithLevelAdvantage(){
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        c1.setLevel(6);
        Character c2;
        c2 = new Character(AttackerType.MELEE);
        c1.attack(c2);
        assertTrue(c2.getHealth()==(1000-(int)c1.getAttackPower()*1.5));
    }

    @Test
    public void testDamageCalculationWithLevelDisadvantage(){
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        c1.setLevel(6);
        Character c2;
        c2 = new Character(AttackerType.MELEE);
        c2.attack(c1);
        assertTrue(c1.getHealth()==(1000-(int)c1.getAttackPower()*0.5));
    }

    @Test
    public void testRawDamageCalculation(){
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        Character c2;
        c2 = new Character(AttackerType.MELEE);
        c2.attack(c1);
        assertTrue(c1.getHealth()==(1000-c1.getAttackPower()));
    }

    @Test
    public void testHealthIsZeroIfDead(){
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        c1.setAlive(false);
        assertTrue(c1.getHealth()==0);
    }

    @Test
    public void testDeadIfHealthIsZero(){
        Character c1;
        c1 = new Character(AttackerType.MELEE);
        c1.setHealth(0);
        assertFalse(c1.isAlive());
    }


}
