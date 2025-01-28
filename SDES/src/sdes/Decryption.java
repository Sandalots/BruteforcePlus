/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes; // Project packaged is defined as 'sdes'

import java.util.ArrayList;


/**
 *
 * @author sandymacdonald
 * purpose: implementing the SDES decryption algorithm
 */

/* Statement Of Compliance
Decryption class is fully implemented and works out the decryption perfectly.
*/
public class Decryption extends KeyGeneration { // The Decryption class inherits from the KeyGeneration class.
    
    //Fields
    private static Binary decrypt; // Defines a empty Binary object named decrypt that will be used in the decrypt method and will be the returned decrypted plaintext number.
    
    public static ArrayList<Integer> decrypt(Binary ciphertext, Binary ten_bit_key)  { // Final method, all the previous methods and variables come together here to produce the encrypted ciphertext text.
        ArrayList<Integer> IP = Crypto.getInitialPermutation(ciphertext); // Get IP from Crypto class
        //System.out.println(IP + " This is the IP.");
        
        //Storing keyOne
        ArrayList<Integer> keyTwo = KeyGeneration.getKey2(ten_bit_key); // Get key 1 from KeyGeneration class, with ten_bit_key as it's parameter.
        
        //Storing value  of BG1
        ArrayList<Integer> BG1 = BlockFunctions.BG(keyTwo,IP); // get BG1 from BlockFunctions class with keyOne and IP as parameters.
        
        //Doing switching method to prepare for round 2 of BlockFunction
        ArrayList<Integer> SW = Crypto.switchingTransformation(BG1); // Get SW from Crypto class with BG1 as parameter
        //System.out.println(SW + " This is the SW output."); // output SW
        
        //Round 2 
        
        //Storing keyTwo
        ArrayList<Integer> keyOne = KeyGeneration.getKey1(ten_bit_key); // Get KeyTwo from KeyGeneration class with ten_bit_key as parameter.
        
        //Storing value of BG2
        ArrayList<Integer> BG2 = BlockFunctions.BG(keyOne, SW); // Get BG2 from BlockFunctions class with keyTwo and SW as parameters.
        //System.out.println(BG2 + " This is the BG2 output."); // Output BG2
        
        ArrayList<Integer> plaintext = Crypto.getInverseInitialPermutation(BG2); // Get plaintext from the Inverse IP from BG2 from the Crypto class.
        System.out.println(plaintext + " This is the final result of the decrypted ciphertext. "); // Output plaintext as final result.
        
        decrypt = ciphertext;
        return BG1; // return the plaintext.
    } // end decrypt method.
} // end decryption class.