package com.abuob.jersey.rest.client;

import com.abuob.jersey.definition.TableDefinition;
import com.abuob.jersey.domain.CustomerInfoHolder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * Created by abuob on 6/9/16.
 */
public class JerseyRestClient {

    public static void main(String[] args) {
        JerseyRestClient jerseyClinet = new JerseyRestClient();
        jerseyClinet.getCustomerInfo();
        jerseyClinet.getCustomerInfoTableDefinition();
    }

    public CustomerInfoHolder getCustomerInfo() {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        String exportDataURL = "http://localhost:9999/CustomerService/export-data";
        WebResource webResource = client.resource(exportDataURL);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        CustomerInfoHolder responseEntity = response.getEntity(CustomerInfoHolder.class);

        if (response.getStatus() != 200) {
            throw new WebApplicationException();
        }

        System.out.println(response.getStatus());
        System.out.println(responseEntity.toString());
        return responseEntity;
    }

    public TableDefinition getCustomerInfoTableDefinition () {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        String exportDataURL = "http://localhost:9999/CustomerService/export-definition";
        ClientResponse response =
                client.resource(exportDataURL).accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
        TableDefinition responseEntity = response.getEntity(TableDefinition.class);

        if (response.getStatus() != 200) {
            throw new WebApplicationException();
        }

        System.out.println(response.getStatus());
        System.out.println(responseEntity.toString());
        return responseEntity;
    }


}
