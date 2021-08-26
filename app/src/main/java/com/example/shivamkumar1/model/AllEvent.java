package com.example.shivamkumar1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllEvent {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("bookBy")
    @Expose
    private String bookBy;
    @SerializedName("ticketsSold")
    @Expose
    private int ticketsSold;
    @SerializedName("maxTickets")
    @Expose
    private int maxTickets;
    @SerializedName("friendsAttending")
    @Expose
    private int friendsAttending;
    @SerializedName("price")
    @Expose
    private float price;
    @SerializedName("isPartnered")
    @Expose
    private boolean isPartnered;
    @SerializedName("sport")
    @Expose
    private String sport;
    @SerializedName("totalPrize")
    @Expose
    private int totalPrize;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("isRecommended")
    @Expose
    private boolean isRecommended;
    @SerializedName("mainImage")
    @Expose
    private String mainImage;
    @SerializedName("id")
    @Expose
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getBookBy() {
        return bookBy;
    }

    public void setBookBy(String bookBy) {
        this.bookBy = bookBy;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public int getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(int maxTickets) {
        this.maxTickets = maxTickets;
    }

    public int getFriendsAttending() {
        return friendsAttending;
    }

    public void setFriendsAttending(int friendsAttending) {
        this.friendsAttending = friendsAttending;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIsPartnered() {
        return isPartnered;
    }

    public void setIsPartnered(boolean isPartnered) {
        this.isPartnered = isPartnered;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(int totalPrize) {
        this.totalPrize = totalPrize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isIsRecommended() {
        return isRecommended;
    }

    public void setIsRecommended(boolean isRecommended) {
        this.isRecommended = isRecommended;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}


