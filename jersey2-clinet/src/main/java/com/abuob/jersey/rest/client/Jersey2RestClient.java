package com.abuob.jersey.rest.client;

import com.abuob.jersey.definition.TableDefinition;
import com.abuob.jersey.domain.CustomerInfoHolder;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by abuob on 6/13/16.
 */
public class Jersey2RestClient {

    public static void main(String[] args) {
        Jersey2RestClient jersey2Clinet = new Jersey2RestClient();
        jersey2Clinet.getCustomerInfo();
        jersey2Clinet.getCustomerInfoTableDefinition();
    }

    public CustomerInfoHolder getCustomerInfo() {


        Client client = ClientBuilder.newClient( new ClientConfig());
        WebTarget webTarget = client.target("http://localhost:9999/CustomerService/export-data");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        CustomerInfoHolder customerInfo =response.readEntity(CustomerInfoHolder.class);

        System.out.println(response.getStatus());
        System.out.println(customerInfo);

        return customerInfo;
    }

    private TableDefinition getCustomerInfoTableDefinition() {

        Client client = ClientBuilder.newClient( new ClientConfig());
        WebTarget webTarget = client.target("http://localhost:9999/CustomerService/export-definition");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        TableDefinition tableDefinition = response.readEntity(TableDefinition.class);

        System.out.println(response.getStatus());
        System.out.println(tableDefinition);

        return tableDefinition;
    }

}

