package FirstAndReserveTeam_04;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Team team = new Team("Black Eagles");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            team.addPlayer(new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3])));
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("First team have " + team.getReserveTeam().size() + " players");
    }
}
