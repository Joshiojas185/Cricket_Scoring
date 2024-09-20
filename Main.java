/*
This Class is created to use all the methods and features of other classes such as adding members in a team, adding
a new team and scoring a match etc
*/

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static String[] teamArray = Constant.teamArray;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] addMember ;
        System.out.println(Constant.WELCOME);
        System.out.println(Constant.OPERATION_CHOICES);
        while (true) {
            System.out.println(Constant.CHOOSE_OPERATION);
            String choice = scan.nextLine();
            switch (choice) {
                case "1" :
                    // used to show names of all existing teams
                    Team.showTeams(teamArray);
                    break;
                case "2" :
                    // used to add a new Team
                    System.out.println(Constant.ADD_TEAM);
                    String newTeam = scan.nextLine();
                    teamArray = Team.addTeam(teamArray, newTeam);
                    System.out.println(Constant.ADD_TEAM_MEMBER);
                    String inputChoice = scan.nextLine();
                    if(inputChoice.equalsIgnoreCase("Y")){
                        System.out.println(Constant.ENTER_TEAM_MEMBERS);
                        addMember = new String[0];
                        while (true) {
                            String input = scan.nextLine();
                            if (input.equalsIgnoreCase("N")) {
                                break;
                            }
                            addMember = MyArray.addItem(addMember, input);
                        }
                        Team.teamMembers = MyArray.addTeam(Team.teamMembers, addMember);
                    }
                    else{
                        Team.teamMembers = MyArray.addTeam(Team.teamMembers, new String[0]);
                    }
                    break;
                case "3" :
                    // used to show members of the existing teams
                    Team.showTeams(teamArray);
                    System.out.println(Constant.CHOOSE_TEAM_NUMBER);
                    try {
                     int arrayNumber = scan.nextInt();
                     scan.nextLine();
                     arrayNumber--;
                     if (arrayNumber >= 0 && arrayNumber < Team.teamMembers.length) {
                     if (Team.teamMembers[arrayNumber].length == 0) {
                     System.out.println(Constant.N0_MEMBER + teamArray[arrayNumber]);
                     }
                     else {
                     System.out.println("Team " + teamArray[arrayNumber] + " members:");
                     System.out.println(Arrays.toString(Team.teamMembers[arrayNumber]));
                     }
                     }
                      else {
                      System.out.println(Constant.INVALID_TEAM_NO);
                      }
                      }catch (Exception e){
                        System.out.println(Constant.ERROR_HANDLING);
                      }
                      break;
                case "4":
                      // used to add members in a particular team
                      Team.showTeams(teamArray);
                      System.out.println(Constant.CHOOSE_TEAM_NUMBER);
                      try {
                      int number = scan.nextInt();
                      scan.nextLine();
                      System.out.println(Constant.ENTER_TEAM_MEMBERS);
                      addMember = new String[0];
                      while (true) {
                      String input = scan.nextLine();
                      if (input.equalsIgnoreCase("N")) {
                                break;
                      }
                      addMember = MyArray.addItem(addMember, input);
                      }
                      Team.teamMembers[number - 1] = Team.addInATeam(Team.teamMembers[number - 1], addMember);
                      }
                      catch(Exception e){
                      System.out.println(Constant.ERROR_HANDLING);
                      }
                      break;
                case "5" :
                      // used to play a match and view scores
                      System.out.println(Constant.PLAY);
                      Team.showTeams(teamArray);
                      System.out.println(Constant.MATCH_TEAMS);
                      try{
                      int firstTeam = scan.nextInt();
                      int secondTeam = scan.nextInt();
                      firstTeam = firstTeam - 1 ;
                      secondTeam = secondTeam - 1;
                      String[] teamA = Team.teamMembers[firstTeam];
                      String[] teamB = Team.teamMembers[secondTeam];
                      Match.matchSimulation(teamArray,teamA,teamB ,firstTeam, secondTeam);
                      }
                      catch (Exception e){
                        System.out.println(Constant.ERROR_HANDLING);
                      }
                      break;
                case "6" :
                      // used for others who are looking for a ground, team, or an opponent to join or to play against
                      LookingFor.lookingfor();
                      break;

                case "0" :
                      // used to break the loop and exit the program
                      System.out.println(Constant.EXIT_MESSAGE);
                      break;
                      // used to show a message against invalid inputs
                default : System.out.println(Constant.INVALID_INPUT) ;
                      break;
            }
            if(choice.equalsIgnoreCase("0")){
                break;
            }
        }
    }
}
