package com.malfer.trynewways.domain.model;

public enum PersonalType {
    FISICO('F'),
    JURIDICO('J');

    private char personalType;

    PersonalType(char personalType) {
        this.personalType = personalType;
    }

    public char getPersonalType() {
        return personalType;
    }
}
