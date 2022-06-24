package edu.bu.met.cs665.other;

/**
 * Name: Mansi Mann.
 * Date: 03/10/2022
 * Course: CS-665
 * Assignment 4
 * Description: This class represents a customer id.
 */
public class CustomerID {

  private int number;
  private static int idCounter = 1;

  /**
   * Class constructor.
   */
  protected CustomerID() {
    this.number = idCounter++; // assign unique number
  }

  /**
   * Returns a string representation of customer id.
   *
   * @return a string representation of customer id
   */
  public String toString() {
    return String.valueOf(number);
  }
}
