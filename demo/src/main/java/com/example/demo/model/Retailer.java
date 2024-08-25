package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Retailer {

    @Id
    private String retailerId;
    private String retailerName;//
    private String reatilerAddress;//
    private String retailerOwner;//
    private String retailerUsername;
    private String	retailerPass;	//
    private String  retailerMobile;	//
    private String  retailerEmail;//
    private String  retailerDescription;//
    private String  rating;
    private String  retailerLocationId;
    private String  timings;	//
    private String  noOfBarbers;//
    private String  isAvailable;//
    private String  retailImage;//

    

    public Retailer() {
    }

    
    public Retailer(String retailerId, String retailerName, String reatilerAddress, String retailerOwner,
            String retailerUsername, String retailerPass, String retailerMobile, String retailerEmail,
            String retailerDescription, String rating, String retailerLocationId, String timings, String noOfBarbers,
            String isAvailable, String retailImage) {
        this.retailerId = retailerId;
        this.retailerName = retailerName;
        this.reatilerAddress = reatilerAddress;
        this.retailerOwner = retailerOwner;
        this.retailerUsername = retailerUsername;
        this.retailerPass = retailerPass;
        this.retailerMobile = retailerMobile;
        this.retailerEmail = retailerEmail;
        this.retailerDescription = retailerDescription;
        this.rating = rating;
        this.retailerLocationId = retailerLocationId;
        this.timings = timings;
        this.noOfBarbers = noOfBarbers;
        this.isAvailable = isAvailable;
        this.retailImage = retailImage;
    }


    public String getRetailerId() {
        return retailerId;
    }
    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }
    public String getRetailerName() {
        return retailerName;
    }
    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }
    public String getReatilerAddress() {
        return reatilerAddress;
    }
    public void setReatilerAddress(String reatilerAddress) {
        this.reatilerAddress = reatilerAddress;
    }
    public String getRetailerOwner() {
        return retailerOwner;
    }
    public void setRetailerOwner(String retailerOwner) {
        this.retailerOwner = retailerOwner;
    }
    public String getRetailerUsername() {
        return retailerUsername;
    }
    public void setRetailerUsername(String retailerUsername) {
        this.retailerUsername = retailerUsername;
    }
    public String getRetailerPass() {
        return retailerPass;
    }
    public void setRetailerPass(String retailerPass) {
        this.retailerPass = retailerPass;
    }
    public String getRetailerMobile() {
        return retailerMobile;
    }
    public void setRetailerMobile(String retailerMobile) {
        this.retailerMobile = retailerMobile;
    }
    public String getRetailerEmail() {
        return retailerEmail;
    }
    public void setRetailerEmail(String retailerEmail) {
        this.retailerEmail = retailerEmail;
    }
    public String getRetailerDescription() {
        return retailerDescription;
    }
    public void setRetailerDescription(String retailerDescription) {
        this.retailerDescription = retailerDescription;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getRetailerLocationId() {
        return retailerLocationId;
    }
    public void setRetailerLocationId(String retailerLocationId) {
        this.retailerLocationId = retailerLocationId;
    }
    public String getTimings() {
        return timings;
    }
    public void setTimings(String timings) {
        this.timings = timings;
    }
    public String getNoOfBarbers() {
        return noOfBarbers;
    }
    public void setNoOfBarbers(String noOfBarbers) {
        this.noOfBarbers = noOfBarbers;
    }
    public String getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
    public String getRetailImage() {
        return retailImage;
    }
    public void setRetailImage(String retailImage) {
        this.retailImage = retailImage;
    }
    @Override
    public String toString() {
        return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", reatilerAddress="
                + reatilerAddress + ", retailerOwner=" + retailerOwner + ", retailerUsername=" + retailerUsername
                + ", retailerPass=" + retailerPass + ", retailerMobile=" + retailerMobile + ", retailerEmail="
                + retailerEmail + ", retailerDescription=" + retailerDescription + ", rating=" + rating
                + ", retailerLocationId=" + retailerLocationId + ", timings=" + timings + ", noOfBarbers=" + noOfBarbers
                + ", isAvailable=" + isAvailable + ", retailImage=" + retailImage + "]";
    }

  
    
}
