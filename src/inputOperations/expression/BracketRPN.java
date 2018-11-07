package inputOperations.expression;

import java.util.ArrayList;

/**   Скобки – метод говорящий какая это скобка*/
public class BracketRPN extends OperatorRPN {
    public static ArrayList<String> bracketEx = new ArrayList<>();

    public void add(String a){
        bracketEx.add(a);
    }

    @Override
    public boolean isType(int type) {
        return super.isType(type);
    }

    public static String getBracket(String bracket) {
        if (bracket.equals("(")){
            return "b1";
        }
        if (bracket.equals(")")){
            return "b2";
        }
        return "";
    }
}
