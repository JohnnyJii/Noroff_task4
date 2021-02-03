package com.norofff.Task4.data_access;

import com.norofff.Task4.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {

    // Set up connection object
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    // get all customers
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement =
                    conn.prepareStatement("Select CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(
                        new Customer(
                            resultSet.getString("Customer"),
                            resultSet.getString("CustomerId"),
                            resultSet.getString("FirstName"),
                            resultSet.getString("LastName"),
                            resultSet.getString("Country"),
                            resultSet.getString("PostalCode"),
                            resultSet.getString("Phone"),
                            resultSet.getString("Email")
                        ));
            }
        } catch (Exception exception) {

        }
        finally {
            try {
                conn.close();
            } catch(Exception exception) {

            }
        }
        return customers;
    }

    // get all customers by id
    public Customer getCustomerById(String customerID) {
        Customer customer = null;

        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement("Select Customer,  " +
                            "CustomerId, FirstName, LastName, Country, " +
                            "PostalCode, Phone, Email " +
                            "FROM Customer " +
                            "Where Id = ?");
            preparedStatement.setString(1, customerID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString("Customer"),
                        resultSet.getString("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                );
            }
        }
        catch (Exception exception) {
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {

            }
        }
        return customer;
    }

    public Boolean addCustomer(Customer customer) {
        Boolean success = false;
        try{
            conn = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement =
                    conn.prepareStatement("Insert Into customer(CustomerId, FirstName, LastName, " +
                            "Country, PostalCode, Phone, Email) " +
                            "Values(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, customer.getCustomerId() );
            preparedStatement.setString(2, customer.getFirstName() );
            preparedStatement.setString(3, customer.getLastName() );
            preparedStatement.setString(4, customer.getCountry() );
            preparedStatement.setString(5, customer.getPostalCode() );
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.executeUpdate();
            int result = preparedStatement.executeUpdate();
            success = (result != 0);

        } catch (Exception exception) {
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception) {

            }
        }
        return success;
    }

    public Boolean updateCustomer(Customer customer) {
        Boolean success = false;
        try{
            conn = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE Customer SET customerId = ?, " +
                            "FirstName, LastName, Country, PostalCode, Phone, Email " +
                            "Where Id= ?");
            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getCountry());
            preparedStatement.setString(5, customer.getPostalCode());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(17, customer.getEmail());

            int result = preparedStatement.executeUpdate();
            success = (result != 0);
        }
        catch (Exception exception) {

        } finally {
            try {
                conn.close();
            }
            catch (Exception exception) {

            }
        }
        return success;
    }
}
