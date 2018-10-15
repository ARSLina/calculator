package inputOperations.expression;

/**Число – конструктор, принимающий число,
 * метод возвращающий значение, переопределение
 * getType и toString()*/

public class NumberRPN extends ElementRPN{
    private static int number =0;

     public void setNum(int num) {
       // number = number + num;
       number = num;
    }

    public boolean isType(/*int type, */int num) {
        if (NUMBER == getType()){

        }
         return super.isType(getType());
    }

    @Override
    public int getType() {

        return NUMBER;
    }

    public String toString() {
        return String.valueOf(number);
    }
}
