package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * RESTful service interface for managing customers.
 * <p>
 * Provides operations to retrieve and create customer records.
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CustomerService {

    /**
     * Retrieves a list of customers.
     *
     * @return a list of customer names or identifiers in JSON format
     */
    @GET
    List<String> getCustomers();

    /**
     * Creates a new customer.
     *
     * @param customer the name or identifier of the customer to create, in JSON format
     */
    @POST
    void createCustomer(String customer);
}
