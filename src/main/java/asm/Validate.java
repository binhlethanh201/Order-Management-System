package asm;
import java.util.Scanner;
public class Validate {

    private static final Scanner sc = new Scanner(System.in);
    private static final Scanner sTrsc = new Scanner(System.in);
    
    public static int checkInputLimited(int min, int max){
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min && result > max){
                    throw new NumberFormatException();
                }
                return result;
            }catch(NumberFormatException ex){
                System.out.println("Please enter number in range (" + min + ", " + max+")");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkInputString(){
        while(true){
            String result = sTrsc.nextLine().trim();
            if (!result.isEmpty()){
                return result;
            }
            System.out.println("String must not empty");
        }
    }
        protected static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(checkInputString());
                return result;
            } catch (NumberFormatException n) {
                System.out.print("Enter again: ");
                System.out.println("Please input number!");
            }catch(Exception e){
            }
        }
    }
    public static double checkInputIncome(){
        while(true){
            try{
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result <= 0){
                    throw new NumberFormatException();
                }
                return result;
            }catch(NumberFormatException ex){
                System.out.println("Please input positive number.");
                System.out.print("Enter again: ");
            }
        }
    }  
    public static double checkInputDouble(){
        while (true) {            
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter number!");
                System.out.print("Enter again: ");
            }
        }
    }
        protected static int checkInputSaled(int quantity){
        while (true) {            
            try {
                int result = checkInputInt();
                if(result > quantity)
                    throw new NumberFormatException();
                return result;
            } catch (NumberFormatException n) {
                System.out.println("saled ≤ quantity");
                System.out.print("Enter again: ");
            }
        }
    }
}

