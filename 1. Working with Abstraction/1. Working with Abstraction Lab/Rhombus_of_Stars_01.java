import java.util.Scanner;

public class Rhombus_of_Stars_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int r = 1; r < n; r++) {
            for (int j = 0; j < n - r; j++) {
                System.out.print(" ");
            }
            for (int i = 0; i < r; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
        for (int r = 1; r < n; r++) {
            for (int j = 0; j < r; j++) {
                System.out.print(" ");
            }
            for (int i = 0; i < n - r; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
