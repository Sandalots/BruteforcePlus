/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes; // Project packaged is defined as 'sdes'

import java.util.ArrayList; // Imported to use ArrayLists objects
import java.util.Collections; // Imported .util.Collections to add the values of one arraylist to another arraylist

/**
 *
 * @author sandymacdonald
 * purpose: to work out both keys and other problems relating to the ten bit key
 * 
 */

/* Statement of compliance
Key generation class is fully implemented and works out the two keys perfectly and is in a working state.
*/

public class KeyGeneration {
    
    //Fields
    // N/A, not needed.
    
    // Defines a method for getting the Key 1 from the ten bit key
    public static ArrayList getKey1(Binary plaintext) { // method to get key 1.
        
        ArrayList<Integer> testKey = plaintext.getComponents(); // Declares a new arraylist of integers named testkey that contains the components of the plaintext
        Integer[] array = testKey.toArray(new Integer[10]); // Declares a new integer arraylist named array which gets all the values of the testkey array, with a array length of ten.
        Integer[] arrayClean = new Integer[10]; // Declares yet another integer arraylist named arrayclean that also contains of a ten length array.
        // 3 5 2 7 4 10 1 9 8 6 
        
        arrayClean[0] = array[2];   // Assigns index 0 of array clean to be index 2 of array.
        arrayClean[1] = array[4];   // Assigns index 1 of array clean to be index 4 of array.
        arrayClean[2] = array[1];   // Assigns index 2 of array clean to be index 1 of array.
        arrayClean[3] = array[6];   // Assigns index 3 of array clean to be index 6 of array.
        arrayClean[4] = array[3];   // Assigns index 4 of array clean to be index 3 of array.
        arrayClean[5] = array[9];   // Assigns index 5 of array clean to be index 9 of array.
        arrayClean[6] = array[0];   // Assigns index 6 of array clean to be index 0 of array.
        arrayClean[7] = array[8];   // Assigns index 7 of array clean to be index 8 of array.
        arrayClean[8] = array[7];   // Assigns index 8 of array clean to be index 7 of array.
        arrayClean[9] = array[5];   // Assigns index 9 of array clean to be index 5 of array.
      
        //now P10 is acquired (arrayClean)
      
        //Divide them in 2 shift by -1
        Integer[] leftArray = new Integer[5]; // Creates a new integer array named leftarray with a length of 5.
        for( int i  = 0 ; i < leftArray.length ; i++) { // for loop, loops 5 times to find first 5 values in arrayclean.
            leftArray[i] = arrayClean[i]; // gets the first 5 values of arrayclean and adds then to the left array 
            //  System.out.println(leftArray[i] + "itworked");
        } // end for loop.
      
        Integer[] rightArray = new Integer[5]; // creates a new integer array named rightarray with length 5, for the next 5 values in the arrayclean
        Integer[] secondHalf = new Integer[5]; // creates a helper array named secondHalf for putting the next 5 values into the rightarray
        
        secondHalf[0] = arrayClean[5];  // Assigns index 0 of secondHalf to be the value of index 5 of arrayClean.
        secondHalf[1] = arrayClean[6];  // Assigns index 1 of secondHalf to be the value of index 6 of arrayClean.
        secondHalf[2] = arrayClean[7];  // Assigns index 2 of secondHalf to be the value of index 7 of arrayClean.
        secondHalf[3] = arrayClean[8];  // Assigns index 3 of secondHalf to be the value of index 8 of arrayClean.
        secondHalf[4] = arrayClean[9];  // Assigns index 4 of secondHalf to be the value of index 9 of arrayClean.
        
        for ( int i = 0  ; i < rightArray.length ; i ++ ) { // loops 5 times to find the last 5 values of array
            rightArray[i] = secondHalf[i]; // assigns the nth index of rightarray to be the nth index of secondHalf
            // System.out.println(rightArray[i] + "itworked");
        } // end for loop.
      
        Integer[] shiftedLeftArray = new Integer[5]; // Creates a new integer array named shiftedLeftArray comporised of a new integer array with 5 items
        shiftedLeftArray[0] = leftArray[1]; // Modifies shiftedLeftArray index 0 to be the value of index 1 in the leftArray
        shiftedLeftArray[1] = leftArray[2]; // Modifies shiftedLeftArray index 1 to be the value of index 2 in the leftArray     
        shiftedLeftArray[2] = leftArray[3]; // Modifies shiftedLeftArray index 2 to be the value of index 3 in the leftArray
        shiftedLeftArray[3] = leftArray[4]; // Modifies shiftedLeftArray index 3 to be the value of index 4 in the leftArray
        shiftedLeftArray[4] = leftArray[0]; // Modifies shiftedLeftArray index 4 to be the value of index 0 in the leftArray
      
        Integer[] shiftedRightArray = new Integer[5]; // Creates a new integer array named shiftedRightArray to be a new integer array list with 5 items
        shiftedRightArray[0] = secondHalf[1];   // Modifies shiftedRightArray index 0 to be the value of index 1 in the secondHalf array
        shiftedRightArray[1] = secondHalf[2];   // Modifies shiftedRightArray index 1 to be the value of index 2 in the secondHalf array
        shiftedRightArray[2] = secondHalf[3];   // Modifies shiftedRightArray index 2 to be the value of index 3 in the secondHalf array
        shiftedRightArray[3] = secondHalf[4];   // Modifies shiftedRightArray index 3 to be the value of index 4 in the secondHalf array
        shiftedRightArray[4] = secondHalf[0];   // Modifies shiftedRightArray index 4 to be the value of index 0 in the secondHalf array
      
        //Doing p8 now (order is 6 3 7 4 8 5 10 9 )
        Integer[] keyOne = new Integer[8];  // Creates a new integer array named keyOne to store 8 integer items
        keyOne[0] = shiftedRightArray[0];   // Sets keyone index 0 to be the value of index 0 of shiftedRightArray
        keyOne[1] = shiftedLeftArray[2];    // Sets keyone index 1 to be the value of index 2 of shiftedLeftArray
        keyOne[2] = shiftedRightArray[1];   // Sets keyone index 2 to be the value of index 1 of shiftedRightArray
        keyOne[3] = shiftedLeftArray[3];    // Sets keyone index 3 to be the value of index 3 of shiftedLeftArray
        keyOne[4] = shiftedRightArray[2];   // Sets keyone index 4 to be the value of index 2 of shiftedRightArray
        keyOne[5] = shiftedLeftArray[4];    // Sets keyone index 5 to be the value of index 4 of shiftedLeftArray
        keyOne[6] = shiftedRightArray[4];   // Sets keyone index 6 to be the value of index 4 of shiftedRightArray
        keyOne[7] = shiftedRightArray[3];   // Sets keyone index 7 to be the value of index 3of shiftedRightArray
        //Putting K1 into arrayList
        ArrayList<Integer> keyOneList = new ArrayList<>(8); // Creates the final arraylist of integers named keyOneList that will store the final components of keyone
        Collections.addAll(keyOneList, keyOne); // Add all the items of the KeyOne array into the newly created keyOneList arraylist
        //System.out.println(keyOneList + " this is K1"); // test print statement to debug the contents/items of keyone
    
        return keyOneList; // method returns key one, or the arraylist containing the values/components of key 1
    } // end getKey1 method.
    
    // Defines a method for getting the Key 2 from the ten bit key
    public static ArrayList getKey2(Binary plaintext) { // Method to return the arraylist of keytwo
        
        ArrayList<Integer> testKey = plaintext.getComponents(); // Declares a new integer arrayList named/identified testKey which gets the components of the plaintext field and uses them as the item in the testKey arraylist.
        Integer[] array = testKey.toArray(new Integer[10]); // Declares a new integer array named array which uss the items of the testkey and turns it into an array of ten items with the items from the testKey array.
        Integer[] arrayClean = new Integer[10]; // Declares a new integer array named arrayClean as a new arraylist of integers with ten items
        // 3 5 2 7 4 10 1 9 8 6 
      
        arrayClean[0] = array[2];   // Modifies arrayClean index 0 to be the value of index 2 of array.
        arrayClean[1] = array[4];   // Modifies arrayClean index 1 to be the value of index 4 of array.
        arrayClean[2] = array[1];   // Modifies arrayClean index 2 to be the value of index 1 of array.
        arrayClean[3] = array[6];   // Modifies arrayClean index 3 to be the value of index 6 of array.
        arrayClean[4] = array[3];   // Modifies arrayClean index 4 to be the value of index 3 of array.
        arrayClean[5] = array[9];   // Modifies arrayClean index 5 to be the value of index 9 of array.
        arrayClean[6] = array[0];   // Modifies arrayClean index 6 to be the value of index 0 of array.
        arrayClean[7] = array[8];   // Modifies arrayClean index 7 to be the value of index 8 of array.
        arrayClean[8] = array[7];   // Modifies arrayClean index 8 to be the value of index 7 of array.
        arrayClean[9] = array[5];   // Modifies arrayClean index 9 to be the value of index 5 of array.
      
        //now P10 is acquired (arrayClean)
      
        //Divide them in 2 shift by -1
        Integer[] leftArray = new Integer[5];   // Creates a new integer array named leftarray with an item length of 5.
        for( int i  = 0 ; i < leftArray.length ; i++) { // loop 5 times through leftArray
            leftArray[i] = arrayClean[i]; // makes the nth index of leftArray the nth index of arrayClean
            // System.out.println(leftArray[i] + "itworked");
        } // end for loop.
      
        Integer[] rightArray = new Integer[5]; // Declares a new integer array named rightArray with an item length of 5
        Integer[] secondHalf = new Integer[5]; // Declares a helper integer array named secondHalf with an item length of 5
        secondHalf[0] = arrayClean[5];  // Modifies index 0 of secondHalf to be the value of index 5 of arrayClean
        secondHalf[1] = arrayClean[6];  // Modifies index 1 of secondHalf to be the value of index 6 of arrayClean
        secondHalf[2] = arrayClean[7];  // Modifies index 2 of secondHalf to be the value of index 7 of arrayClean
        secondHalf[3] = arrayClean[8];  // Modifies index 3 of secondHalf to be the value of index 8 of arrayClean
        secondHalf[4] = arrayClean[9];  // Modifies index 4 of secondHalf to be the value of index 9 of arrayClean
        for ( int i = 0  ; i < rightArray.length ; i ++ ) { // loops 5 times through rightArray
            rightArray[i] = secondHalf[i]; // Makes the nth index of rightArray the nth index value of the secondHalf array
            // System.out.println(rightArray[i] + "itworked");
        } // end for loop.
      
        Integer[] shiftedLeftArray = new Integer[5]; // Declares a new integer array named shiftedLeftArray with a item length of 5
        shiftedLeftArray[0] = leftArray[1]; // Makes the index 0 of shiftedLeftArray to be the value of index 1 of the leftArray
        shiftedLeftArray[1] = leftArray[2]; // Makes the index 1 of shiftedLeftArray to be the value of index 2 of the leftArray
        shiftedLeftArray[2] = leftArray[3]; // Makes the index 2 of shiftedLeftArray to be the value of index 3 of the leftArray
        shiftedLeftArray[3] = leftArray[4]; // Makes the index 3 of shiftedLeftArray to be the value of index 4 of the leftArray
        shiftedLeftArray[4] = leftArray[0]; // Makes the index 4 of shiftedLeftArray to be the value of index 0 of the leftArray
      
        Integer[] shiftedRightArray = new Integer[5]; // Declares a new integer array named shiftedRightArray with a item length of 5
        shiftedRightArray[0] = secondHalf[1];   // Makes the index 0 of shiftedRightArray to be the value of index 1 of the secondHalf integer array
        shiftedRightArray[1] = secondHalf[2];   // Makes the index 1 of shiftedRightArray to be the value of index 2 of the secondHalf integer array
        shiftedRightArray[2] = secondHalf[3];   // Makes the index 2 of shiftedRightArray to be the value of index 3 of the secondHalf integer array
        shiftedRightArray[3] = secondHalf[4];   // Makes the index 3 of shiftedRightArray to be the value of index 4 of the secondHalf integer array
        shiftedRightArray[4] = secondHalf[0];   // Makes the index 4 of shiftedRightArray to be the value of index 0 of the secondHalf integer array
       
        Integer[] shiftedLeftArrayTwo = new Integer[5]; // Declares a new integer array named shiftedLengthArrayTwo with largely the same process as shiftedLeftArray
        shiftedLeftArrayTwo[0] = shiftedLeftArray[2];   // Makes the index 0 of shiftedLeftArrayTwo to be the value of index 2 of the shiftedLeftArray
        shiftedLeftArrayTwo[1] = shiftedLeftArray[3];   // Makes the index 1 of shiftedLeftArrayTwo to be the value of index 3 of the shiftedLeftArray
        shiftedLeftArrayTwo[2] = shiftedLeftArray[4];   // Makes the index 2 of shiftedLeftArrayTwo to be the value of index 4 of the shiftedLeftArray
        shiftedLeftArrayTwo[3] = shiftedLeftArray[0];   // Makes the index 3 of shiftedLeftArrayTwo to be the value of index 0 of the shiftedLeftArray
        shiftedLeftArrayTwo[4] = shiftedLeftArray[1];   // Makes the index 4 of shiftedLeftArrayTwo to be the value of index 1 of the shiftedLeftArray
      
        Integer[] shiftedRightArrayTwo = new Integer[5];    // Declares a new integer array named shiftedRightArrayTwo to be a new integer array of 5 items
        shiftedRightArrayTwo[0] = shiftedRightArray[2]; // Makes the index 0 of shiftedRightArrayTwo to be the value of index 2 of shiftedRightArray
        shiftedRightArrayTwo[1] = shiftedRightArray[3]; // Makes the index 1 of shiftedRightArrayTwo to be the value of index 3 of shiftedRightArray
        shiftedRightArrayTwo[2] = shiftedRightArray[4]; // Makes the index 2 of shiftedRightArrayTwo to be the value of index 4 of shiftedRightArray
        shiftedRightArrayTwo[3] = shiftedRightArray[0]; // Makes the index 3 of shiftedRightArrayTwo to be the value of index 0 of shiftedRightArray
        shiftedRightArrayTwo[4] = shiftedRightArray[1]; // Makes the index 4 of shiftedRightArrayTwo to be the value of index 1 of shiftedRightArray
     
        Integer[] keyTwo = new Integer[8]; // Makes a new integer array named keyTwo with an item length of 8
        keyTwo[0] = shiftedRightArrayTwo[0];    // Sets index 0 of KeyTwo to be the index 0 of shiftedRightArrayTwo
        keyTwo[1] = shiftedLeftArrayTwo[2]; // Sets index 1 of KeyTwo to be the index 2 of shiftedLeftArrayTwo
        keyTwo[2] = shiftedRightArrayTwo[1];    // Sets index 2 of KeyTwo to be the index 1 of shiftedRightArrayTwo
        keyTwo[3] = shiftedLeftArrayTwo[3]; // Sets index 3 of KeyTwo to be the index 3 of shiftedLeftArrayTwo
        keyTwo[4] = shiftedRightArrayTwo[2];    // Sets index 4 of KeyTwo to be the index 2 of shiftedRightArrayTwo
        keyTwo[5] = shiftedLeftArrayTwo[4]; // Sets index 5 of KeyTwo to be the index 4 of shiftedLeftArrayTwo
        keyTwo[6] = shiftedRightArrayTwo[4];    // Sets index 6 of KeyTwo to be the index 4 of shiftedRightArrayTwo
        keyTwo[7] = shiftedRightArrayTwo[3];    // Sets index 7 of KeyTwo to be the index 3 of shiftedRightArrayTwo
        
        //Putting K2 into arrayList
        ArrayList<Integer> keyTwoList = new ArrayList<>(8); // Declares the final keyTwo field, an ArrayList of integers named keyTwoList which comprosises the components of key two
        Collections.addAll(keyTwoList, keyTwo); // Add all the items of the keyTwo integer array to the newly created final keyTwoList arraylist that will be returned 
        //System.out.println(keyTwoList + " this is K2"); // Test print method for debugging the value of key two
        
        return keyTwoList; // method returns key two, or the arraylist containing the values of key two
    }   // end getKey 2 method.
} // end KeyGeneration class.
