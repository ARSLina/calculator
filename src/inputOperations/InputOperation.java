package inputOperations;

import java.util.Scanner;

public class InputOperation {
    public static String expression;
    //для ввода примера
   public static String calc(){
        Scanner in = new Scanner(System.in);
        System.out.println("Пожалуйста введите пример: ");
        return expression = String.valueOf(in.nextLine());
    }
}
