package inputOperations;

import inputOperations.expression.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputOperation {
    public static StringBuffer input = new StringBuffer("5*8+6");
    BiOperatorRPN biOperatorRPN = new BiOperatorRPN();
    ArrayList <String> sumbols = new ArrayList<>();
    BracketRPN bracketRPN = new BracketRPN();
    ElementRPN elementRPN = new ElementRPN() {
        @Override
        public int getType() {
            return super.getType();
        }
    };
    NumberRPN numberRPN = new NumberRPN();
    OperatorRPN operatorRPN = new OperatorRPN();

    String operator;
    Integer op;

    //для ввода примера
    public String inputExample() {
        System.out.println("Пожалуйста введите пример: ");
        Scanner in = new Scanner(System.in);
        return String.valueOf(input = new StringBuffer(in.nextLine()));
    }

    //удаление лишних пробелов
    void correct(){
        for (int i = 0; i < input.length(); i++) {
            String c = String.valueOf(input.charAt(i));
            // удаление не нужных пробелов в выражении
            if (c.equals(" ")) {
                if (i == 0) {
                    input.delete(i, i + 1);
                } else {
                    input.delete(i, i + 1);
                    i--;
                }
            }
            //добавление проберов до и после знаков
            if ((String.valueOf(input.charAt(i)).equals("+")|| String.valueOf(input.charAt(i)).equals("-")||
                    String.valueOf(input.charAt(i)).equals("*")|| String.valueOf(input.charAt(i)).equals("/")||
                    String.valueOf(input.charAt(i)).equals("(")|| String.valueOf(input.charAt(i)).equals(")"))){
                if (i==0){
                    String symb = String.valueOf(input.charAt(i)) + " ";
                    input.delete(i, i+1);
                    input.insert(i, symb);
                    i= i +2;
                }else {
                    String symb = " " + String.valueOf(input.charAt(i)) + " ";
                    input.delete(i, i + 1);
                    input.insert(i, symb);
                    i = i + 3;
                }
            }
        }
        input.insert(input.length(), " ");
    }

    public void calc(String priority){
        if (priority.equals("2")) {

        }
        if (priority.equals("3") && operatorRPN.operators.get("2").equals(null) && operatorRPN.operators.get("1").equals(null)) {

        }
            switch (priority){
                case "1":{

                }
                case "2":{

                }
                case "3":{

                }
            }
        }


    public void input() {
//        inputExample();
        correct();
        ElementRPN.expression = new ArrayList<String>( Arrays.asList(String.valueOf(input).split(" ")));
        System.out.println("My expression " + ElementRPN.expression);

        for (int i = 0; i < ElementRPN.expression.size(); i++) {
            try {
                // число ли это
                numberRPN.num(Double.parseDouble(ElementRPN.expression.get(i)));
                System.out.println(operatorRPN.operators.get("2"));
                if (!operatorRPN.operators.get("2").equals(null)){
                    System.out.println("нашел" + operatorRPN.operators.get("2"));
                    try{
                        op = operatorRPN.getOperator(operator, ElementRPN.expression.get(i-2), ElementRPN.expression.get(i));
                        elementRPN.correctExpression(op, i, operatorRPN.result);
                        operatorRPN.operators.remove("2");
                        i=0;
                    }catch (Exception e){
                        op = operatorRPN.getOperator(operator, ElementRPN.expression.get(i), null);
                        elementRPN.correctExpression(op, i, operatorRPN.result);
                        i=0;
                    }
                }
                System.out.println("индн" + (ElementRPN.expression.size()-1) + " " + i);
                if (i==ElementRPN.expression.size()-1 && operatorRPN.operators.get("1").equals(null)
                        && operatorRPN.operators.get("2").equals(null)){
                    try{
                        op = operatorRPN.getOperator(operator, ElementRPN.expression.get(i-2), ElementRPN.expression.get(i));
                        elementRPN.correctExpression(op, i, operatorRPN.result);
                        operatorRPN.operators.remove("2");
                        i=0;
                    }catch (Exception e){
                        op = operatorRPN.getOperator(operator, ElementRPN.expression.get(i), null);
                        elementRPN.correctExpression(op, i, operatorRPN.result);
                        i=0;
                    }
                }

//                if(!operator.equals("")) {
//
//                    //для ( )
//                    if (operatorRPN.getPriority(operator).equals("b1")) {
//                        //для скобок
//                        while (!ElementRPN.expression.get(i).equals(")")) {
//                            bracketRPN.add(ElementRPN.expression.get(i));
//                            i++;
//                        }
//                        System.out.println("в скобках" + BracketRPN.bracketEx);
//                        //прогоняем то что в скобках
//                        for (int j = 0; j < BracketRPN.bracketEx.size(); i++) {
//                            try {
//                                // число ли это
//                                numberRPN.num(Double.parseDouble(BracketRPN.bracketEx.get(i)));
//                            } catch (Exception e) {
//                                operator = BracketRPN.bracketEx.get(i);
//                                operatorRPN.isOperator(operator);
//                            }
//                        }
//                    }
//                    if(operatorRPN.getPriority(operator).equals("2")){
//                        //для /*
//                        BiOperatorRPN.BiOperatorRPN(i,operator);
//                        operator = "";
//                        i=0;
//                    }
//                    //сделать счетчик для записи в карту для +-
//                    if(operatorRPN.getPriority(operator).equals("3")){
//                        //для +-
//                        BiOperatorRPN.BiOperatorRPN(i,operator);
//                        operator = "";
//                        i=0;
//                    }
//                }
            }catch (Exception e){
                operator = ElementRPN.expression.get(i);
                operatorRPN.isOperator(operator);
            }
        }
    }
}