/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes; // Project packaged is defined as 'sdes'

import java.util.ArrayList; // Imported .util for ArrayList methods // Obsolete import, may well be removed
// import java.util.Arrays; // Imported .util.Arrays for additional Array based methods that allow additonal actions with array structures.
/**
 *
 * @author sandymacdonald
 */
public class Main { // Main class allows User to modify the three SDES fields, and invoke encryption and decryption at their request.
    /** Statement Of Compliance
    * Encryption and Decryption of the SDES project is fully implemented and is working perfectly. All classes work and are fully implemented.
    * The main class is fully implemented and allows for users to use or modify the three SDES fields, and allows user to encrypt and decrypt using the SDES standard.
    * The program in a whole is fully implemented, documented, tested and is working perfectly. Feel free to test it out :) 
    */
    
    /**
     * @param args the command line arguments
     * purpose: to test functionality of the SDES project
     * end goal: to invoke both the encryption and decryption of given binary values 
     */
    public static void main(String[] args) { // Program should reasonably not have any command line arguments, as the user experience will be fronted in the Main class.
   
        // This is the User Experience.
        
        // Fields for User Experience 
        Binary plaintext = new Binary(10100101); // Plaintext can be changed, default is the one Roger gave our group.
        Binary ciphertext = new Binary(10010110); // Plaintext can be changed, default is the one Roger gave our group.
        Binary ten_bit_key = new Binary(1100100110); // Plaintext can be changed, default is the one Roger gave our group.
        
        // Invoke an Encryption or Decryption.
        
        //Output encryption/decryption result verbosely.
        Encryption.encrypt(plaintext, ten_bit_key); // Invoking encryption method on the values roger gave us.
        Decryption.decrypt(ciphertext, ten_bit_key); // Invoking decryption method on the values roger gave us.

        // Please proceed to run the program.
        
    } // end Main method.
} // end Main class.
