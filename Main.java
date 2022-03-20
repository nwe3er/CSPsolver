// Main class
public class Main {
    public static void main(String[] args) {
        //gets file paths and procedure as arguments
        String path1 = args[0];
        String path2 = args[1];
        String procedure = args[2];

        // create CSP object
        CSP csp = new CSP();

        // pass path1 to get variable info
        csp.AssignVariable(path1);
    }
}
