package org.example;

import java.io.IOException;
import java.util.Random;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request;
import com.google.gson.Gson;

public class MarketAlertUMAlerts {
    final Random randone = new Random();
    final OkHttpClient httpClient = new OkHttpClient();
    private boolean alertType = false;
    private boolean heading = false;
    private boolean description  = false;
    private boolean url = false;
    private boolean imageUrl = false;
    private boolean postedBy = false;
    private boolean priceInCents = false;
    private boolean sent = false;
    private boolean cleared = false;
    private int totalnoAlerts = 0;
    boolean issent(){
        return sent;
    }
    boolean iscleared() {
        return cleared;
    }
    int gettotalnoAlerts() {
        return totalnoAlerts;
    }
    boolean AlertType(){
        return alertType;
    }
    boolean Heading(){
        return heading;
    }
    boolean Description(){
        return description;
    }

    boolean Url() {
        return url;
    }

    boolean ImageUrl() {
        return imageUrl;
    }

    boolean PostedBy() {
        return postedBy;
    }

    boolean PriceInCents() {
        return priceInCents;
    }

    EventLog getEventLogFromMarketAlertUm() throws IOException {
        // Make an HTTP GET request to the specified UR
        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/EventsLog/12c87e79-dede-4c7d-a47c-2b07b7a7a009")
                .addHeader("Content-Type", "application/json")
                .build();  // Set the "Content-Type" header to "application/json
        // Execute the request and get the response
        try (Response response = httpClient.newCall(request).execute()) {
            // If the response is not successful, throw an IOException
            if (!response.isSuccessful()) throw new IOException("" + response);
            String jsonString = response.body().string();
            EventLog[] arr = new Gson().fromJson(jsonString, EventLog[].class);
            // Return the first element in the array (which should be an EventLog object)
            return arr[0];
        }
    }
    //reference: https://www.tutorialspoint.com/gson/gson_quick_guide.htm
    void executessendGoodAlert() throws IOException {
        int min = 0;
        int max = 5;
        int randomNumber = randone.nextInt((max - min) + 1) + min; //random number to pick which type of alert to use.
        Alert alert = new Alert();
        switch (randomNumber) {
            case 0:
                Alert car = new Alert(
                        1,
                        "Peugeot 307",
                        "Peugeot 307",
                        "https://www.maltapark.com/item/details/9542572",
                        "https://www.maltapark.com/asset/itemphotos/9542572/9542572_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=6",
                        9550
                );
                alert = car;
                break;
            case 1:
                Alert boat = new Alert(
                        2,
                        "24FT Albatross Speedboat",
                        "Albatross Speedboat equipped with 200HP (2.5L 2T) Mariner Outboard",
                        "https://www.maltapark.com/item/details/9490100",
                        "https://www.maltapark.com/asset/itemphotos/9490100/9490100_1.jpg?_ts=5",
                        1150000
                );
                alert = boat;
                break;
            case 2:
                Alert rent = new Alert(
                        3,
                        "Mosta - Penthouse two double bedrooms",
                        "Mosta - Penthouse two double bedrooms",
                        "https://www.maltapark.com/item/details/9545195",
                        "https://www.maltapark.com/asset/itemphotos/9545195/9545195_1.jpg?_ts=1",
                        85000
                );
                alert = rent;
                break;
            case 3:
                Alert forsale = new Alert(
                        4,
                        "DIRECT FROM OWNER - Penthouse MARSASCALA",
                        "DIRECT FROM OWNER PENTHOUSE + AIRSPACE",
                        "https://www.maltapark.com/item/details/9545193",
                        "https://www.maltapark.com/asset/itemphotos/9545193/9545193_1.jpg?_ts=1",
                        43500000
                );
                alert = forsale;
                break;
            case 4:
                Alert toy = new Alert(
                        5,
                        "Pokemon PVC Toy Figures 3.1/2 & tin box",
                        "Pokemon PVC Toy Figures 3.1/2 & tin box",
                        "https://www.maltapark.com/item/details/9542219",
                        "https://www.maltapark.com/asset/itemphotos/9542219/9542219_1.jpg?_ts=3",
                        2000
                );
                alert = toy;
                break;
            case 5:
                Alert Electronics = new Alert(
                        6,
                        "Apple iPhone 8 (64GB)",
                        "Apple iPhone 8 (64GB)",
                        "https://www.maltapark.com/item/details/9537443",
                        "https://www.maltapark.com/asset/itemphotos/9537443/9537443_4.jpg?_ts=4",
                        28500
                );
                alert = Electronics;
                break;
        }
        String json = new Gson().toJson(alert); //alert is uploading to website
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();
        try (Response respo = httpClient.newCall(request).execute()) {

            if (!respo.isSuccessful()) throw new IOException("" + respo);
        }
        EventLog eventLog = getEventLogFromMarketAlertUm();
        if (eventLog != null && eventLog.eventLogType == 0){
            cleared = false;
            sent = true;
            totalnoAlerts = eventLog.systemState.alerts.size();
            Alert alert1 = eventLog.systemState.alerts.get(totalnoAlerts - 1);
            alertType = alert1.alertType >= 1 && alert1.alertType <= 6;
            heading = !alert1.heading.equals("");
            description = !alert1.description.equals("");
            url = !alert1.url.equals("");
            imageUrl = !alert1.imageURL.equals("");
            postedBy = !alert1.postedBy.equals("");
            priceInCents = alert1.priceInCents > 0; //checks whether all details match requirements
        } else {
            sent = false;
            cleared = false;
            alertType = false;
            heading = false;
            description = false;
            url = false;
            imageUrl = false;
            postedBy = false;
            priceInCents = false;
        }
    }
    void executesendBadAlert() throws IOException {
        Alert alert = new Alert(
                100,
                "",
                "",
                "",
                "",
                0
        ); //wrong alert details (0 not accepted and 100 is not an alert type)
        String json = new Gson().toJson(alert); //alert is uploading to website
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();
        try (Response respo = httpClient.newCall(request).execute()) {

            if (!respo.isSuccessful()) throw new IOException("" + respo);
        }
        EventLog eventLog = getEventLogFromMarketAlertUm();
        sent = eventLog != null && eventLog.eventLogType == 0;
        cleared = false;
        alertType = false;
        heading = false;
        description = false;
        url = false;
        imageUrl = false;
        postedBy = false;
        priceInCents = false; //sets to false as the alert is a wrong type
    }
    //reference: https://www.tabnine.com/code/java/classes/okhttp3.Response
    public void StartUpClearAlerts() throws IOException {
        Request request = new Request.Builder().url("https://api.marketalertum.com/Alert?userId=12c87e79-dede-4c7d-a47c-2b07b7a7a009").delete().build();
        try (Response respo = httpClient.newCall(request).execute()) {} //clear at start up
    }
    void clearAlerts() throws IOException {
        Request request = new Request.Builder().url("https://api.marketalertum.com/Alert?userId=12c87e79-dede-4c7d-a47c-2b07b7a7a009").delete().build();
        try (Response respo = httpClient.newCall(request).execute()) {}
        EventLog eventLog = getEventLogFromMarketAlertUm();
        if (eventLog != null && eventLog.eventLogType == 1){
            cleared = true;
            sent = false;
            totalnoAlerts = eventLog.systemState.alerts.size();
        } else {
            cleared = false;
        } //change depending on the event of the website
    }



}
