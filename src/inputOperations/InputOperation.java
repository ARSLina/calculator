package inputOperations;

import com.sun.javafx.fxml.expression.BinaryExpression;
import inputOperations.expression.ElementRPN;
import inputOperations.expression.NumberRPN;
import inputOperations.expression.OperatorRPN;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;

public class InputOperation {
    private static StringBuffer input;

    private static String expression;
    private static String trig = ""; //счетчик кол-ва скобок
    private static String inpTrig = ""; // триггер для отображения выражения, если не пуст, то показывам
    private static String expTrig = ""; // триггер для вводв выражения, если не пуст, то показывам

    NumberRPN numberRPN = new NumberRPN();
    ElementRPN elementRPN = new ElementRPN() {
        @Override
        public int getType() {
            return 0;
        }
    };
    OperatorRPN operatorRPN = new OperatorRPN() {
        public boolean isOperator(String name) {
            return false;
        }
        public OperatorRPN getOperator(String name) {
            return null;
        }
    };

    //для ввода примера
    public String calc() {
        Scanner in = new Scanner(System.in);
        System.out.println("Пожалуйста введите пример: ");
        return expression = String.valueOf(in.nextLine());
    }
/***/
    public static Double handleOperation(double x, double y,  BinaryOperator<Double> converter){
        return converter.apply(x,y);
    }
/***/
    public void input() {
//        if (expTrig.equals("")) {
            input = new StringBuffer(calc());
//        BinaryOperator<Integer> sum= (x, y) -> x + y;
//        BinaryOperator<Double> sentence = (x, y) -> x + y;
//


        System.out.println("эм "+  handleOperation(1, 2, (a, b) -> a + b));

//        input = new StringBuffer("4+(6-3)/2");
//            expTrig = "1";
//        }
        for (int i = 0; i < input.length(); i++) {
            String c = String.valueOf(input.charAt(i));
            //проверяем на число
            try {
                String.valueOf(numberRPN.isType(Integer.valueOf(c)));
                elementRPN.add(c);
            }catch (NumberFormatException e){
                System.out.println("Не число " + c);
            }
            try {
                String type = String.valueOf(operatorRPN.isType(Integer.valueOf(c)));
                System.out.println(type);
            }catch (NumberFormatException e){
                System.out.println("Не число " + c);
            }

            //удаление не нужных пробелов в выражении
//            if (c.equals(" ")) {
//                if (i == 0) {
//                    input.delete(i, i + 1);
//                } else {
//                    input.delete(i, i + 1);
//                    i--;
//                }
//            }
        }
    }
}
