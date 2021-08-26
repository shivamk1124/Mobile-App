package com.example.shivamkumar1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("allEvents")
    @Expose
    private List<AllEvent> allEvents = null;

    public List<AllEvent> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(List<AllEvent> allEvents) {
        this.allEvents = allEvents;
    }

    @SerializedName("eventDetails")
    @Expose
    private List<EventDetail> eventDetails = null;

    public List<EventDetail> getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(List<EventDetail> eventDetails) {
        this.eventDetails = eventDetails;
    }

    private Purchase purchase;

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

}
