package inputOperations;

import inputOperations.expression.ElementRPN;
import inputOperations.expression.NumberRPN;
import inputOperations.expression.OperatorRPN;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputOperation {
    public static StringBuffer input = new StringBuffer("2-5*8+3/5");
    ArrayList <String> sumbols = new ArrayList<>();
    ElementRPN elementRPN = new ElementRPN() {
        @Override
        public int getType() {
            return super.getType();
        }
    };
    NumberRPN numberRPN = new NumberRPN();
    OperatorRPN operatorRPN = new OperatorRPN();
    String operator;

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

    public void input() {
//        input = new StringBuffer(calc());
        // удаление не нужных пробелов в выражении
//        inputExample();
        correct();
//        System.out.println("My expression " + input);
        ElementRPN.expression = new ArrayList<String>( Arrays.asList(String.valueOf(input).split(" ")));
        System.out.println("My expression " + ElementRPN.expression);

//        Pattern pattern = Pattern.compile("\\-?\\d+(?:\\.\\d+(?:E[\\-\\+]\\d{2})?)?");
//        Matcher matcher = pattern.matcher(input);
//        while (matcher.find()) {
//            String group = matcher.group();
//            doubleArrayList.add(Double.valueOf(group));
////            elementRPN.element = String.valueOf(input.charAt(i));
////            elementRPN.getType();
//            System.out.println("chert " +doubleArrayList + " "+  group);
//        }
//        sumbols.add(String.valueOf(input).replaceAll("[^-\\+\\*\\/]", ""));
//        System.out.println("symbol "+ sumbols);
        for (int i = 0; i < ElementRPN.expression.size(); i++) {
            try {
                numberRPN.num(Double.parseDouble(ElementRPN.expression.get(i)));
//                System.out.println("u " + numberRPN.num(Double.parseDouble(expression.get(i))));
                if(operatorRPN.getPriority(operator) == 1){
                    //для скобок
                }
                if(operatorRPN.getPriority(operator) == 2){
                    //для скобок
                }
                operatorRPN.getPriority(operator);
            }catch (Exception e){
                operator = ElementRPN.expression.get(i);
                operatorRPN.isOperator(operator);
//                System.out.println("не дабл " + expression.get(i));
            }
        }
    }
}