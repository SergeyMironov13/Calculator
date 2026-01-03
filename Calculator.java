import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
        if (y == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return x / y;
    };
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2); // 3
        int b = calc.minus.apply(1, 1); // 0
        int c = calc.devide.apply(a, b); // 3/0
        calc.println.accept(c);  //данная программа не работает, потому что на 0 делить нельзя
    }

}
