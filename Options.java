package com.pointer.map;

public enum Options {
    MEMBER, PET, EXIT;

    static Options getOption() {
        try {
            System.out.println("Choose option: MEMBER, PET, EXIT");
            return Options.valueOf(Commands.in.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Option not found. Please enter another option");
            return getOption();
        }
    }
}
