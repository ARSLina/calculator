package inputOperations.expression;

/**Число – конструктор, принимающий число,
 * метод возвращающий значение, переопределение
 * getType и toString()*/

public class NumberRPN extends ElementRPN{
    String number = "";

    public boolean num (double num) {
       return true;
    }

    public boolean isType(int type) {
        if (!Character.isDigit(type)) return false;
    return true;
    }

    @Override
    public int getType() {
        return NUMBER;
    }

    public String toString() {
        return String.valueOf(number);
    }
}