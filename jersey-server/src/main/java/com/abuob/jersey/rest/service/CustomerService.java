package com.abuob.jersey.rest.service;

import com.abuob.jersey.definition.TableDefinition;
import com.abuob.jersey.domain.CustomerInfo;
import com.abuob.jersey.domain.CustomerInfoHolder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by abuob on 6/9/16.
 */

@Path("CustomerService")
public class CustomerService {

    @GET
    @Path("export-data")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerInfoHolder getCustomerInfoTableData(){

        CustomerInfoHolder customerInfoHolder = new CustomerInfoHolder();

        customerInfoHolder.addTableColumn("id","string");
        customerInfoHolder.addTableColumn("first_name","string");
        customerInfoHolder.addTableColumn("last_name","string");
        customerInfoHolder.addTableColumn("reward_number","integer");

        CustomerInfo cust1 =new CustomerInfo(1,"Steve","Jobs",123456);
        customerInfoHolder.addCustomerInfo(cust1);

        CustomerInfo cust2 =new CustomerInfo(2,"Steve","Wozniak",789123);
        customerInfoHolder.addCustomerInfo(cust2);

        CustomerInfo cust3 =new CustomerInfo(3,"Tim","Cook",555555);
        customerInfoHolder.addCustomerInfo(cust3);

        CustomerInfo cust4 =new CustomerInfo(4,"Billy","Gates",828282);
        customerInfoHolder.addCustomerInfo(cust4);

        return customerInfoHolder;
    }

    @GET
    @Path("export-definition")
    @Produces(MediaType.APPLICATION_JSON)
    public TableDefinition getTableDefinition() {

        TableDefinition tableDefinition = new TableDefinition();
        tableDefinition.setTableName("CUSTOMER_INFO");
        tableDefinition.addTableColumn("id","string");
        tableDefinition.addTableColumn("first_name","string");
        tableDefinition.addTableColumn("last_name","string");
        tableDefinition.addTableColumn("reward_number","integer");

        return tableDefinition;
    }
}


