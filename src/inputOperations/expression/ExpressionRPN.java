package inputOperations.expression;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.List;

public abstract class ExpressionRPN {
    public static ArrayList<String> expression = new ArrayList<>();
    //    private static String expression = "";
    public static final int NUMBER = 0;
    public static final int UN_OPERATOR = 1;
    public static final int BI_OPERATOR = 2;
    public static final int BRACKET = 3;


    public void add(String a){
        expression.add(a);
    }

    public void correctExpression(int op, int index, double number){
        if (op == BI_OPERATOR){
            expression.remove(index);
            expression.remove(index-1);
            expression.remove(index-2);
            expression.add(index-2, String.valueOf(number));
            System.out.println("aaaaaa "+ expression);
        }else if(op == UN_OPERATOR){
            expression.remove(index);
            expression.remove(index-1);
            expression.add(index-1, String.valueOf(number));
            System.out.println("aaaaaa "+ expression);
        }

    }

    // Печатает элемент
    public void print(Object o) {
        System.out.print(o.toString());
    }

    // Возвращает тип элемента (число, ун. оператор, бин. оп., )
    public abstract int getType();

    public boolean isType(int type) {
        return type == getType();
    }
}