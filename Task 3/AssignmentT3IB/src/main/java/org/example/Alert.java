package org.example;

public class Alert {
    public int alertType;
    public String heading;
    public String description;
    public String url;
    public String imageURL;
    public String postedBy = "12c87e79-dede-4c7d-a47c-2b07b7a7a009";
    public int priceInCents; //properties of an alert

    public Alert(int alertType, String heading, String description, String url, String imageUrl, int priceInCents) {
        this.alertType = alertType;
        this.heading = heading;
        this.description = description;
        this.url = url;
        this.imageURL = imageUrl;
        this.priceInCents = priceInCents;
    }



    public Alert(){}
}