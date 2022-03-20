import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// CSP class
public class CSP {
    // create variable object
    Variable variable = new Variable();
    // list to store variables in a list
    ArrayList<Character> listOfVariables = new ArrayList<>();
    // variable ----> domain mapping
    HashMap<Character, ArrayList<Integer>> variableValues = new HashMap<>();

    // opens path1 file to assign variable info
    public void  AssignVariable(String path1) {
        try {
            //opens scanner on variable file
            File file1 = new File(path1);
            Scanner scanner = new Scanner(file1);

            //loops through the first file of variables, adding values to variable list & maps letter --> domain
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char tmpVar = variable.setVariables(line);
                listOfVariables.add(tmpVar);
                variableValues.put(variable.letter, variable.domainValues);
            }

            // Print error handler
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred, File could not be opened.");
            e.printStackTrace();
        }
    }

}
