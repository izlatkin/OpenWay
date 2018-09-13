import java.util.Scanner;

public class OpenWayTask {
    public static String INCORRECT_NUMBER_FORMAT = "Incorrect Number Format";

    public static String f_1_dev_x(String value){
        try {
            double out = 1.0 / (Double.parseDouble(value));
            return String.valueOf(out);
        }catch (java.lang.NumberFormatException e){
            return INCORRECT_NUMBER_FORMAT;
        }
    }

    public static void main(String[] args){
        System.out.println("Программа вычисляет значения функции 1/x, введите x: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner. nextLine();
        String result =  f_1_dev_x(inputString);
        if(!result.equals(INCORRECT_NUMBER_FORMAT))
            System.out.println("1 / " + inputString + " = " + f_1_dev_x(inputString));
        else
            System.out.println(INCORRECT_NUMBER_FORMAT);
    }
}
