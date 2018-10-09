package inputOperations.expression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionRPN {
    static ArrayList expression = new ArrayList();
    static public String result = "";

    public static void add(String a){
        expression.add(a);
    }

    public static void calculate(List<String> input){
//        System.out.println("мой пример " + input);
        //метод, где получаем результат
        while (input.size()!=1) {
            for (int i = 0; i <input.size(); i++) {
                String c =  input.get(i).trim();
                if (c.equals("/") || c.equals("*") ||c.equals("+") ||c.equals("-")){
                    double a , b, d;
                    switch (c){
                        case "/":
                            a = Double.valueOf(input.get(i-2).trim());
                            b = Double.valueOf(input.get(i-1).trim());
                            input.remove(i-1); //b
                            input.remove(i-2); //a
                            d = a / b;
                            input.add(i-1, String.valueOf(d));
                            input.remove(i-2);
                            System.out.println("\u001B[34m"+"деление "+ a +" и "+ b +"\u001B[0m" +"\n"+input);
                            i=0;break;
                        case "*":
                            a = Double.valueOf(input.get(i-2).trim());
                            b = Double.valueOf(input.get(i-1).trim());
                            input.remove(i-1); //b
                            input.remove(i-2); //a
                            d = a * b;
                            input.add(i-1, String.valueOf(d));
                            input.remove(i-2);
                            System.out.println("\u001B[34m"+ "умножение "+ a +" и "+ b +"\u001B[0m" +"\n"+input);
                            i=0;break;
                        case "+":
                            a = Double.valueOf(input.get(0).trim());
                            b = Double.valueOf(input.get(1).trim());
                            input.remove(1);
                            input.remove(0);
                            d = a + b;
                            input.add(0, String.valueOf(d));
                            input.remove(i-1);
                            System.out.println("\u001B[34m"+"сложение "+ a +" и "+ b +"\u001B[0m" +"\n"+input);
                            i=0;break;
                        case "-":
                            a = Double.valueOf(input.get(0).trim());
                            b = Double.valueOf(input.get(1).trim());
                            input.remove(1);
                            input.remove(0);
                            d = a-b;
                            input.add(0, String.valueOf(d));
                            input.remove(i-1);
                            System.out.println("\u001B[34m"+"вычтание "+ a +" и "+ b +"\u001B[0m" +"\n"+input);
                            i=0;break;
                    }
                }
            }
        }
        result = input.get(0);
//        System.out.println("Ответ " + input);
    }
}
