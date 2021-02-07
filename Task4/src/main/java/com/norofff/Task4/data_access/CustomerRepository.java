package com.norofff.Task4.data_access;

import com.norofff.Task4.models.Customer;
import com.norofff.Task4.models.CustomerCountry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    conn.prepareStatement("Select " +
                            "CustomerId, " +
                            "FirstName, " +
                            "LastName, " +
                            "Country, " +
                            "PostalCode, " +
                            "Phone, " +
                            "Email " +
                            "FROM Customer");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(
                        new Customer(
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
            System.out.println(exception.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch(Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return customers;
    }

    // get all customers by id
    public Customer getCustomerById(int customerId) {
        Customer customer = new Customer();

        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "Select " +
                            "CustomerId, " +
                            "FirstName, " +
                            "LastName, " +
                            "Country, " +
                            "PostalCode, " +
                            "Phone, " +
                            "Email " +
                            "FROM Customer " +
                            "Where customerId = ?");
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
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
            System.out.println(exception.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return customer;
    }

    // get customers by country
    public String getCustomerByCountry(String country) {
        List<CustomerCountry> customersByCountry = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "SELECT Country, " +
                                    "COUNT(*) as perCountry  " +
                                    "FROM Customer " +
                                    "GROUP BY Country " +
                                    "ORDER BY perCountry DESC ");
            preparedStatement.setString(Integer.parseInt("1"), country);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customersByCountry.add(new CustomerCountry(
                        resultSet.getString("Country"),
                        resultSet.getInt("perCountry"))
                );
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return country;
    }

    // highest spender
    public String getHighSpender(String spender) {
        List<HighSpender> highestSpenders = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                conn.prepareStatement(
                        "SELECT " +
                                "Customer.CustomerId, " +
                                "Customer.FirstName, " +
                                "Customer.LastName, " +
                                "Customer.Country, " +
                                "Customer.PostalCode, " +
                                "Customer.Phone, " +
                                "Customer.Email, " +
                                "round(SUM(Invoice.Total), 2) " +
                                "as total from Customer " +
                                "Join Invoice on Customer.CustomerId = Invoice.CustomerId " +
                                "GROUP BY Customer.CustomerId " +
                                "ORDER BY total DESC";
                preparedStatement.setString(Integer.parseInt("1"), spender);
                ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            highestSpenders.add(new HighSpender (
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getDouble(8)
                )));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return spender;
    }

    public getCustomerFavGenre(String favorites) {
        List<FavGenre> favGenres = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "SELECT " +
                                    "Customer.CustomerId," +
                                    "Customer.FirstName," +
                                    "Customer.LastName," +
                                    "Genre.Name," +
                                    "COUNT(Track.GenreId) total " +
                                    "FROM Customer " +
                                    "JOIN Invoice on Customer.CustomerId = Invoice.CustomerId " +
                                    "JOIN InvoiceLine ON Invoice.InvoiceId = InvoiceLine.InvoiceId " +
                                    "JOIN Track ON InvoiceLine.TrackId = Track.TrackId " +
                                    "JOIN Genre ON Track.GenreId = Genre.GenreId " +
                                    "WHERE Customer.CustomerId " +
                                    "GROUP BY Genre.GenreId " +
                                    "ORDER BY total DESC ");

            preparedStatement.setString(Integer.parseInt("1"), favorites);
            ResultSet rsSet = preparedStatement.executeQuery();
            while (rsSet.next()) {
                favGenres.add(new FavGenre(
                        rsSet.getString("FirstName"),
                        rsSet.getString("LastName"),
                        rsSet.getString("Name"),
                        rsSet.getString("tatal")
                ));
            }
        }
        catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        return favorites;
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
            System.out.println(exception.getMessage());

        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return success;
    }

    public Boolean updateCustomer(Customer customer) {
        Boolean success = false;
        try{
            conn = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "UPDATE Customer SET " +
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
            preparedStatement.setString(7,customer.getCustomerId());
            success = (result != 0);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                conn.close();
            }
            catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return success;
    }


}
