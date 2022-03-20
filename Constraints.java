public class Constraints {
    static String firstChar, secondChar, operator;

    static String[] getConstraint(String line) {
        String[] partition = line.split(" ");

        firstChar = partition[0];
        operator = partition[1];
        secondChar = partition[2];

        return partition;
    }

}
