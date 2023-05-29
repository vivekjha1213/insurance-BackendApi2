package com.vivek.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vivek.insurance.model.Customer;
import com.vivek.insurance.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllClients() {
        List<Customer> clients = customerService.getAllCustomers();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getClientById(@PathVariable String id) {
        Optional<Customer> client = customerService.getCustomerById(id);
        return client.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> createClient(@RequestBody Customer client) {
        Customer savedClient = customerService.saveCustomer(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateClient(@PathVariable String id, @RequestBody Customer client) {
        Optional<Customer> existingClient = customerService.getCustomerById(id);
        if (existingClient.isPresent()) {
            client.setId(id);
            Customer updatedClient = customerService.saveCustomer(client);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
