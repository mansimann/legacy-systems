package edu.bu.met.cs665.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: Mansi Mann.
 * Date: 03/10/2022
 * Course: CS-665
 * Assignment 4
 * Description: This class represents the company.
 */
public class Company {

  private static final Map<CustomerID, Customer> customers = new HashMap<>();

  /**
   * Adds a customer.
   *
   * @param customer customer to be added
   */
  public static void addCustomer(Customer customer) {
    customers.put(customer.getCustomerID(), customer);
  }

  /**
   * Gets a hashmap of CustomerID/Customer pairs.
   *
   * @return a hashmap of CustomerID/Customer pairs.
   */
  public static Map<CustomerID, Customer> getCustomers() {
    return new HashMap<>(customers);
  }

}
