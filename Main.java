import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] addMember ;
        String[] teamArray = {"India", "Australia","South Africa"};
        String[][] teamMembers = {
                {"Hardik", "Virat", "Rohit", "Jasprit", "Yashaswi","Md.Siraj","Kuldeep"
                  ,"Shubman","Arshdeep","Ravindra","Rishabh Pant","Shreyas"},
                {"Steve Smith","Pat Cummins","JFM","Mitch Starc","Josh Hazlewood",
                  "Mitch Marsh","Sean Abbott","Matt Short","Travis Head","Glenn","Marcus"}
        };

        System.out.println(Constants.WELCOME);
        System.out.println(Constants.OPERATION_CHOICES);

        while (true) {
            System.out.println(Constants.CHOOSE_OPERATION);
            String choice = scan.nextLine();
            switch (choice) {
                case "1" :
                    Team.showTeams(teamArray);
                    break;
                case "2" :
                    System.out.println(Constants.ADD_TEAM);
                    String newTeam = scan.nextLine();
                    teamArray = Team.addTeam(teamArray, newTeam);
                    System.out.println(Constants.UPDATED_TEAM_LIST);
                    Team.showTeams(teamArray);
                    break;
                case "3" :
                    Team.showTeams(teamArray);
                    System.out.println(Constants.CHOOSE_TEAM_NUMBER);
                    int arrayNumber = scan.nextInt();
                    scan.nextLine();
                    arrayNumber--;
                    if (arrayNumber >= 0 && arrayNumber < teamMembers.length) {
                        if (teamMembers[arrayNumber].length == 0) {
                            System.out.println(Constants.N0_MEMBER + teamArray[arrayNumber]);
                        } else {
                            System.out.println("Team " + teamArray[arrayNumber] + " members:");
                            System.out.println(Arrays.toString(teamMembers[arrayNumber]));
                        }
                    } else {
                        System.out.println(Constants.INVALID_TEAM_NO);
                    }
                     break;
                case "4" :
                    System.out.println(Constants.ENTER_TEAM_MEMBERS);
                    addMember = new String[0];
                    while (true) {
                        String input = scan.nextLine();
                        if (input.equalsIgnoreCase("N")) {
                            break;
                        }
                        addMember = MyArray.addItem(addMember, input);
                    }
                    teamMembers = MyArray.addTeam(Team.teamMembers, addMember);
                    break;

                case "5" :
                    LookingFor.lookingfor();
                    break;
                case "6" :
                    Team.showTeams(teamArray);
                    System.out.println(Constants.MATCH_TEAMS);
                    int firstTeam = scan.nextInt();
                    int secondTeam = scan.nextInt();
                    firstTeam--;
                    secondTeam--;
                    String[] teamA = Team.get11(firstTeam);
                    String[] teamB = Team.get11(secondTeam);
                    Match.matchSimulation(teamArray,teamA,teamB ,firstTeam, secondTeam);
                    break;

                case "0" :
                    System.out.println(Constants.EXIT_MESSAGE);
                    break;

                default : System.out.println(Constants.INVALID_INPUT) ;
                break;
            }
            if(choice.equalsIgnoreCase("0")){
                System.out.println(Constants.ERROR_HANDLING);
                break;
            }
        }
    }
}
