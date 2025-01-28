/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes; // Project packaged is defined as 'sdes'

import java.util.Arrays; // Imported .util.Arrays for printing two dimenensional arrays to string.
import java.util.ArrayList; // Imported .util.ArrayList for implementing Arraylist data structure.
import java.util.Collections; // Imported .util.Collections for adding values of one arraylist to another arraylist.
/**
 *
 * @author sandymacdonald
 */
/*Statement of compliance
* The BlockFunctions class currently structures both sBoxes and is home to their respective methods.
*/
public class BlockFunctions { // class deals with the Sbox's and the BlockFunctions.
    
    // Fields
    public int[][] SBox0;   // Defines a two dimensional integer array for representing sBox0
    public int[][] SBox1;   // Defines a two dimensional integer array for representing sBox1
    
    static int[][] Sbox0 = { // Defines the content of Sbox0, to host the contents shown in the SDES powerpoint that we were given, the matrix of numbers was transitionined into an 2d integer array
      {1,0,3,2},
      {3,2,1,0},
      {0,2,1,3},
      {3,1,3,1}
  }; // end definiton of sbox0
   
    static int[][] Sbox1 = { // Defines the content of Sbox1
      {0,1,2,3},
      {2,0,1,3},
      {3,0,1,0},
      {2,1,0,3}
  }; // end definition of sbox1
   
    //Getters
    // Methods to work out the block functions
    public static int[][] getSbox0() { // returns the 2d integer array of Sbox0
        return Sbox0;   // method returns the Sbox0 in a two dimensional integer array format.
    } // end getSbox0 method.
   
    public static int[][] getSbox1() { // returns the 2d integer array of Sbox1
        return Sbox1;   // method returns the Sbox1 in a two dimensional integer array format.
    } // end getSbox1 method.
    
    public static int[][] getSbox1Value(int x, int y) {
      //  return Sbox1[x][y];
      return null;
    } // end getSbox1Value methods.
  
    public static String getStringOfSbox0() { // return a string representation of Sbox 0
        return Arrays.deepToString(Sbox0);  // Uses Java's builtin Arrays class to return the string representation of the two dimensional integer sBox0 array.
    } // end getStringOfSbox0 method.

    public static String getStringOfSbox1() { // gets and returns a string representation of Sbox 1
        return Arrays.deepToString(Sbox1);  // Uses Java's builtin Arrays class to return the string representation of the two dimensional integer sBox1 array.
    } // end getStringOfSbox1 method.

    // Method for expanding and permutating 
    public static ArrayList expandAndPermutate(ArrayList<Integer> list){ // receives the return value from getInitialPermutation()
        Integer[] array = list.toArray(new Integer[8]); // convert it into an array
        // the right half of IP is being stored in an array
        
        Integer[] rightHalf = new Integer[4]; // Defines an integer array named rightHalf of 4 items of a new Integer array.
        rightHalf[0] = array[4];    // Assigns index 0 of rightHalf to have the value of index 4 of array.
        rightHalf[1] = array[5];    // Assigns index 1 of rightHalf to have the value of index 5 of array.
        rightHalf[2] = array[6];    // Assigns index 2 of rightHalf to have the value of index 6 of array.
        rightHalf[3] = array[7];    // Assigns index 3 of rightHalf to have the value of index 7 of array.
        
        // E/P: 4 1 2 3 2 3 4 1
        Integer[] indexes = new Integer[]{3,0,1,2,1,2,3,0}; // Declares a new Integer array named indexes as a new Integer array with the items set following the declaration
        ArrayList permutateEP = new ArrayList<Integer>(); // Declares a new ArrayList named permutateEP as a new Arraylist of integers
        for(int num: indexes){ // Loop through each num in the indexes array
            permutateEP.add(rightHalf[num]); // add the rightHalf of the nth index within the rightTahlf array into the permutateEP arraylist of integers
        } // end for loop.
        //System.out.println(permutateEP); // Test print statement to debug the output of the permutateEP arraylist
        
        return permutateEP; // method returns the expanded and permutated integer arraylist
    } // end permutateEP method
    
    // May need to convert the 2d array sBox(s) to arrayList of integers, or change their declaration so that they are declared an ArrayList of Integers.
    
    // Method for permutating p4
    public static ArrayList permutateP4(ArrayList<Integer> S0, ArrayList<Integer> S1){ // assuming that S-box values will be arraylists too
        Integer[] S0Array = S0.toArray(new Integer[2]); // Declares an integer arraylist named S0Array comprised of the values of the S0 integer arraylist
        Integer[] S1Array = S1.toArray(new Integer[2]); // Declares an integer arraylist named S1Array comprised of the values of the S1 integer arraylist      
        
        Integer[] P4Array = new Integer[4]; // Defines a new integer arraylist named P4Array for getting the P4 permutation.
                
        // P4: 2 4 3 1
        P4Array[0] = S0Array[1];    // permutates index 0 of the p4 array to be index 1 of sbox0.
        P4Array[1] = S1Array[1];    // permutates index 1 of the p4 array to be index 1 of sbox1.
        P4Array[2] = S1Array[0];    // permutates index 2 of the p4 array to be index 0 of sbox1.
        P4Array[3] = S0Array[0];    // permutates index 3 of the p4 array to be index 0 of sbox0.
        
        ArrayList P4 = new ArrayList<Integer>(); // Declares P4 to be a new arraylist comprosied of integers
        Collections.addAll(P4, P4Array); // Add the values of the P4Array to the recently created P4 final arraylist
        
        return P4; // method returns the p4 arraylist
    } // end permutateP4 method
    
    // Method for executing XOR operations:
    public static Integer[] calculateXOR(Integer[] firstValue, Integer[] secondValue){ // Accepts two integer arrays as parameters
        int lengthOfValues = secondValue.length; // Determine the length of values(the input can be either 8-bit or 4-bit)
        Integer[] resultXOR = new Integer[lengthOfValues];
        
        for(int i = 0; i < lengthOfValues; i++){ // Executes XOR on all elements of both inputs
            resultXOR[i] = firstValue[i] ^ secondValue[i];
        } // end for loop.
        
        return resultXOR; // Returns the result
    } // end of calculateXOR method
    
       
    // Blockfunction:
    
    public static ArrayList BG (ArrayList<Integer> subKey, ArrayList<Integer> IP) { // Accepts two arguments, a Key and an 8-bit value depending on where we are in the Encryption/Decryption process
        
        // EXPAND AND PERMUTATE:        
        ArrayList<Integer> EP = expandAndPermutate(IP); // Performs the expandAndPermutate method        
        
        Integer[] ep1 = EP.toArray(new Integer[8]); // Declares a new integer array named EP1 that uses the original EP arraylist items to create a new integer array of a length 8 of items.        
        Integer[] subkey = subKey.toArray(new Integer[8]); // Creates a new integer array named subkey which gets the items of subkey1 and creates a new integer array with a length of 8 items.
                
        // FIRST XOR OPERATION:        
        Integer[] firstXOR = calculateXOR(ep1, subkey); // Stores the return value of the method in a variable ("firstXOR")             
        
        
        Integer[] newsLeft = new Integer[4]; // Left half of XOR result
        Integer[] newsRight = new Integer[4]; // Right half of XOR result
        
        for(int i = 0; i < 8; i++){ // Splits up "firstXOR" to two 4-bits (2 arrays representing the Left and Right side)
            if(i < 4){ // if statement for when the value of i is less than four.
                newsLeft[i] = firstXOR[i]; // assigns the nth value of newsLeft to the the nth index of the firstXOR array.
            }else{ // end if statement, and present an else statement.
                newsRight[i - 4] = firstXOR[i]; // Get the latter nth index of the newsRight array and assign it to be the nth index of the firstXOR arry.
            } // end else statement.
        } // end for loop.
        
        // Determining the binary representation of rows and columns in S-boxes
        int firstSboxRow = Integer.parseInt(Integer.toString(newsLeft[0]) + Integer.toString(newsLeft[3])); // Parse first Sbox rows.
        int firstSboxCol = Integer.parseInt(Integer.toString(newsLeft[1]) + Integer.toString(newsLeft[2])); // Parse first Sbox columns.
        int secondSboxRow = Integer.parseInt(Integer.toString(newsRight[0]) + Integer.toString(newsRight[3])); // Parse secound sBox rows.
        int secondSboxCol = Integer.parseInt(Integer.toString(newsRight[1]) + Integer.toString(newsRight[2])); // Parse secound sBox columns.
        // Converting binary values to decimal, and use them to find correpsonding values in the 2D S-box arrays
        int firstSbox = Sbox0[Binary.SboxToDecimal(firstSboxRow)][Binary.SboxToDecimal(firstSboxCol)]; // convert Sbox0 to decimal, and find the corresponding values in sbox0 two dimensional array.
        int secondSbox = Sbox1[Binary.SboxToDecimal(secondSboxRow)][Binary.SboxToDecimal(secondSboxCol)]; // convert Sbox1 to decimal, and find the corresponding values in sbox1 two dimensional array.
        
        // The values returned from the S-boxes then converted back to binary
        ArrayList firstSboxArrayList = new ArrayList<Integer>(); // Gets the ArrayList of the first Sbox.
        firstSboxArrayList = Binary.SboxToBinary(firstSbox);     
        ArrayList secondSboxArrayList = new ArrayList<Integer>(); // gets the ArrayList of the secound Sbox.
        secondSboxArrayList = Binary.SboxToBinary(secondSbox);       
        
        
        ArrayList<Integer> P4 = permutateP4(firstSboxArrayList, secondSboxArrayList); // "permutateP4" method, return value stored in an ArrayList variable
        Integer[] afterP4 = P4.toArray(new Integer[4]); // P4 converted into an array
        
        Integer[] array = IP.toArray(new Integer[8]); // Input value converted into an array      
        Integer[] leftHalf = new Integer[4];  // Array to store the left half of the input value
        Integer[] rightHalf = new Integer[4]; // Array to store the right half of the input value
        
        for(int i = 0; i < 8; i++){ // Splits up the 8-bit input to two 4-bits
            if(i < 4){ // if loop for when i is less than 4
                leftHalf[i] = array[i]; // make the nth index of the leftHalf array equal to the nth index of the array array.
            }else{ // else statement
                rightHalf[i - 4] = array[i]; // make the latter nth indexes of the RightHalf array equal to the nth index of the array array.
            } // end else statement.         
        } // end for loop.
                
        // SECOND XOR OPERATION              
        Integer[] secondXOR = calculateXOR(afterP4, leftHalf); // Creates an integer array named secondXOR and prompts the calculateXOr method for the afterP4 array an the leftHalf array thus working out the secoundXOR operation.
        
        // Create a new arrayslist for the final result, and add two 4bits to it (secondXOR and tthe original right half from the 8-bit input)        
        ArrayList result = new ArrayList(Arrays.asList(secondXOR));
        result.addAll(Arrays.asList(rightHalf));
                
        //System.out.println(result + "right before SW"); // TEST - WORKING      
        
        return result; // Returns the result of the block function
        
    } // end BG Method.
}// end BlockFUnctions class.
