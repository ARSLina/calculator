package inputOperations.expression;

/**   Скобки – метод говорящий какая это скобка*/
public class BracketRPN extends OperatorRPN {
    @Override
    boolean isOperator(String name) {
        return false;
    }

    @Override
    OperatorRPN getOperator(String name) {
        return null;
    }
}
