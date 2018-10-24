package inputOperations;

import com.sun.javafx.fxml.expression.BinaryExpression;
import inputOperations.expression.ElementRPN;
import inputOperations.expression.ExpressionRPN;
import inputOperations.expression.NumberRPN;
import inputOperations.expression.OperatorRPN;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;

public class InputOperation {
    public static StringBuffer input = new StringBuffer("-5/6+2-5*8");

    private static String expression;

    static String number = ""; // хранилище для числа (например, "54")
    static public String operator = ""; // хранилище для оператора (например, "+")

    NumberRPN numberRPN = new NumberRPN();
    ElementRPN elementRPN = new ElementRPN() {
        @Override
        public int getType() {
            return 0;
        }
    };
    OperatorRPN operatorRPN = new OperatorRPN();

    //для ввода примера
    public String calc() {
        Scanner in = new Scanner(System.in);
        System.out.println("Пожалуйста введите пример: ");
        return expression = String.valueOf(in.nextLine());
    }

    //удаление лишних пробелов
    void correct(){
        for (int i = 0; i < input.length(); i++) {
            String c = String.valueOf(input.charAt(i));
            // удаление не нужных пробелов в выражении
            if (c.equals(" ")) {
                if (i == 0) {
                    input.delete(i, i + 1);
                } else {
                    input.delete(i, i + 1);
                    i--;
                }
            }
        }
//        input.insert(input.length(), " ");
    }

    public void input() {
//        input = new StringBuffer(calc());
        // удаление не нужных пробелов в выражении
        correct();
        input = input.insert(input.length() , " ");
        System.out.println( input);
        String previousOperator = "";
        for (int i = 0; i < input.length(); i++) {
            String c = String.valueOf(input.charAt(i));

            if( (i == 0) && (c.equals("-"))){
                previousOperator = String.valueOf(input.charAt(i)-1);
                System.out.println("Унарный минус " + previousOperator );
            }

            try{
                numberRPN.isType(Integer.valueOf(c));
                number = number + c;

            }catch (Exception ignored){
                elementRPN.add(number);
                number = "";
                operatorRPN.isOperator(previousOperator, c);
            }
        }
    }
}