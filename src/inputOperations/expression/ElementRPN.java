package inputOperations.expression;

import java.util.ArrayList;

import static inputOperations.InputOperation.calc;

public class ElementRPN {
    //выражение
    public static StringBuffer input;
    static String bufer = "";
//    ДЛЯ ДОБАВЛЕНИЯ В ОПН
    public static String primary = "";
    public static String secondary = "";
    public static String tertiary = "";
    static ArrayList bktT = new ArrayList(); //массив с индексами скобок
    static String trig = ""; //счетчик кол-ва скобок
    static String inpTrig = ""; // триггер для отображения выражения, если не пуст, то показывам
    public static String expTrig = ""; // триггер для вводв выражения, если не пуст, то показывам

    public static void elementRPN(){
        if (expTrig.equals("")){
            input = new StringBuffer(calc());
//        input = new StringBuffer("4+(6-3)/2");
            expTrig="1";
        }
        for (int i = 0; i < input.length(); i++){
            String c = String.valueOf(input.charAt(i));
            //удаление не нужных пробелов в выражении
            if (c.equals(" ")){
                if (i==0){
                    input.delete(i, i+1);
                }else {
                    input.delete(i, i+1);
                    i--;
                }
            }

            if ((String.valueOf(input.charAt(i)).matches("\\d+")) || (input.charAt(i)== '*')  || (input.charAt(i)== '/') || (input.charAt(i)== '+') ||
                    (input.charAt(i)== '-') || (input.charAt(i) == '.') ||(input.charAt(i)== '(') || (input.charAt(i)== ')')){
                //необходимо сделать проверку на унарный минус
                if (c.equals("-")&&((i==0) || (input.charAt(i-1)== '/') || (input.charAt(i-1) == '('))){
                    input.insert(i,0); // 0-5
                }
                if (c.equals("-")&&(i!=0) && (input.charAt(i-1)== '-')){
                    input.delete(i-1,i+1);
                    input.insert(i-1, "+"); //5--6
                }
                if (c.equals("-")&&(i!=0) && (input.charAt(i-1)== '+')){
                    input.delete(i-1,i); //5+-6
                }
                if (c.equals("+")&&(i!=0) && (input.charAt(i-1)== '-')){
                    input.delete(i,i+1); //5-+6
                }
                if (c.equals("+")&&(i!=0) && (input.charAt(i+1)== '+')){
                    input.delete(i,i+1); //5-+6
                }
                if (((c.equals("/"))||(c.equals("*")))&&(i!=0) && ((input.charAt(i-1)== '-')||(input.charAt(i-1)== '+')
                        ||(input.charAt(i-1)== '/')||(input.charAt(i-1)== '*')||(input.charAt(i-1)== '(')||
                (input.charAt(i-1)== '.'))){
                    System.out.println("\u001B[31m" +  "В вашем примере ошибка, попробуйте ввести заново"+"\u001B[0m" );
                    expTrig = "";
                    elementRPN();
                }

                if ((input.charAt(i)== '(')){
                    trig = "1"; //нашли скобку
                    if (i!=0){
                        String a = String.valueOf(input.charAt(i-1));
                        if (a.matches("[0-9]")){
                            System.out.println("\u001B[31m" +  "В вашем примере ошибка, попробуйте ввести заново"+"\u001B[0m" );
                            expTrig = "";
                            elementRPN();
                        }
                    }
                }
                if ((input.charAt(i)== '(') ||(input.charAt(i)== ')') ){
                    trig = "1"; //нашли скобку
                }
            }else {
                System.out.println("\u001B[31m" +  "В вашем примере ошибка, попробуйте ввести заново"+"\u001B[0m" );
                expTrig = "";
                elementRPN();
            }

        }
        //пробел в конце поможет с разбиением выражения
        input.insert(input.length(), " ");
        if (inpTrig.equals("")){
            System.out.println("Выражение " + input);
            inpTrig = "1";
        }

        //передаю мою строку для "анализа" в еxpressions
        еxpressions(input);
    }

    public static void еxpressions(StringBuffer inputVar){
        for (int i = 0; i < inputVar.length() ; i++) {
            if (trig!="1"){
                bufer = String.valueOf(inputVar.charAt(i));
                if ((bufer.matches("[0-9]")) || (bufer.equals("."))){
                    primary();
                }
                if ((bufer.equals("*")) || (bufer.equals("/"))){
                    secondary();
                }
                if ((bufer.equals("+")) || (bufer.equals("-"))){
                    tertiary();
                }
                if (bufer.equals(" ")){
                    space();
                }
            } else {
                bufer = String.valueOf(inputVar.charAt(i));
                if (bufer.equals("(")) {
                    bracketsT(i);
                }
                if (bufer.equals(")")) {
                    trig= "";
                    bracketsD(i);
                    break;
                }
            }
        }
        ExpressionRPN.calculate( ExpressionRPN.expression);
    }
    //метод для первой скобки, добавление в массив id положения в строке
    static void bracketsT(Integer id){
        bktT.add(id);
    }
    //метод для второй скобки, вырезание строки, добавление в массив выражения в скобке
    static void bracketsD(Integer id){
        Integer d = bktT.size()-1; // получаем ко-во элементов с "("
        /** (начало выреза в input) получаю ID в общей строке из массива с "(" (последний эл-т)*/
        Integer idBKT_T = (Integer) bktT.get(d)+1;
        /** формируем строку в найденном промежутке (скобка)*/
        StringBuffer exp = new StringBuffer(input.substring(idBKT_T, id) + " ");
//        System.out.println("Найденная скобка " +exp);
        еxpressions(exp);
        bktT.remove(bktT.size()-1); //удаляем последний элемент (id последyней скобки)
        input.delete(idBKT_T-1, id+1);
        input.insert(idBKT_T-1,  ExpressionRPN.expression.get(0)); //добавляем ответ в скобке в пример
        ExpressionRPN.expression.remove(0);
        /** необходимо стереть значения в переменных для добавления в ОПН*/
       primary = "";secondary = "";tertiary = "";
        /** возвращаю наше выражение, для дальнейшего вычесления*/
        elementRPN();
    }

    static void primary(){
        //число
        primary = primary + bufer;
    }
    static void secondary(){
        //умножение, деление
        addPrimary();
        if (!secondary.equals("")){
            ExpressionRPN.add(secondary);
            secondary = "";
        }else {
            secondary = secondary + bufer;
        }
    }
    static void tertiary(){
        //сложение, вычитание
        addPrimary();
        addSecondary();
        tertiary = tertiary + bufer;
    }
    static void space(){
        //пробел
        addPrimary();
        secondary();
        if (!tertiary.equals("")){
            for (int i = 0; i < tertiary.length() ; i++) {
                ExpressionRPN.add(String.valueOf(tertiary.charAt(i)));
            }
        }
    }
    static void addPrimary(){
        if (!primary.equals("")){
            ExpressionRPN.add(primary);
            primary = "";
        }
    }
    static void addSecondary(){
        if (!secondary.equals("")){
            ExpressionRPN.add(secondary);
            secondary = "";
        }
    }
}
