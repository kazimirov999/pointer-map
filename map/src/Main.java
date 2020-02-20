import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ZooClub zooClub = new ZooClub();
        zooClub.menu();
        while (true) {
            switch (reader.readLine()) {
                case "1":
                    zooClub.addPerson();
                    break;
                case "2":
                    zooClub.addPet();
                    break;
                case "3":
                    zooClub.removePet();
                    break;
                case "4":
                    zooClub.removePerson();
                    break;
                case "5":
                    zooClub.removeAllPet();
                    break;
                case "6":
                    zooClub.printZoo();
                    break;
                case "0":
                    return;
                default:
                    zooClub.menu();
                    break;
            }
        }
    }
}
