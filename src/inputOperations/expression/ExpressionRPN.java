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