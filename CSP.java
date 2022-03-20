import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// CSP class
public class CSP {
    Variable variable = new Variable();                                       // create variable object
    Constraints constraints = new Constraints();

    // opens path1 file to assign variable Data
    public void  AssignVariable(String path1, String path2) {
        try {
            //opens scanner on variable file
            File file1 = new File(path1);
            Scanner scanner = new Scanner(file1);

            //loops through the first file of variables, adding values to variable list & maps letter --> domain values
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char tmpVar = variable.setVariables(line);
                variable.varDom.put(tmpVar,variable.domainValues);         // key --> domain value mapping
            }

            scanner.close();

            File file2 = new File(path2);
            scanner = new Scanner(file2);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] s = Constraints.getConstraint(line);

                //constraints.add(s);
            }


            // Print error handler
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred, File could not be opened.");
            e.printStackTrace();
        }


    }

}
