package com.factoriaf5.kata;

public enum Faction {
    ORDER_OF_THE_RADIANT_DAWN("The Order of the Radiant Dawn", "A faction of paladins and clerics devoted to light and justice, dedicated to protecting the world from dark forces and evil."),
    CHILDREN_OF_CHAOS("The Children of Chaos", "A group of rebels and mercenaries who value freedom and disorder. They operate outside the law and often come into conflict with authorities and other established factions."),
    ARCANE_CONCLAVE("The Arcane Conclave", "An organization of wizards and sorcerers seeking knowledge and power through magic. They are dedicated to the study of the arcane arts and the preservation of ancient magical secrets.");

    private final String name;
    private final String description;

    Faction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
