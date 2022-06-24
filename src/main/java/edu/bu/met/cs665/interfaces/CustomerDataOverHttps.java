package edu.bu.met.cs665.interfaces;

import edu.bu.met.cs665.other.CustomerID;

/**
 * Name: Mansi Mann.
 * Date: 03/10/2022
 * Course: CS-665
 * Assignment 4
 * Description: This interface represents adaptee in the adapter method.
 */
public interface CustomerDataOverHttps {
  /**
   * Prints customer data.
   *
   * @param id customer id
   */
  public void printCustomer(CustomerID id);

  /**
   * Gets customer data via new system using HTTPS connection.
   *
   * @param id customer id
   * @return customer data
   */
  public String getCustomer_withHttpsConnect(CustomerID id);
}
