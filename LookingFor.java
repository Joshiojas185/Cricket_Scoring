import java.util.Scanner;

public class LookingFor {
    public static String[] LookingFor = {"Ojas is Looking a ground for Sunday",
        "Harshit is Looking for a team as a oppononet on Sunday"
    };
    public static void lookingfor(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Do u wanna add a Comment or you Just wanna look for Others"
        +"(Y/N)" );
        String input = scan.nextLine();
        if(input.equalsIgnoreCase("y")){
            System.out.println("Add the Comment");
            String comment = scan.nextLine();
            LookingFor = MyArray.addItem(LookingFor,comment);
            for(int i = 0 ; i < LookingFor.length; i++){
                System.out.println(LookingFor[i]);
            }
        }
        else{
            for(int i = 0 ; i < LookingFor.length; i++){
                System.out.println(LookingFor[i]);
            }
        }
    }
}
