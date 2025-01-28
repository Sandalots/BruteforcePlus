/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes; // Project packaged is defined as 'sdes'

import java.util.ArrayList; // Imported .util.ArrayList for using the arraylist data structure / collection.
// import java.util.Collections; // Imported .util.Collections for adding values of one arraylist to another arraylist.

/**
 *
 * @author sandymacdonald
 * purpose: implementing the SDES encryption algorithm
 */

// The purpose of this class as the name might suggest is to get around to the encryption of our given plaintext and make sure it gets encrypted to resemble the correct ciphertext at the end
/* Statement Of Compliance
 Encryption is fully implemented and works.
*/ 
public class Encryption extends KeyGeneration { // The Encryption class inherits from the KeyGeneration class
    
    private static Binary encryption; // Defines binary number encryption that will end up being the encrypted ciphertext value.

    // The center piece of the Encryption class, the encrpt method itself to return the Encrypted ciphertext.
    public static ArrayList<Integer> encrypt(Binary plaintext, Binary ten_bit_key)  { // Final method, all the previous methods and variables come together here to produce the encrypted ciphertext text.
       //Storing variable after IP
        ArrayList<Integer> IP = Crypto.getInitialPermutation(plaintext); // Get IP from Crypto class
        //System.out.println(IP + " This is the IP.");
        
        //Storing keyOne
        ArrayList<Integer> keyOne = KeyGeneration.getKey1(ten_bit_key); // Get key 1 from KeyGeneration class, with ten_bit_key as it's parameter.
        
        //Storing value  of BG1
        ArrayList<Integer> BG1 = BlockFunctions.BG(keyOne,IP); // get BG1 from BlockFunctions class with keyOne and IP as parameters.
        
        //Doing switching method to prepare for round 2 of BlockFunction
        ArrayList<Integer> SW = Crypto.switchingTransformation(BG1); // Get SW from Crypto class with BG1 as parameter
       //System.out.println(SW + " This is the SW output."); // output SW
        
        //Round 2 
        
        //Storing keyTwo
        ArrayList<Integer> keyTwo = KeyGeneration.getKey2(ten_bit_key); // Get KeyTwo from KeyGeneration class with ten_bit_key as parameter.
        
        //Storing value of BG2
        ArrayList<Integer> BG2 = BlockFunctions.BG(keyTwo, SW); // Get BG2 from BlockFunctions class with keyTwo and SW as parameters.
        //System.out.println(BG2 + " This is the BG2 output."); // Output BG2
        
        ArrayList<Integer> ciphertext = Crypto.getInverseInitialPermutation(BG2); // Get ciphertext from the Inverse IP from BG2 from the Crypto class.
        System.out.println(ciphertext + " This is the final result of the encrypted plaintext. "); // Output ciphertext as final result.

        encryption = plaintext; // insert all of encryption formulae here.
        return BG1; // returns the ciphertext.
    } // end encrypt method.
} // end encryption class.
