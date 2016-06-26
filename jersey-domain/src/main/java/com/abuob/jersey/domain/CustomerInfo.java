package com.abuob.jersey.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by abuob on 6/9/16.
 */
@XmlRootElement
public class CustomerInfo  {


    @XmlElement(name ="id")
    private int id;

    @XmlElement(name ="first_name")
    private String firstName;

    @XmlElement(name="last_name")
    private String lastName;

    @XmlElement(name = "reward_number")
    private int rewardNumber;

    public CustomerInfo() {
    }

    public CustomerInfo(int id, String firstName, String lastName, int rewardNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rewardNumber = rewardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRewardNumber() {
        return rewardNumber;
    }

    public void setRewardNumber(int rewardNumber) {
        this.rewardNumber = rewardNumber;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rewardNumber=" + rewardNumber +
                '}';
    }
}
