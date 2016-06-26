package com.abuob.jersey.domain;

import com.abuob.jersey.definition.TableDefinition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abuob on 6/9/16.
 */

@XmlRootElement
@XmlType(name="")
public class CustomerInfoHolder extends TableDefinition {

    private List<CustomerInfo> customerInfoList = new ArrayList<CustomerInfo>();

    public CustomerInfoHolder() {
        super("CUSTOMER_INFO");
    }

    @XmlElement(name="customer_info_data")
    public List<CustomerInfo> getCustomerInfoList() {
        return customerInfoList;
    }

    public void addCustomerInfo(CustomerInfo customerInfo) {
        customerInfoList.add(customerInfo);
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append("CustomerInfoHolder{" +
                "tableName='" + getTableName() + '\'' +
                ", customerInfoList{");

        for(CustomerInfo ci: customerInfoList){
            sb.append(ci.toString());
        }



        sb.append("}}");

        return sb.toString();
    }
}
