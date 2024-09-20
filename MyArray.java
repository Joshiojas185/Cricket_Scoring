/*
This class is created to use Arrays of Variable Sizes and increase its length , it is used to add a team members in
the team array and a team in the teamMember array which will store all the Members in a 2D Array
*/
import java.util.Arrays;
public class MyArray {
    // used to add a String in an Array
    public static String[] addItem(String[] array, String newItem) {
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = newItem;
        return newArray;
    }
    // used to add a String array in the teamMember Array
    public static String[][] addTeam(String[][] teams, String[] newTeamMembers) {
        String[][] newTeams = Arrays.copyOf(teams, teams.length + 1);
        newTeams[teams.length] = new String[newTeamMembers.length];
        for (int i = 0; i < newTeamMembers.length; i++) {
            newTeams[teams.length][i] = newTeamMembers[i];
        }
        teams = newTeams;
        return teams;
    }
    // used to remove a String at a particular Index
    public static String[] removeAtIndex(String[] array, int index){
        if(index >= 0 && index < array.length){
            int idx = 0 ;
            String[] newArray = new String[array.length-1];
            for(int i = 0; i < array.length; i++ ){
                if(i != index){
                    newArray[idx++] = array[i];
                }
            }
            return newArray;
        }
        return array;
    }

}
