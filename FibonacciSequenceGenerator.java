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

import java.util.Iterator;

/**
 * This class represents a generator for a Fibonacci Sequence. This class implements the
 * Iterator<Integer> interface.
 * 
 * @author Vedaant Tambi, Mouna Ayari Ben Hadj Kacem
 * @version 1.0
 * @since 1.0
 *
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  private int prev; // previous item in the sequence with respect to the current iteration
  private int next; // next item in the sequence with respect to the current iteration
  private int generatedCount; // number of items generated so far


  /**
   * The constructor makes sure that user parameters are mathematically correct (i.e logically
   * correct) and initializes them accordingly
   *
   * @param size stores the number of elements that have to be generated, given by the user 
   */
  public FibonacciSequenceGenerator(int size) {
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0)
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    // set the instance fields
    this.SIZE = size;
    prev = 0; // Since the first item does not have previous element (i.e. 0), prev initialised to 0
    next = 1; // initializes next to 1 because it is the next element after 0
    generatedCount = 0;
  }


  /**
   * An iterator method that checks if there are elements to iterate over or not
   * 
   * @return true if the next element is left to traverse and false if the last element of the
   *         sequence has been reached
   */
  @Override
  public boolean hasNext() {
    // Time complexity: O(1), where the problem size N 
    // represents the size of the sequence to generate.
    return generatedCount < SIZE;
  }

  /**
   * This method returns the current element in the sequence and moves the
   * FibonacciSequenceGenerator iterator forward
   * 
   * @return the current Integer stored in the sequence
   */
  @Override
  public Integer next() {
    // Time complexity: O(1), where the problem size N 
    // represents the size of the sequence to generate.
    if (!hasNext()) // check if the current element has a next element in this sequence
      return null;
    int current = prev; // Since prev still refers to the current element
    generatedCount++; // increment the number of generated elements so far
    prev = next; // the previous element will be the current element in the next iteration
    next += current; // the sum of the previous element (now stored in current) and the current
                     // element give the next element
    return current; // return the current number as the generated one
  }
}
