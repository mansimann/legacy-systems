package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.interfaces.CustomerDataOverHttps;
import edu.bu.met.cs665.other.Company;
import edu.bu.met.cs665.other.CustomerID;

/**
 * Name: Mansi Mann.
 * Date: 03/10/2022
 * Course: CS-665
 * Assignment 4
 * Description: This concrete class implements the adaptee interface CustomerDataOverHttps.
 */
public class CustomerDataOverHttpsServer implements CustomerDataOverHttps {

  @Override
  public void printCustomer(CustomerID id) {
    System.out.println(Company.getCustomers().get(id));
  }

  @Override
  public String getCustomer_withHttpsConnect(CustomerID id) {
    return Company.getCustomers().get(id).toString();
  }

}