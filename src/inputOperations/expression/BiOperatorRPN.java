package inputOperations.expression;

//import static inputOperations.expression.OperatorRPN.operators;//
//

import java.util.function.BinaryOperator;

import static inputOperations.expression.BiOperatorRPN.MyFunctional.action;

/**    Бинарный оператор – переопределить getType, добавить конструктор,
 * принимающий 3 параметра – name, priority и action. Action – лямбда,
 * принимающая 2 параметра типа double (это же бинарный оператор) и возвращающая double.*/

public class BiOperatorRPN extends OperatorRPN {

    public int getType() {
        return BI_OPERATOR;
    }

    @Override
    public boolean isOperator(String name) {

        return BI_OPERATOR;
    }

    @Override
    public OperatorRPN getOperator(String name) {
        return null;
    }


    public static Double BiOperatorRPN(double x, double y, BinaryOperator<Double> converter){
        return converter.apply(x,y);
    }
    /***/
    public static Double handleOperation(double x, double y,  BinaryOperator<Double> converter){
        return converter.apply(x,y);
    }
    /***/
    static {
        System.out.println("эм "+  handleOperation(1, 2, (a, b) -> a + b));
        System.out.println(BiOperatorRPN(2.0,5.0,(a, b)-> a + b));
        operators.put("+",BiOperatorRPN(2.0,5.0,(a, b)-> a + b));

        operators.put("-", new BiOperatorRPN("-", 20, (a, b) -> a - b));
    }
}
