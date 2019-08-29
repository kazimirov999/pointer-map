package com.pointer.map;

import java.io.*;
import java.rmi.NoSuchObjectException;
import java.util.*;

public class ZooClub {

    Scanner in = new Scanner(System.in);
    private Map<Member, List<Pet>> zooMap;
    private int idCounter;

    public ZooClub() {
        this.zooMap = new HashMap<>();
        this.idCounter = 0;
    }

    @Override
    public String toString() {
        return "ZooClub{" +
                "zooMap=" + zooMap +
                '}';
    }

    public Map<Member, List<Pet>> getZooMap() {
        return zooMap;
    }

    void startMenu() {
        boolean flg = true;
        while (flg) {
            switch (Commands.getCommand()) {
                case ADD:
                    add();
                    break;
                case REMOVE:
                    remove();
                    break;
                case REMOVE_PET_FROM_CLUB:
                    removePetFromAllMembers(new Pet(in.next(), in.nextInt()));
                    break;
                case SHOW:
                    show();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    flg = false;
                    break;
            }
        }
    }

    private void add() {
        switch (Options.getOption()) {
            case MEMBER:
                System.out.println("Enter member");
                addMember(new Member(in.next(), idCounter));
                break;
            case PET:
                System.out.println("Enter member");
                addPetToMember(new Member(in.next(), in.nextInt()));
                break;
            case EXIT:
                return;
        }
    }

    private void addMember(Member member) {
        if (zooMap.containsKey(member)) {
            System.out.println("This member is already present. Returning");
        } else {
            zooMap.put(member, new LinkedList<Pet>());
            idCounter++;
        }
    }

    private void addPetToMember(Member member) {
        if (zooMap.containsKey(member)) {
            System.out.println("Enter pet: Name, Age");
            zooMap.get(member).add(new Pet(in.next(), in.nextInt()));
        } else {
            System.out.println("Member not found. Returning");
        }
    }

    private void remove() {
        switch (Options.getOption()) {
            case MEMBER:
                System.out.println("Enter member");
                removeMember(new Member(in.next(), in.nextInt()));
                break;
            case PET:
                System.out.println("Enter member");
                removePetFromMember(new Member(in.next(), in.nextInt()));
                break;
            case EXIT:
                return;
        }
    }


    private void removeMember(Member member) {
        if (zooMap.containsKey(member)) {
            zooMap.remove(member);
        } else {
            System.out.println("Member not found. Returning");
        }
    }

    private void removePetFromMember(Member member) {
        if (zooMap.containsKey(member)) {
            System.out.println("Enter pet: Name, Age");
            try {
                zooMap.get(member).remove(new Pet(in.nextLine(), in.nextInt()));
            } catch (IllegalArgumentException e) {
                System.out.println("Pet not found");
            }
        } else {
            System.out.println("Member not found. Returning");
        }
    }

    private void removePetFromAllMembers(Pet pet) {
        for (Map.Entry<Member, List<Pet>> entry : zooMap.entrySet()) {
            entry.getValue().remove(pet);
        }
    }

    void show() {
        System.out.println(getZooMap());
    }


}
