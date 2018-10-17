package inputOperations.expression;

import java.util.HashMap;
import java.util.Map;

/**Оператор – добавляется поле int priority
 *и метод int getPriority();*/

 public abstract class OperatorRPN extends ExpressionRPN {
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

    public abstract boolean isOperator(String name);
     public abstract OperatorRPN getOperator(String name); // Получить оператор с таким именем


}
