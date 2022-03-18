import java.util.ArrayList;

// Search class to find CSP
public class Search {


   // method to find CSP using backTracking
   public ArrayList<String> backTracking(ArrayList<String> listOfConstraints, ArrayList<Character> listOfVariables, ArrayList<ArrayList<Integer>> listOfVariableValues) {
      ArrayList<String> s = null;
      //gets the MCV
      Character c = mostConstrainingVariable(listOfVariables, listOfVariableValues);

      return s;
   }
   // method to find CSP using ForwardChecking
   public ArrayList<String> ForwardChecking(ArrayList<String> listOfConstraints, ArrayList<Character> listOfVariables, ArrayList<ArrayList<Integer>> listOfVariableValues) {
      ArrayList<String> s = null;
      //gets the MCV
      Character c = mostConstrainingVariable(listOfVariables, listOfVariableValues);

     return s;
   }

   // method to find the most constraining variable
   public Character mostConstrainingVariable(ArrayList<Character> listOfVariables, ArrayList<ArrayList<Integer>> listOfVariableValues) {
      ArrayList<Integer> temp = listOfVariableValues.get(0);
      int count = 0;

      // loop to see the smallest size of domains
      for(int i = 1; i < listOfVariableValues.size(); i++) {
         // swap temp of a smaller domain size is found
         if (listOfVariableValues.get(i).size() < listOfVariableValues.get(i-1).size()) {
            temp = listOfVariableValues.get(i);
         }
         // update counter
         count++;
      }
      //return the MCV
      return listOfVariables.get(count);
   }

}
