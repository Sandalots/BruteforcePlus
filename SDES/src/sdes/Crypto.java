/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes; // Project packaged is defined as 'sdes'

import java.util.*; // Importation required for dealing with ArrayLists and additonal Array methods, and Collection methods that helps the project manipulate arrays more easily.
/**
 *
 * @author sandymacdonald
 */

/*
Statement of Compliance
The crypto class currently houses all the methods/fields that the Encryption/Decryption classes need.
*/
public class Crypto { // class deals with permutations and transformations.
    
    /* This class houses the permutation methods and fields that both the Encryption/Decryption classes depend upon and require to work out their respective output.
    * Fields */
    // private ArrayList<Integer> SW; // field for declaring the SW method output

    /*Permutation and Transformation methods below.
    * Migrate IP/SW methods here.
    *(Sourced from Encryption class)
    */
    public static ArrayList getInitialPermutation(Binary plaintext) { // Should be changed to return a binary item and not an arraylist, then inverse ip can be permutatec
        //System.out.println(plaintext + "lol");
        ArrayList<Integer> testIP = plaintext.getComponents(); // Declares a new array list of integers named testIP which gets all the components of the plaintext and uses them for the array items.
        //System.out.println(testIP + " why?"); // Outputs testIP, for testing purposes
        //System.out.println("Original Plaintext"); // Outputs Original Plaintext, for testing purposes
        
        // 2 6 3 1 4 8 5 7 ( quick reminider of the permutation structure of the IP.
        //1, 0, 1, 0, 0, 1, 0, 0 
        
        Integer[] array = testIP.toArray(new Integer[8]); // Declares a new integer arraylist named array and takes the testIP components and forms a 8 length arraylist with it.
        Integer[] array2 = testIP.toArray(new Integer[8]); // Declares a new integer arraylist named array2 and takes the testIP components and forms a 8 length arraylist with it.
        array[0] = array2[1];   // sets index 0 to be index 1 of array 2 
        array[1] = array2[5];   // sets index 1 to be index 5 of array 2 
        array[2] = array2[2];   // sets index 2 to be index 2 of array 2 
        array[3] = array2[0];   // sets index 3 to be index 0 of array 2 
        array[4] = array2[3];   // sets index 4 to be index 3 of array 2 
        array[5] = array2[7];   // sets index 5 to be index 7 of array 2 
        array[6] = array2[4];   // sets index 6 to be index 4 of array 2 
        array[7] = array2[6];   // sets index 7 to be index 6 of array 2 
        
       //System.out.println(array);
        ArrayList<Integer> IP = new ArrayList<>(); // Declares a new arraylist of integers named IP 
        Collections.addAll(IP, array); // Add the permutated array values to the newly created IP arraylist.
        
        //System.out.println(IP); // Test print statement to output the contents of the IP arraylist and to check/observe the values.
        return IP; // returns an integer array on which the IP has been produced upon the plaintext variable.
        } // end getInitialPermutation method.
    
    //Defines a method to get the Switching transformation
    public static ArrayList<Integer> switchingTransformation(ArrayList<Integer> BG1) { // Method to work out the switchingTransformation
        // This happens between BG1 and BG2 , therefore BG1 is taken as input  
        Integer[] array = BG1.toArray(new Integer[8]); // Creates a new integer array named array and takes the BG1 input and makes an array of 8 items in length with BG1 contents as it's items aswell.
        //declaring fresh array where new values will be stored 
        Integer[] arrayNew = new Integer[8]; // Creates a new integer array named array new of 8 items in length.
        arrayNew[0] = array[4]; // Sets the value of index 0 of arrayNew to be the value of index 4 of the array array.
        arrayNew[1] = array[5]; // Sets the value of index 1 of arrayNew to be the value of index 5 of the array array.
        arrayNew[2] = array[6]; // Sets the value of index 2 of arrayNew to be the value of index 6 of the array array.
        arrayNew[3] = array[7]; // Sets the value of index 3 of arrayNew to be the value of index 7 of the array array.
        arrayNew[4] = array[0]; // Sets the value of index 4 of arrayNew to be the value of index 0 of the array array.
        arrayNew[5] = array[1]; // Sets the value of index 5 of arrayNew to be the value of index 1 of the array array.
        arrayNew[6] = array[2]; // Sets the value of index 6 of arrayNew to be the value of index 2 of the array array.
        arrayNew[7] = array[3]; // Sets the value of index 7 of arrayNew to be the value of index 3 of the array array.
        
        ArrayList<Integer> SW = new ArrayList<>(); // declares SW arraylist to be a new arraylist of integers
        Collections.addAll(SW, arrayNew); // add all the items in the arraynew array to the SW array
        //System.out.println(SW + "this is good"); // test print statement to check/debug value.
        return SW; // method returns the SW arraylist

    } // end SwitchingTransformation method.
    
    
    //For example here we can just take the ArrayList given at the end(so IP) of previous method and keep going.
    public static ArrayList getInverseInitialPermutation(ArrayList<Integer> testIP) {
        //System.out.println(IP);
        
        Integer[] arrayOld = testIP.toArray(new Integer[8]); // Declares a new integer arraylist named arrayOld for the IP permutated array
        Integer[] arrayNew = new Integer[8]; // Declares a new integer arraylist named arrayNew for containing the permutation of the inverse IP 
        
        // inverseIP (quick reminder of the permutation structure of the inverseIP)
        //4 1 3 5 7 2 8 6 
       
        arrayNew[0] = arrayOld[3];  // sets index 0 of the new array to be index 3 of the old array.
        arrayNew[1] = arrayOld[0];  // sets index 1 of the new array to be index 0 of the old array.
        arrayNew[2] = arrayOld[2];  // sets index 2 of the new array to be index 2 of the old array.
        arrayNew[3] = arrayOld[4];  // sets index 3 of the new array to be index 4 of the old array.
        arrayNew[4] = arrayOld[6];  // sets index 4 of the new array to be index 6 of the old array.
        arrayNew[5] = arrayOld[1];  // sets index 5 of the new array to be index 1 of the old array.
        arrayNew[6] = arrayOld[7];  // sets index 6 of the new array to be index 7 of the old array.
        arrayNew[7] = arrayOld[5];  // sets index 7 of the new array to be index 5 of the old array.
        
        ArrayList<Integer> inverseIP = new ArrayList<>(); // declares inverseIP arraylist to be a new arraylist of integers
        Collections.addAll(inverseIP, arrayNew); // add all the items in the arraynew array to the inverseIP array
        //System.out.println(inverseIP + "this is good"); // test print statement to check/debug value.
        return inverseIP; // method returns the inverseIP arraylist
    } // end getInverseInitialPermutation method.
} // end Crypto class.