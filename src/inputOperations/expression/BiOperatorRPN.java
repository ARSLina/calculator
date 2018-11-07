package inputOperations.expression;

//import static inputOperations.expression.OperatorRPN.operators;//
//

import com.sun.org.apache.xpath.internal.operations.Operation;
import inputOperations.InputOperation;

import java.util.function.BinaryOperator;

import static inputOperations.InputOperation.input;

public class BiOperatorRPN extends OperatorRPN {

    static double result;
    public static String biOperator = "";
    public static int z;


    public static void biOperatorRPN (int index , String operator){
        biOperator = operator;
        z = index;
    }
    public BiOperatorRPN(){

    }
    public BiOperatorRPN(double x, double y, BinaryOperator<Double> converter) {
        result = converter.apply(x,y);
    }

    public int getType() {
        return BI_OPERATOR;
    }

    @Override
    public boolean isType(int type) {
        type = 2;

        return super.isType(type);
    }


    public static void BiOperatorRPN(int index, String operator){
        ElementRPN elementRPN = new ElementRPN() {
            @Override
            public void correctExpression(int index, double number) {
                super.correctExpression(index, number);
            }
        };
        switch (operator){
            case "+":{
                new BiOperatorRPN(Double.parseDouble(ElementRPN.expression.get(index-2)), Double.parseDouble(ElementRPN.expression.get(index)),(a, b)-> a + b);
                elementRPN.correctExpression(index, result);
                break;
            }
            case "-":{
                new BiOperatorRPN(Double.parseDouble(ElementRPN.expression.get(index-2)), Double.parseDouble(ElementRPN.expression.get(index)),(a, b)-> a - b);
                elementRPN.correctExpression(index, result);
                break;
            }
            case "*":{
                new BiOperatorRPN(Double.parseDouble(ElementRPN.expression.get(index-2)), Double.parseDouble(ElementRPN.expression.get(index)),(a, b)-> a * b);
                operators.remove(2);
                elementRPN.correctExpression(index, result);
                break;
            }
            case "/":{
                new BiOperatorRPN(Double.parseDouble(ElementRPN.expression.get(index-2)), Double.parseDouble(ElementRPN.expression.get(index)),(a, b)-> a / b);
                elementRPN.correctExpression(index, result);
                break;
            }
            case "":{
                System.out.println("nenf");
                break;
            }
        }
        System.out.println("ответ "  + result);
    }
}