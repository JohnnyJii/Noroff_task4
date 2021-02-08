package com.norofff.Task4.controllers.api;

import com.norofff.Task4.data_access.SearchRepository;
import com.norofff.Task4.models.Customer;
import com.norofff.Task4.data_access.CustomerRepository;
import com.norofff.Task4.models.HighSpender;
import com.norofff.Task4.models.SearchResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository = new CustomerRepository();
    private SearchRepository searchRepository = new SearchRepository();

    // Get all customers
    @RequestMapping(value = "/main/Customer", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> customers = customerRepository.getAllCustomers();
        return customers;
    }

    // Get customer by id
    @RequestMapping(value = "/api/main/Customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int id) {
        return customerRepository.getCustomerById(id);
}
    // get customer by name
    @RequestMapping(value = "/api/main/Customer/{name}", method = RequestMethod.GET)
    public SearchResult getTrackByName(@PathVariable String searchResult) {
        return searchRepository.getTrackByName(searchResult);
    }

    // Get customer && country
    @RequestMapping(value = "/api/main/Customer/{country}/country", method = RequestMethod.GET)
    public String getCustomerByCountry(@PathVariable String country) {
        return customerRepository.getCustomerByCountry(country);}

    // Get highest spender
    @RequestMapping(value = "/api/main/Customer/spender", method = RequestMethod.GET)
    public List<HighSpender> getHighSpender() {
        return customerRepository.getHighSpender();
    }

    // get favourite gender
    @RequestMapping(value = "/api/main/Customer/{favorites}/favorite", method = RequestMethod.GET)
    public String getCustomerFavGenre(@PathVariable String favorites) {
        return customerRepository.getCustomerFavGenre(favorites);
    }

    // Add customer
    @RequestMapping(value = "/api/main/Customer", method = RequestMethod.POST)
    public Boolean addCustomer(@RequestBody Customer customer) {
        return customerRepository.addCustomer(customer);
}
    // update customer
    @RequestMapping(value = "/api/main/Customer/{id}", method = RequestMethod.PUT)
    public Boolean updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return customerRepository.updateCustomer(customer);
    }
}

