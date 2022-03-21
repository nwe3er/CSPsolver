import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        //gets file paths and procedure as arguments
        String path1 = args[0];
        String path2 = args[1];
        String procedure = args[2];

        // create CSP object
        CSP csp = new CSP();

        // pass path1 and path to get variable/constraints info
        csp.AssignVariable(path1, path2);

    }
}

// csp class
class CSP {
    Variable variable = new Variable();                                       // create variable object
    ArrayList<Variable> variableData = new ArrayList<>();                     // list to store all the variables


    // opens path1 file to assign variable Data
    public void  AssignVariable(String path1, String path2) {
        try {
            //opens scanner on variable file
            File file1 = new File(path1);
            Scanner scanner = new Scanner(file1);

            //loops through the first file of variables, adding data to variable and storing in a list
            while(scanner.hasNextLine()) {
                Variable temp = new Variable();
                String line = scanner.nextLine();
                temp.setVariables(line);
                variable = temp;
                variableData.add(variable);                                    // add variable to variable data list
            }

            scanner.close();

            // open scanner on constraints file
            File file2 = new File(path2);
            scanner = new Scanner(file2);

            // loop through the file of cons, and add constraints to variables
            while(scanner.hasNextLine()) {
                String[] temp = null;
                String line = scanner.nextLine();
                temp = Constraints.getConstraint(line); // A > B
                String[] s = temp;

                // loop until you cover all the variables to add constraints to each variable
                for (int i = 0; i < variableData.size(); i++) {
                    if (variableData.get(i).letter == s[0].charAt(0)) variableData.get(i).constraints.add(s);
                    if (variableData.get(i).letter == s[2].charAt(0)) variableData.get(i).constraints.add(s);
                }
            }

            scanner.close();

            for (Variable i: variableData) {
                System.out.println(i);
            }

            // Print error handler
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred, File could not be opened.");
            e.printStackTrace();
        }
    }
}

// Class for the Variables
class Variable {
    char letter;                                                      // stores Character
    ArrayList<Integer> domainValues = new ArrayList<>();              // stores the possible domain values for each Variable
    ArrayList<String[]> constraints = new ArrayList<String[]>();      // stores the constraints for each variable

    public void setVariables(String line) {                           // assigns the letter and adds domains values for each letter
        letter = line.charAt(0);

        ArrayList<Integer> tempDomainVal = new ArrayList<>();         // temp list to hold domain of each letter

        // loop until the end of a line
        for (int i = 0; i < line.length(); i++) {
            if ((Character.isDigit(line.charAt(i)))) {
                tempDomainVal.add(Integer.parseInt(String.valueOf(line.charAt(i))));
            }
            // assign domain values
            domainValues = tempDomainVal;
        }
    }
    @Override
    public String toString() {
        String s = constraints.get(0).toString();

        return ("letter " + this.letter + "  " + "DomainValues" + domainValues + "  " + "Constraints " + s);
    }

}

// constraints class
class Constraints {
    static String firstChar, secondChar, operator;                    // holds each operand/operator

    // partitions the string
    static String[] getConstraint(String line) {
        String[] partition = line.split(" ");

        firstChar = partition[0];                                     // assign operators/operand
        operator = partition[1];
        secondChar = partition[2];

        return partition;                                            // return the String list
    }

}
