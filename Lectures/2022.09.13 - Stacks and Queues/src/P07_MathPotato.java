import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] playersArr = input.split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : playersArr) {
            queue.offer(child);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
                
                if (isPrime(cycle)) {
                    System.out.println("Prime " + queue.peek());
                } else {
                    System.out.println("Removed " + queue.poll());
                }

                cycle++;
            }
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else if(number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= (int) Math.sqrt(number) ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }
}
