import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04_AppliedArithmetics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> list = Arrays.stream(input.split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

//        Consumer<List<Integer>> consumer = numbers -> numbers.replaceAll(e -> e + 1);

        UnaryOperator<List<Integer>> addFunction = numbers -> numbers.stream().map(number -> number + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunction = numbers -> numbers.stream().map(number -> number * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunction = numbers -> numbers.stream().map(number -> number - 1).collect(Collectors.toList());

        Consumer<List<Integer>> printer = numbers -> numbers.forEach(number -> System.out.print(number + " "));

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    list = addFunction.apply(list);
                    break;

                case "multiply":
                    list = multiplyFunction.apply(list);
                    break;

                case "subtract":
                    list = subtractFunction.apply(list);
                    break;

                case "print":
                    printer.accept(list);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
