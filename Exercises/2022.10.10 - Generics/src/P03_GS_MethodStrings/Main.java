package P03_GS_MethodStrings;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box();

        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            box.add(element);
        }

        String[] indices = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(indices[0]);
        int secondIndex = Integer.parseInt(indices[1]);
        box.swapIndices(firstIndex, secondIndex);

        System.out.println(box);
    }
}
