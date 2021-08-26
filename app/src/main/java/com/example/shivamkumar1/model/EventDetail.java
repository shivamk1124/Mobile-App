package com.example.shivamkumar1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventDetail {
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
    private Integer ticketsSold;
    @SerializedName("maxTickets")
    @Expose
    private Integer maxTickets;
    @SerializedName("friendsAttending")
    @Expose
    private Integer friendsAttending;
    @SerializedName("price")
    @Expose
    private Float price;
    @SerializedName("isPartnered")
    @Expose
    private Boolean isPartnered;
    @SerializedName("sport")
    @Expose
    private String sport;
    @SerializedName("totalPrize")
    @Expose
    private Integer totalPrize;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("venueInformation")
    @Expose
    private String venueInformation;
    @SerializedName("eventCreator")
    @Expose
    private String eventCreator;
    @SerializedName("teamInformation")
    @Expose
    private String teamInformation;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("mainImage")
    @Expose
    private String mainImage;
    @SerializedName("id")
    @Expose
    private Integer id;

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

    public Integer getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(Integer ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public Integer getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(Integer maxTickets) {
        this.maxTickets = maxTickets;
    }

    public Integer getFriendsAttending() {
        return friendsAttending;
    }

    public void setFriendsAttending(Integer friendsAttending) {
        this.friendsAttending = friendsAttending;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getIsPartnered() {
        return isPartnered;
    }

    public void setIsPartnered(Boolean isPartnered) {
        this.isPartnered = isPartnered;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Integer getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(Integer totalPrize) {
        this.totalPrize = totalPrize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenueInformation() {
        return venueInformation;
    }

    public void setVenueInformation(String venueInformation) {
        this.venueInformation = venueInformation;
    }

    public String getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(String eventCreator) {
        this.eventCreator = eventCreator;
    }

    public String getTeamInformation() {
        return teamInformation;
    }

    public void setTeamInformation(String teamInformation) {
        this.teamInformation = teamInformation;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}