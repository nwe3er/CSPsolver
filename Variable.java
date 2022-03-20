import java.util.ArrayList;
import java.util.HashMap;

// Class for the Variables
public class Variable {
    char letter;                                                                // stores Character
    ArrayList<Integer> domainValues = new ArrayList<>();                        // stores the possible domain values for each Variable
    ArrayList<String> constraints = new ArrayList<>();
    HashMap<Character,ArrayList<Integer>> varDom = new HashMap<>();             // hash map variables --> domains values

    public char setVariables(String line) {                                     // assigns the letter and adds domains values for each letter
        letter = line.charAt(0);

        ArrayList<Integer> tempDomainVal = new ArrayList<>();                   // temp list to hold domain of each letter

        // loop until the end of a line
        for (int i = 0; i < line.length(); i++) {
            if ((Character.isDigit(line.charAt(i)))) {
                tempDomainVal.add(Integer.parseInt(String.valueOf(line.charAt(i))));
            }
            // assign domain values
            domainValues = tempDomainVal;
        }
        return letter;                                                          // return letters
    }
}