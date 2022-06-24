package edu.bu.met.cs665.other;

/**
 * Name: Mansi Mann.
 * Date: 03/10/2022
 * Course: CS-665
 * Assignment 4
 * Description: This class represents a customer.
 */
public class Customer {

  private String name;
  private int age;
  private CustomerID id;

  /**
   * Class constructor specifying a customer's name, age, and id.
   *
   * @param name customer name
   * @param age  customer age
   */
  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
    id = new CustomerID(); // assign id at instantiation
  }

  /**
   * Gets customer id.
   *
   * @return customer id
   */
  public CustomerID getCustomerID() {
    return id;
  }

  /**
   * Returns a string representation of customer.
   *
   * @return a string representation of customer.
   */
  public String toString() {
    return "ID: " + id + ", Name: " + name + ", Age: " + age;
  }

}
