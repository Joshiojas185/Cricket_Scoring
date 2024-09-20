/*
This class is created for users who are looking for a ground, team, or an opponent to join or to play against
 */
import java.util.Scanner;
public class LookingFor {
    public static String[] LookingFor = Constant.LookingFor;
    public static void lookingfor(){
        Scanner scan = new Scanner(System.in);
        System.out.println(Constant.COMMENT);
        String input = scan.nextLine();
        if(input.equalsIgnoreCase("y")){
            System.out.println(Constant.ADD_COMMENT);
            String comment = scan.nextLine();
            LookingFor = MyArray.addItem(LookingFor,comment);
            for (String s : LookingFor) {
                System.out.println(s);
            }
        }
        else{
            for (String s : LookingFor) {
                System.out.println(s);
            }
        }
    }
}
