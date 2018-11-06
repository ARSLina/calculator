package inputOperations.expression;

import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.*;

/**Оператор – добавляется поле int priority
 *и метод int getPriority();*/

public class OperatorRPN extends ExpressionRPN {
    int priority;
    public String op = "null;null;null;null";
    String operatorRPN;
    ArrayList<String> operatorsList = new ArrayList<String>(Arrays.asList(op.split(";")));

    public OperatorRPN() {

    }

    public int getPriority(String operator) {
        if (operator.equals("(")||operator.equals(")")){
            return priority = 1;
        }
        if (operator.equals("*")||operator.equals("/")){
            priority = 2;
            return priority = 2;
        }
        if (operator.equals("+")||operator.equals("-")){
            return priority = 3;
        }
        return priority = 0;
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
    protected static Map<Integer, OperatorRPN> operators = new HashMap<>();

    public boolean isOperator(String name) {
        System.out.println("получил " + name);
        if (getPriority(name)>0){
            operators.put(getPriority(name), new OperatorRPN(name));
            System.out.println("мой оператор "+ operators);
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
    public  OperatorRPN getOperator(String name) {
        return null;
    }
}