import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        //gets file paths and procedure as arguments
        String path1 = args[0];
        String path2 = args[1];
        String procedure = args[2];
        ArrayList<Character> listOfVariables = new ArrayList<Character>();
        ArrayList<ArrayList<Integer>> listOfVariableValues = new ArrayList<ArrayList<Integer>>();
        ArrayList<String> listOfConstraints = new ArrayList<String>();
        System.out.println(path1);
        System.out.println(path2);
        System.out.println(procedure);

        try{
            //opens scanner on variable file
            File file1 = new File(path1);
            Scanner scanner = new Scanner(file1);
            //creates arraylists to hold the values in the files
            ArrayList<Integer> tempListInt = new ArrayList<Integer>();
            int counter = 0;
            //loops through the first file of variables, adding values to array list
            while(scanner.hasNextLine()){
                String temp = scanner.nextLine();
                tempListInt = new ArrayList<Integer>();
                listOfVariables.add(temp.charAt(0));
                for(int i = 0; i < temp.length(); i++){
                    if((Character.isDigit(temp.charAt(i)))){
                        tempListInt.add(Integer.parseInt(String.valueOf(temp.charAt(i))));
                    }
                }
                listOfVariableValues.add(tempListInt);
            }
            for(char i : listOfVariables){
                System.out.print("\n" + i + ": ");
                tempListInt = new ArrayList<Integer>();
                tempListInt = listOfVariableValues.get(counter);
                counter++;
                for(int j : tempListInt){
                    System.out.print(j);
                }
            }
            System.out.println();
            scanner.close();

            File file2 = new File(path2);
            scanner = new Scanner(file2);
            while(scanner.hasNextLine()){
                String temp = scanner.nextLine();
                listOfConstraints.add(temp);
            }
            for(String i : listOfConstraints){
                System.out.print("\n" + i);
            }
            System.out.println();
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}
