package inputOperations.expression;

//import static inputOperations.expression.OperatorRPN.operators;//
//

import com.sun.org.apache.xpath.internal.operations.Operation;
import inputOperations.InputOperation;

import java.util.function.BinaryOperator;

import static inputOperations.InputOperation.input;
import static inputOperations.InputOperation.operator;

public class BiOperatorRPN extends OperatorRPN {
    static double result;
    public static InputOperation inputOperation = new InputOperation();
    static int id = 0;
    public BiOperatorRPN(double x, double y, BinaryOperator<Double> converter) {
        System.out.println("в резулте " + x + " "+ y );
        result = converter.apply(x,y);
    }

    public int getType() {
        return BI_OPERATOR;
    }

    @Override
    public boolean isType(int type) {
        type = 2;

        return super.isType(type);
    }

    static {
        System.out.println("Оператор "  + operator +expression);
        switch (operator){
            case "+":{
                operators.put("+", new BiOperatorRPN(Double.valueOf(expression.get(expression.size()-2)), Double.valueOf(expression.get(expression.size()-1)), ( a, b) -> a + b));
                operator = "";
                break;
            }
            case "-":{
                operators.put("-", new BiOperatorRPN(Double.valueOf(expression.get(expression.size()-2)), Double.valueOf(expression.get(expression.size()-1)),(a, b)-> a - b));
                operator = "";
                break;
            }
            case "*":{
                operators.put("*", new BiOperatorRPN(Double.valueOf(expression.get(expression.size()-2)), Double.valueOf(expression.get(expression.size()-1)),(a, b)-> a * b));
                operator = "";
                break;
            }
            case "/":{
                operators.put("/",  new BiOperatorRPN(Double.valueOf(expression.get(expression.size()-2)), Double.valueOf(expression.get(expression.size()-1)),(a, b)-> a / b));
                //удаляем числа с выражений
                expression.remove(expression.size()-2);expression.remove(expression.size()-1);

                //добавляем в массив ответ выражения
                expression.add(expression.size(), String.valueOf(result));
                operator = "";
                System.out.println("Map " + operators + "  " + expression+ "  " + input);
                break;
            }
        }
        System.out.println("ответ "  + result);
    }
}