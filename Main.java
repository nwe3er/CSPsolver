import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Main class
public class Main {
    public static void main(String[] args) {
        //gets file paths and procedure as arguments
        String path1 = args[0];
        String path2 = args[1];
        String procedure = args[2];
        boolean is_fc;

        // create CSP/ Search instances
        CSP csp = new CSP();
        Search obj = new Search();

        // pass path1 and path2 to get variable/constraints info
        csp.AssignVariable(path1, path2);

        // check procedure mode
        is_fc = procedure.equalsIgnoreCase("none");

        if(is_fc) obj.backtracking(CSP.variableData);



    }
}

// csp class
class CSP {
    Variable variable = new Variable();                                       // create variable object
    static ArrayList<Variable> variableData = new ArrayList<>();              // list to store all the variables

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
                String[] temp;
                String line = scanner.nextLine();
                temp = Constraints.getConstraint(line); // A > B
                String[] s = temp;

                // loop until you cover all the variables to add constraints to each variable
                for (Variable variableDatum : variableData) {
                    if (variableDatum.letter == s[0].charAt(0)) variableDatum.constraints.add(s);
                    if (variableDatum.letter == s[2].charAt(0)) variableDatum.constraints.add(s);
                }
            }

            scanner.close();

            // Print error handler
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred, File could not be opened.");
            e.printStackTrace();
        }
    }

    // method to see if an assignment is complete
    static boolean isComplete(ArrayList<String> assignment) {
        int count1 = 0;                                                         // counter

        // loop through the assignment to see if each variable is assigned
        for (String s : assignment) {
            char letter = s.charAt(0);

            for (Variable variableDatum : CSP.variableData) {
                if (letter == variableDatum.letter) {
                    count1++;
                    break;
                }
            }
            if (count1 == variableData.size())
                return true;                                                    // if every assignment is assigned return true
        }
        return false;                                                           // else return false
    }

    // method to return the most constraining variable heuristic
    static char mcv (ArrayList<Variable> csp) {
        int constraintValue = csp.get(0).domainValues.size();               // set constraintValue to first letters domain size
        int count = 0;

        // loop through the variable data and find mcv
        for (int i = 1; i < csp.size(); i++) {

            if (csp.get(i).domainValues.size() < constraintValue) count = i;
        }

        return csp.get(count).letter;                    // return the variable
    }

    static  String UnAssignedVar(ArrayList<String> assignment, ArrayList<Variable> csp) {

        return "";
    }

}

// Class for the Variables
class Variable {
    char letter;                                                      // stores Character
    ArrayList<Integer> domainValues = new ArrayList<>();              // stores the possible domain values for each Variable
    ArrayList<String[]> constraints = new ArrayList<>();              // stores the constraints for each variable

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

// search class
class Search {
    // method that does not use forward checking
    ArrayList<String> backtracking(ArrayList<Variable> variableData) {
        ArrayList<String> assignment = new ArrayList<>();

        return recursiveBacktracking(assignment, variableData);
    }

    private ArrayList<String> recursiveBacktracking(ArrayList<String> assignment, ArrayList<Variable> variableData) {
        // see if the assignment is complete
        if (CSP.isComplete(assignment)) return assignment;

        // get the mcv
        char variable = CSP.mcv(variableData);

        String s = CSP.UnAssignedVar(assignment, variableData);

        return assignment;
    }
}






