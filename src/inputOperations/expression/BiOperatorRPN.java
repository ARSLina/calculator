package inputOperations.expression;

//import static inputOperations.expression.OperatorRPN.operators;//
//

import com.sun.org.apache.xpath.internal.operations.Operation;
import inputOperations.InputOperation;

import java.util.function.BinaryOperator;

import static inputOperations.InputOperation.operator;


/**    Бинарный оператор – переопределить getType, добавить конструктор,
 * принимающий 3 параметра – name, priority и action. Action – лямбда,
 * принимающая 2 параметра типа double (это же бинарный оператор) и возвращающая double.*/

public class BiOperatorRPN extends OperatorRPN {
    static double result;
    public static InputOperation inputOperation = new InputOperation();

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
                operators.put("+", new BiOperatorRPN(Double.valueOf(expression.get(expression.size()-2)), Double.valueOf(expression.get(expression.size()-1)), (Double a, Double b) -> a + b));
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
                result ==  new BiOperatorRPN(Double.valueOf(expression.get(expression.size()-2)), Double.valueOf(expression.get(expression.size()-1)),(a, b)-> a / b);
                operators.put("/");
                operator = "";
                System.out.println("Map " + operators);
                break;
            }

        }
        System.out.println("ответ "  + result);
    }

}