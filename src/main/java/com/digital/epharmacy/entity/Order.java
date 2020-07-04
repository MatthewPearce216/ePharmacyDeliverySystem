package com.digital.epharmacy.entity;

import java.util.Date;

public class Order {

    //Entity attributes
    private int userID, orderNumber, totalCatalogueItems;
    private double orderTotal;
    private String paymentDate;
    private Date date;

    //Builder class constructor
    private Order(Builder builder){

        this.userID =  builder.userID;
        this.orderNumber = builder.orderNumber;
        this.totalCatalogueItems = builder.totalCatalogueItems;
        this.orderTotal = builder.orderTotal;
        this.paymentDate = builder.paymentDate;
        this.date = builder.date;
    }

    //Getters for all attributes.
    public int getUserID() {
        return userID;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getTotalCatalogueItems() {
        return totalCatalogueItems;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public Object getDate() {
        return date;
    }

    //toString method that displays whats in the order class
    @Override
    public String toString() {
        return "Order{" +
                "userID=" + userID +
                ", orderNumber=" + orderNumber +
                ", totalCatalogueItems=" + totalCatalogueItems +
                ", orderTotal=" + orderTotal +
                ", paymentDate='" + paymentDate + '\'' +
                ", date=" + date +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{

        private int userID, orderNumber, totalCatalogueItems;
        private double orderTotal;
        private String paymentDate;
        private Date date;

        // setting userID value using builder pattern
       public Builder setUserID(int userID){

           this.userID = userID;
           return this;
       }

       //setting orderNumber value using builder pattern
       public Builder setOrderNumber(int orderNumber){

           this.orderNumber = orderNumber;
           return this;
       }

       //setting totalCatalogueItems value using builder pattern
       public Builder setTotalCatalogueItems(int totalCatalogueItems){

           this.totalCatalogueItems = totalCatalogueItems;
           return this;

       }

       //setting orderTotal value using builder pattern
       public Builder setOrderTotal(double orderTotal){

           this.orderTotal = orderTotal;
           return this;
       }

       //setting paymentDate value using builder pattern
       public Builder setPaymentDate(String paymentDate){

           this.paymentDate = paymentDate;
           return this;
       }

       //setting date value using builder pattern
       public Builder setDate(Date date){

           this.date = date;
           return this;
       }

        // Builder copy method that create instance of Order
       public Builder copy(Order order){

           this.userID = order.userID;
           this.orderNumber = order.orderNumber;
           this.totalCatalogueItems = order.totalCatalogueItems;
           this.orderTotal = order.orderTotal;
           this.paymentDate = order.paymentDate;
           this.date = order.date;

           return this;
       }

        //creating an instance of this class
       public Order build(){return new Order(this);}
    }
}