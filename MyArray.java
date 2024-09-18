import java.util.Arrays;

public class MyArray {
public static String[] addItem(String[] array, String newItem) {
    String[] newArray = Arrays.copyOf(array, array.length + 1);
    newArray[array.length] = newItem;
    return newArray;
}
public static String[][] addTeam(String[][] teams, String[] newTeamMembers) {
    String[][] newTeams = Arrays.copyOf(teams, teams.length + 1);
    newTeams[teams.length] = new String[newTeamMembers.length];
    for (int i = 0; i < newTeamMembers.length; i++) {
        newTeams[teams.length][i] = newTeamMembers[i];
    }
    return newTeams;
}
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
