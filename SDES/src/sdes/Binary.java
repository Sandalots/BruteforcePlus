/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdes; // Project packaged is defined as 'sdes'

import java.util.*; // Imported .util for ArrayList methods, and for Java reverse collection method

/**
 *
 * @author sandymacdonald
 * purpose: implementing the binary object class for handling binary values in the program
 */

/* Statement Of Compliance
 The binary class fully represents and handles binary numbers and is fully implemented and working.
*/
public class Binary { // class to represent and validate Binary numbers.
    
    //Fields
     private  int value; // the binary number in full, notice how this field is not final as their is a setter method users can use at will to set the value to their likings.
     private  ArrayList<Integer> components; // The individual binary digits of the binary number, this field is final as the components of the binary number will not change.
     private  int length; // the length of the binary number, the field is final as the length will not change.
    
    //Constructor for the Binary class
    public Binary(int value) { // The Binary class takes the integer representation of binary numbers and can construct them as an Integer ArrayList with all it's digits separated which makes it simple to refer to each digit and permutate them.
        //Sets the value 
        this.value = value; // sets the classes value propertie to match the value field.
        //Gets the length of the value and sets it as the value
        this.length = String.valueOf(value).length(); // sets the length of the Binary object to be the String of the values length.
        // Needs to construct a data collection in here
        this.components = new ArrayList<>();
        // Need to interate through value integer and put all its values in the components arraylist as it makes working with binary positions far simplier.
        // Loops through the binary value if the binary value integer is above 0
        while(value > 0) { // Loop through each digit in the Binary's value property. 
            //For each digit in the binary value, add it to the components ArrayList
            components.add(value % 10);
            //Increment the value
            int current_digit = value % 10; // gets the current digit in the loop
            value = value / 10; // move onto the next digit in the value
            // for loop to verify each digit in the binary value is a binary value and not a decimal value.
            if (current_digit > 1) { // checks to see if the digit is not binary. in other terms if the current digit does not return 1 or a 0 value/
                System.out.println("PLEASE ENTER A BINARY NUMBER NOT A DECIMAL NUMBER PLEASE !"); // Outputs this alert to user if the number is not a binary number.
                throw new ArithmeticException("PLEASE ENTER A BINARY NUMBER NOT A DECIMAL NUMBER PLEASE !"); // Creates an arithmetic exception error if digit is not decmial.
            } // end binary value verification.
        } // end component loop.
        Collections.reverse(components); // reverse the components, as above code enters components from right to left, where it should be left to right
        // Process to verify length, only 8 or ten bit binary values are allowed. If the user enters something not of this calibre then the program should throw an arithemtic exception error
        if (length != 8) { // verifies if length of binary number is not 8
            if (length != 10) { // verifies if length of binary number is not 10
            throw new ArithmeticException("INCORRECT SIZED BINARY VALUE ! PLEASE ENTER A LENGTH 8 PLAINTEXT/CIPHERTEXT OR A 10 LENGTH TEN BIT KEY PLEASE !!!"); // throws an ArithemticExpecetion error and tells the user the number is of incorrect size, and must be in the sizes 8 or 10.
            } // end length is not equal to ten.
        } // end length is not equal to eight.
    } // end Binary constructor.
    
    // Method for converting decimal to binary:
    public static ArrayList SboxToBinary(int decimal){ // Accepts a decimal value as a parameter
        ArrayList binaryValue = new ArrayList<Integer>(); // The variable which will hold the return value
        // Switch statement - will assign the corresponding binary representation of the decimal input
        switch(decimal){ //  switch statement uses the decimal integer variable.
            case 0: // if decimal int is 0
                binaryValue.add(0); // add 0 to binaryValue arrayList
                binaryValue.add(0); // add 0 to binaryValue arrayList
                break;  // ends switch statement
            case 1:     // if decimal int is 1
                binaryValue.add(0); // add 0 to binaryValue arrayList
                binaryValue.add(1); // add 1 to binaryValue arrayList
                break;  // ends switch statement
            case 2: // if decimal int is 2
                binaryValue.add(1); // add 1 to binaryValue arrayList
                binaryValue.add(0); // add 0 to binaryValue arrayList
                break;  // ends switch statement
            case 3: // if decimal int is 3
                binaryValue.add(1); // add 1 to binaryValue arrayList
                binaryValue.add(1); // add 1 to binaryValue arrayList
                break;  // ends switch statement
        } // end of switch statement
        
        return binaryValue; // Returns the binary representation in an ArrayList
    } // end of SboxToBinary method.
    
    // Method for converting binary to decimal:
    public static int SboxToDecimal(int binary){ // Accepts the binary value as an integer
        int decimalValue = 0; // The initial decimal value        
        int baseValue = 1; // The decimal value of the binary number
        int temp = binary; // Declare integer variable named temp that takes the value of binary.
        
        while(temp > 0){ // whiile loop for when temp is greater than zero.
            int lastDigit = temp % 10; // Finds the last digit of the binary number
            temp = temp / 10; // Updates the binary number
            
            decimalValue += lastDigit * baseValue; // Increments the decimal if lastDigit is "1"
            
            baseValue = baseValue * 2; // Increases the value of the next binary number
        } // end while loop
        
        return decimalValue; // Returns the converted value               
    } // end SboxToDecimal method.
 
    //Setters
    //Sets the binary objects value to be an integer value
    public void setValue(int value) {
        this.value = value; // sets the value of the binary number to the integer value specified by the user.
    } // end setValue method.
    
    //Getters
    // Get the binary objects value, returns it as an integer value.
    public int getValue() {
        return value; // returns the binary value in integer form.
    } // end getValue method.

    //Gets the length of each binary number
    public int getLength() { // could also use this to verify length 
        return length; // returns the number of values in the binary number
    } // end getLength method.
    
    // Output the components arraylist 
    public ArrayList<Integer> getComponents() {
        return components; // returns each digit of the binary value
    } // end getComponents method.
    
    // Get position of a component by its index value
    public int getPosition(int index) {
        return components.get(index); // returns the component at the specified index
    } // end getPosition method.
    
    // Sets the value of a binary digit in the components arraylist by its index and with its new value
    public static void setPosition(ArrayList<Integer> list , int index, int newValue) { // this needs worked on and used for permutating in other classes.
        list.set(index, newValue);  // updates the specified arraylist of integers, gets a specified index and replaces that index with a new value integer.
    } // end setPosition method.
 
   
    @Override // toString Method
    public String toString() {
        //return "Binary{" + "value=" + getValue() + '}'; // add length of the binarys and components as well.
        return "The real value of this binary number is: " + getValue() + ", the length of the value is: " + getLength() +  ", the components of this number are: " + getComponents(); // new toString method that returns the value, length and components fo the binary number.
    } // end toString method.
} // end Binary class.
