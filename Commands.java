package com.pointer.map;

import java.util.Scanner;


public enum Commands {
    ADD, REMOVE, REMOVE_PET_FROM_CLUB, SHOW, EXIT;

    static Scanner in = new Scanner(System.in);

    static Commands getCommand() {
        try {
            System.out.println("Enter a command: ADD, REMOVE, REMOVE_PET_FROM_CLUB, SHOW, EXIT");
            return Commands.valueOf(in.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Command not found. Please enter another command");
            return getCommand();
        }
    }


}


