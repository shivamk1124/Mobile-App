package com.example.shivamkumar1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchaseDetail {


    private String dateTime;

    private String purchaseAmount;

    private String paymentMethodType;

    private String eventId;

    private Integer id;

    public PurchaseDetail(String dateTime, String purchaseAmount, String paymentMethodType, String eventId) {
        this.dateTime = dateTime;
        this.purchaseAmount = purchaseAmount;
        this.paymentMethodType = paymentMethodType;
        this.eventId = eventId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "purchase=[dateTime=" + dateTime + ", purchaseAmount=" + purchaseAmount + ", paymentMethodType=" + paymentMethodType + ", eventId=" + eventId + "]";
    }

}