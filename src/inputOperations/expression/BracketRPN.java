package inputOperations.expression;

/**   Скобки – метод говорящий какая это скобка*/
public class BracketRPN extends OperatorRPN {
    @Override
    public boolean isOperator(String name) {
        return false;
    }

    @Override
    public OperatorRPN getOperator(String name) {
        return null;
    }
}
