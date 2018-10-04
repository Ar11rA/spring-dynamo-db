package com.example.dynamo.documents;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Retailer {
    private String name;
    private String address;
    private String speciality;

    @DynamoDBAttribute(attributeName = "name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @DynamoDBAttribute(attributeName = "address")
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @DynamoDBAttribute(attributeName = "speciality")
    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }

}
