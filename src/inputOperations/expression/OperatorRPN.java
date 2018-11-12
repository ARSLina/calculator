package inputOperations.expression;

import java.util.*;

/**Оператор – добавляется поле int priority
 *и метод int getPriority();*/

public class OperatorRPN extends ExpressionRPN {
    public static double result;
    String priority;
    public String op = "null;null;null;null";
    String operatorRPN;
    ArrayList<String> operatorsList = new ArrayList<String>(Arrays.asList(op.split(";")));

    public OperatorRPN() {

    }

    public String getPriority(String operator) {
        if (operator.equals("(")||operator.equals(")")){
            return BracketRPN.getBracket(operator);
        }
        if (operator.equals("*")||operator.equals("/")){
            return priority = "2";
        }
        if (operator.equals("+")||operator.equals("-")){
            return priority = "3";
        }
        return priority = "";
    }


    @Override
    public int getType() {
        return 0;
    }

    @Override
    public boolean isType(int type) {
        return super.isType(type);
    }

    // Здесь будут храниться все операторы
    public static Map<String, OperatorRPN> operators = new HashMap<>();

    public boolean isOperator(String name) {
        if (!getPriority(name).equals("")){
            operators.put(getPriority(name), new OperatorRPN(name));
//            System.out.println("в операторе " + operators.get("2"));
//            System.out.println("мой оператор "+ operators);
            return true;
        }else {
            return false;
        }
    }
    @Override
    public String toString() {
        return operatorRPN;// "OperatorRPN [name=" + operatorRPN+"]";
    }

    // Получить оператор с таким именем
    public OperatorRPN(String name) {
       this.operatorRPN = name;
    }
    public int getOperator(String operator, String p1, String p2) {
        NumberRPN numberRPN = new NumberRPN();
        if (numberRPN.num(Double.parseDouble(p1)) == true && numberRPN.num(Double.parseDouble(p2)) == true ){
            BiOperatorRPN.BiOperatorRPN(Double.parseDouble(p1),Double.parseDouble(p2),operator);
            return BI_OPERATOR;
        }
        if (p2.equals(null) || numberRPN.num(Double.parseDouble(p2)) == false){
            System.out.println("нашел унарность");
            return UN_OPERATOR;
        }
        return 0;
    }
}