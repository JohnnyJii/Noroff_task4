package com.norofff.Task4.controllers;

import com.norofff.Task4.models.Customer;
import com.norofff.Task4.data_access.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository = new CustomerRepository();

    // Get all customers
    @RequestMapping(value = "/main/Customer", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    // Get customer by id
    @RequestMapping(value = "/api/main/Customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepository.getCustomerById(id);
}

    // Get customer && country
    @RequestMapping(value = "/api/main/Customer/{country}", method = RequestMethod.GET)
    public String getCustomerByCountry(@PathVariable String country)
    {return customerRepository.getCustomerByCountry(country);}

    @RequestMapping(value = "/api/main/Customer", method = RequestMethod.POST)
    public Boolean addCustomer(@RequestBody Customer customer) {
        return customerRepository.addCustomer(customer);
}

    @RequestMapping(value = "/api/main/Customer", method = RequestMethod.PUT)
    public Boolean updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return customerRepository.updateCustomer(customer);
}

}

/*    @RequestParam
    @RequestHeader
    @PathVariable
    @RequestBody
*/
