package inputOperations.expression;

//import static inputOperations.expression.OperatorRPN.operators;//
//

import com.sun.org.apache.xpath.internal.operations.Operation;
import inputOperations.InputOperation;

import java.util.function.BinaryOperator;

import static inputOperations.InputOperation.input;

public class BiOperatorRPN extends OperatorRPN {


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


    public static void BiOperatorRPN(double p1, double p2, String operator){
        switch (operator){
            case "+":{
                new BiOperatorRPN(p1, p2,(a, b)-> a + b);
                System.out.println("result " + result);
                break;
            }
            case "-":{
                new BiOperatorRPN(p1, p2,(a, b)-> a - b);
                System.out.println("result " + result);
                break;
            }
            case "*":{
                new BiOperatorRPN(p1, p2,(a, b)-> a * b);
                System.out.println("result " + result);
                break;
            }
            case "/":{
                new BiOperatorRPN(p1, p2,(a, b)-> a / b);
                System.out.println("result " + result);
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