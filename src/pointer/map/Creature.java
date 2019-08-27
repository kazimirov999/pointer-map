package pointer.map;

public enum Creature {
    PERSON, PET, PETS;

    public static Creature fromString(String value) {
        return valueOf(value.toUpperCase());
    }
}
