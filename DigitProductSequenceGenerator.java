/**
 * /////////////////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION///////////////////////////// 
 * // Title: Sequence Generator Program // Files: Sequence.java,
 * //        ArithmeticSequenceGenerator.java, GeometricSequenceGenerator, 
 * //        FibonacciSequenceGenerator.java, DigitalProductSequenceGenerator, SequenceGeneratorTest 
 * // Course: CS 300 Fall term 2018 
 * // Author: Vedaant Tambi 
 * // Email: tambi@wisc.edu 
 * // Lecturer's Name: MOUNA AYARI BEN HADJ KACEM 
 * //////////////////////////////////////// CREDIT OUTSIDE HELP ////////////////////////////////////
 * //                                              NONE                                           //
 * //////////////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////////////
 **
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a generator for a digital product sequence.
 * 
 * @author Vedaant Tambi, Mouna Ayari Ben Hadj Kacem
 * @version 1.0
 * @since 1.0
 */
public class DigitProductSequenceGenerator {
  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; // ArrayList object storing the sequence

  /**
   * The constructor makes sure that user parameters are mathematically correct (i.e logically
   * correct) and initializes them accordingly
   * 
   * @param init stores the initial number of the sequence, given by the user
   * @param size stores the number of elements that have to be generated, given by the user
   */
  public DigitProductSequenceGenerator(int init, int size) {
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0)
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    // check for the validity of init (>0) , throw an IllegalArgumentException if these two
    // parameters are not valid
    if (init <= 0)
      throw new IllegalArgumentException("WARNING: The starting element for digit product sequence "
          + "cannot be less than or equal to zero.");
    sequence = new ArrayList<Integer>(); // ArrayList sequence is initialized
    // initialization of all the variables
    this.INIT = init;
    this.SIZE = size;
    generateSequence(); // generates the proper sequence and stores it in the ArrayList sequence
  }

  /**
   * This method generates the digit product sequence and stores it in the ArrayList sequence
   */
  public void generateSequence() {
    int digit; // represents the individual digit of the particular element in the sequence
    int digitProduct = 1; // initially the product of the digits of a number is 1
    sequence.clear(); // clears the sequence of previously stored variables
    sequence.add(INIT); // adds the first element (given by the user) into the sequence
    // need a temporary variable that needs to be manipulated to store the next element
    int temp = INIT;
    /*
     * Each iteration of the loop generates the next element to be added. Loop is exited once the
     * required number of elements have been added
     */
    for (int i = 1; i < SIZE; i++) { // Since the first number is already added, loop starts at i=1
      // This while loop calculates the product of the digits of temp (the current number in list)
      while (temp != 0) { // loop runs till all the digits have been read
        digit = temp % 10; // each digit is calculated by applying mod 10 to the number
        if (digit != 0) // checks if the digit is not 0 because only non-zero digits are considered
          // Each digit is multiplied with the previous product to generate the current product
          digitProduct *= digit;
        /*
         * the number is divided by 10 to so that places shift to the left (Hundreds to tens, tenz
         * to hundreds, etc.) and so the next digit can be calculated
         */
        temp /= 10;
      }
      // the next element is the sum of the current element and its digit product
      sequence.add(sequence.get(i - 1) + digitProduct); // adds the next number to sequence
      // the field is set back to 1 so that the digit product of the next element can be calculated
      digitProduct = 1;
      temp = sequence.get(i); // temp is set to the recently added number of the arraylist
    }
  }

  /**
   * Getter for the ArrayList sequence field's default iterator
   * 
   * @returns sequence's iterator
   */
  public Iterator<Integer> getIterator() {
    return sequence.iterator();
  }



}
