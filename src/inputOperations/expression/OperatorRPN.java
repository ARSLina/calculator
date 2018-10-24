package inputOperations.expression;

import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.*;

/**Оператор – добавляется поле int priority
 *и метод int getPriority();*/

public class OperatorRPN extends ExpressionRPN {
    int priority;
    public String op = "null;null;null;null";
    String d = "";
    ArrayList<String> operatorsList = new ArrayList<String>(Arrays.asList(op.split(";")));


    public int getPriority(String operator) {
        if (operator.equals("(")||operator.equals(")")){
            return priority = 1;
        }
        if (operator.equals("*")||operator.equals("/")){
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
    protected static Map<String, OperatorRPN> operators = new HashMap<>();

    public boolean isOperator(String previousOperator, String nameOperator) {
        //заполняем в правильном порядке массив из операторов
        if (nameOperator.equals("+") || nameOperator.equals("-") || nameOperator.equals("*") ||
                nameOperator.equals("/") || nameOperator.equals("(") || nameOperator.equals(")") ||
                nameOperator.equals("(")){
            if(nameOperator.equals("-") && previousOperator.equals(null) || previousOperator.equals("(") ){
                //вызов унарного класса

                return false;
            }

            String bufer = operatorsList.get(getPriority(nameOperator))+ " " + nameOperator;
            if (!operatorsList.get(getPriority(nameOperator)).equals("null")){
                operatorsList.remove(getPriority(nameOperator));
                operatorsList.add(getPriority(nameOperator), bufer);
            }else {
                operatorsList.remove(getPriority(nameOperator));
                operatorsList.add(getPriority(nameOperator),nameOperator);
            }
            System.out.println(operatorsList);
            priority =0;
//            expression.add(expression.size())getPriority(name);
            return true;
        }
        return false;
    }
    // Получить оператор с таким именем
    public  OperatorRPN getOperator(String name) {
        return null;
    }
}