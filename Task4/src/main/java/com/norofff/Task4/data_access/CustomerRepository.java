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
                    conn.prepareStatement("Select " +
                            "CustomerId, FirstName, LastName, Country, " +
                            "PostalCode, Phone, Email " +
                            "FROM Customer " +
                            "Where customerId = ?");
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

    // get customers by country
    public String getCustomerByCountry(String country) {
        Customer customerByCountry = null;

        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "SELECT Country, COUNT(*) as perCountry  FROM Customer GROUP BY Country ORDER BY perCountry DESC ");
            preparedStatement.setString(Integer.parseInt("1"), country);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customerByCountry = new Customer(
                        resultSet.getString("country"),
                        resultSet.getString("perCountry"),
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
        return country;
    }

    public Boolean addCustomer(Customer customer) {
        Boolean success = false;
        try{
            conn = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "Insert Into customer(" +
                            "CustomerId, " +
                            "FirstName, " +
                            "LastName, " +
                            "Country, " +
                            "PostalCode, " +
                            "Phone, " +
                            "Email) " +
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
                    conn.prepareStatement("UPDATE Customer SET " +
                                    "CustomerId = ?," +
                                    "FirstName = ?," +
                                    "LastName = ?," +
                                    "Country = ?," +
                                    "PostalCode = ?," +
                                    "Phone = ?," +
                                    "Email = ?" +
                                    "WHERE CustomerId = ?");

            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getCountry());
            preparedStatement.setString(5, customer.getPostalCode());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());

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
