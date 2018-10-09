import inputOperations.expression.ElementRPN;
import inputOperations.expression.ExpressionRPN;

public class Run {
    public static void main(String[] args) {
       try {
           ElementRPN.elementRPN();
        System.out.println("Ответ " + ExpressionRPN.result);
       }catch (Exception e){
           System.out.println("\u001B[31m" +  "В вашем примере ошибка"+"\u001B[0m" );
//           /** необходимо стереть значения в переменных для добавления в ОПН*/
//           ElementRPN.primary = "";ElementRPN.secondary = "";ElementRPN.tertiary = "";
//           ElementRPN.expTrig = "";
//           ElementRPN.elementRPN();
//           e = null;
       }
    }
}
