import java.util.ArrayList;

// Class for the Variables
public class Variable {
    // stores Character of each letter
    Character letter;
    // stores the possible domain values for each Variable
    ArrayList<Integer> domainValues = new ArrayList<Integer>();

    // assigns the letter and adds domains values for each letter
    public char setVariables(String line) {
        letter = line.charAt(0);

        // temp list to hold domain of each letter
        ArrayList<Integer> tempDomainVal = new ArrayList<>();

        // loop until the end of a line
        for (int i = 0; i < line.length(); i++) {
            if ((Character.isDigit(line.charAt(i)))) {
                tempDomainVal.add(Integer.parseInt(String.valueOf(line.charAt(i))));
            }
            domainValues = tempDomainVal;
        }
        // return letter
        return letter;
    }
}