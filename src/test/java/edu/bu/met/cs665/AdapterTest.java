package edu.bu.met.cs665;

import edu.bu.met.cs665.other.Company;
import edu.bu.met.cs665.other.Customer;
import edu.bu.met.cs665.other.CustomerID;
import edu.bu.met.cs665.implementations.CustomerDataDisk;
import edu.bu.met.cs665.implementations.CustomerDataOverHttpsServer;
import edu.bu.met.cs665.implementations.UsbToHttpsCustomerDataAdapter;
import edu.bu.met.cs665.interfaces.CustomerData;
import edu.bu.met.cs665.interfaces.CustomerDataOverHttps;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Name: Mansi Mann.
 * Date: 02/25/2022
 * Course: CS-665
 * Assignment 4
 * Description: This is a JUnit Test that gets customer data stored on external server via the old system.
 */
public class AdapterTest {

  @Test
  public void testAdapter() {

    // Create mockup Customer objects
    Customer customer1 = new Customer("John", 25);
    Customer customer2 = new Customer("Mary", 45);

    // Add customers to company's database
    Company.addCustomer(customer1);
    Company.addCustomer(customer2);

    // Get customer IDs
    CustomerID customerID1 = customer1.getCustomerID();
    CustomerID customerID2 = customer2.getCustomerID();

    // Get customer data stored on external disk via the old system
    CustomerData myCustomerDataDisk = new CustomerDataDisk();
    String actual1 = "ID: 1, Name: John, Age: 25";
    assertEquals(myCustomerDataDisk.getCustomer_withUsbConnect(customerID1), actual1);

    // Get customer data stored on external server via the new system
    CustomerDataOverHttps myCustomerDataOverHttpsServer = new CustomerDataOverHttpsServer();
    String actual2 = "ID: 2, Name: Mary, Age: 45";
    assertEquals(myCustomerDataOverHttpsServer.getCustomer_withHttpsConnect(customerID2), actual2);

    // Get customer data stored on external server via the old system (rewiring)
    CustomerData myCustomerData = new UsbToHttpsCustomerDataAdapter(myCustomerDataOverHttpsServer);
    assertEquals(myCustomerData.getCustomer_withUsbConnect(customerID2), actual2);

  }

}
