package inputOperations.expression;

public abstract class ElementRPN extends  ExpressionRPN{
    public String element = "";
    NumberRPN nRPN;

    @Override
    public int getType() {
        if(nRPN.isType(1)){
            System.out.println("number " + element);
            return NUMBER;
        }else {
            System.out.println("not number " + element);
        }
        System.out.println("element "+ element);
        return 5;
    }

    public boolean isType(int type) {

        return super.isType(type);
    }
}


