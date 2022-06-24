package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.interfaces.CustomerData;
import edu.bu.met.cs665.interfaces.CustomerDataOverHttps;
import edu.bu.met.cs665.other.Company;
import edu.bu.met.cs665.other.CustomerID;

/**
 * Name: Mansi Mann.
 * Date: 03/10/2022
 * Course: CS-665
 * Assignment 4
 * Description: This adapter class implements the target interface CustomerData.
 */
public class UsbToHttpsCustomerDataAdapter implements CustomerData {

  private final CustomerDataOverHttps customerDataOverHttps;

  /**
   * Class constructor specifying the adaptee object to be wrapped.
   *
   * @param customerDataOverHttps the CustomerDataOverHttpsConcrete adaptee object
   */
  public UsbToHttpsCustomerDataAdapter(final CustomerDataOverHttps customerDataOverHttps) {
    this.customerDataOverHttps = customerDataOverHttps;
  }

  @Override
  public void printCustomer(CustomerID id) {
    System.out.println(Company.getCustomers().get(id));
  }

  @Override
  public String getCustomer_withUsbConnect(CustomerID id) {
    return customerDataOverHttps.getCustomer_withHttpsConnect(id); // rewiring
  }

}
