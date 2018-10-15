package inputOperations.expression;

//import static inputOperations.expression.OperatorRPN.operators;//
//

import javax.swing.*;

/**    Бинарный оператор – переопределить getType, добавить конструктор,
 * принимающий 3 параметра – name, priority и action. Action – лямбда,
 * принимающая 2 параметра типа double (это же бинарный оператор) и возвращающая double.*/

public class BiOperatorRPN extends OperatorRPN {
    public int getType() {
        return BI_OPERATOR;
    }

    @Override
    boolean isOperator(String name) {

        return BI_OPERATOR;
    }

    @Override
    OperatorRPN getOperator(String name) {
        return null;
    }

    double c;
    interface MyFunctional {
        double action(double a , double y);
    }

    void BiOperatorRPN(String name, Integer priority, MyFunctional action){

    }

    static {

        operators.put("+", new BiOperatorRPN("+", 20, (a, b) -> a + b));

        operators.put("-", new BiOperatorRPN("-", 20, (a, b) -> a - b));
    }
}
