package inputOperations.expression;

import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.HashMap;
import java.util.Map;

/**Оператор – добавляется поле int priority
 *и метод int getPriority();*/

public class OperatorRPN extends ExpressionRPN {
    int priority;
    public String op = "";

    public int getPriority(int num) {
        return num;
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

    public boolean isOperator(String name) {
        try {
            BiOperatorRPN biOperatorRPN = null;
            biOperatorRPN.inputOperation.operator = name;// name;
//        biOperatorRPN = new BiOperatorRPN(Double.valueOf(expression.get(expression.size())), Double.valueOf(expression.get(expression.size())), (a, b) -> a + b);
//            System.out.println("что-то " + biOperatorRPN);
//            BiOperatorRPN biOperatorRPN = new BiOperatorRPN(Double.valueOf(expression.get(expression.size())), Double.valueOf(expression.get(expression.size())), (a, b)-> a + b);

//            BiOperatorRPN(Double.valueOf(expression.get(expression.size())), Double.valueOf(expression.get(expression.size())), (a, b)-> a + b);
//            operators.put("+", new BiOperatorRPN(Double.valueOf(expression.get(expression.size())), Double.valueOf(expression.get(expression.size())), (a, b)-> a + b));

//            operators.put("+", new BiOperatorRPN(22, 54, (a, b)-> a + b));
//        return true;
        }catch (Exception e){
            System.out.println("не прошоло");
        }
        return false;
    }

    public OperatorRPN getOperator(String name) // Получить оператор с таким именем
    {
        return null;
    }

}