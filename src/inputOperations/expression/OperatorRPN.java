package inputOperations.expression;

import java.util.HashMap;
import java.util.Map;

/**Оператор – добавляется поле int priority
 *и метод int getPriority();*/

 public class OperatorRPN extends ExpressionRPN {
    int priority;

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

     boolean isOperator(String name); // Есть ли оператор с таким именем
     OperatorRPN getOperator(String name); // Получить оператор с таким именем


}
