package inputOperations.expression;

class UnOperatorRPN extends OperatorRPN{
    static {

//        operators.put("+", new UnOperatorRPN( 20, a -> a));//.add("+", new UnOperatorRPN("+", 20, a -> a));
        operators.add("+", new UnOperatorRPN("+", 20, a -> a));

        operators.add("-", new UnOperatorRPN("-", 20, a -> -a));

    }

    private UnOperatorRPN(int i, Object o) {
        super();
    }

    @Override
    boolean isOperator(String name) {
        return false;
    }

    @Override
    OperatorRPN getOperator(String name) {
        return null;
    }
}
