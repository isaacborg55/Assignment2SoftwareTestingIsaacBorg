package main;

public class Alert {
	protected int alertType;
    protected String heading;
    protected String description;
    protected String url;
    protected String imageUrl;
    protected String postedBy = "12c87e79-dede-4c7d-a47c-2b07b7a7a009";
    protected int priceInCents; //properties of an alert

    public Alert(int alertType, String heading, String description, String url, String imageUrl, int priceInCents) {
        this.alertType = alertType;
        this.heading = heading;
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl;
        this.priceInCents = priceInCents;
    }
    
    public Alert(){}
}