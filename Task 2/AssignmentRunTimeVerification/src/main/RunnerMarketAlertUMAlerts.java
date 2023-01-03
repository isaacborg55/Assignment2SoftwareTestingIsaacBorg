package main;

import java.io.IOException;
import java.util.Random;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request;
import com.google.gson.Gson;
public class RunnerMarketAlertUMAlerts {
	
	public static void main(String args[]) throws IOException {
		final RunnerMarketAlertUMAlerts r = new RunnerMarketAlertUMAlerts();
		final EventLogApi eventlogapi = r.new EventLogApi();
		r.run(eventlogapi);
	}
	
	final Random randone = new Random();
	final OkHttpClient httpClient = new OkHttpClient();	
	public void sendGoodAlert() {
		System.out.println("Sent Alert"); //msg to inform type of alert sent
	}
	public void sendBadAlert() {
		System.out.println("Sent Bad Alert");
	}
	public void clearAlerts() {
		System.out.println("Clear Alerts");
	}
	public class EventLogApi {
		private int noOfAlerts;
		private int eventLogType;	
		public EventLogApi() {}

		public void setEventLogApiAttributesFromGetRequest() throws IOException { //If the request is not successful an IOException
			Request request = new Request.Builder()
            .url("https://api.marketalertum.com/EventsLog/12c87e79-dede-4c7d-a47c-2b07b7a7a009")
            .addHeader("Content-Type", "application/json")
            .build();

		    try (Response respo = httpClient.newCall(request).execute()) {
		
		        if (!respo.isSuccessful()) throw new IOException ("" + respo);
		        String jsonString = respo.body().string();
		        EventLog[] responseArray = new Gson().fromJson(jsonString, EventLog[].class);//set values for EventLog[]
		        this.noOfAlerts = responseArray[0].systemState.alerts.size();
		        this.eventLogType = responseArray[0].eventLogType;
		    }
			
		}
	}
	//reference: https://www.tutorialspoint.com/gson/gson_quick_guide.htm
	public void executesendGoodAlert() throws IOException {
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
				System.out.println("New Car Alert");
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
				System.out.println("New Boat Alert");
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
				System.out.println("New property for rent Alert");
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
				System.out.println("New Property for sale Alert ");
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
				System.out.println("New Toy Alert");
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
				System.out.println("New Electronics Alert");
				alert = Electronics;
				break;
		}
		String json = new Gson().toJson(alert); //alert is uploading to website
        RequestBody body = RequestBody.create(json,MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response respo = httpClient.newCall(request).execute()) {

            if (!respo.isSuccessful()) throw new IOException("" + respo);
        } 
		
	}
	
	public void executeclearAlerts() throws IOException {
		Request request = new Request.Builder().url("https://api.marketalertum.com/Alert?userId=12c87e79-dede-4c7d-a47c-2b07b7a7a009").delete().build();

        try (Response respo = httpClient.newCall(request).execute()) {}
	} //deletes alerts in website
	
	public void executesendBadAlert() throws IOException {
		Alert alert = new Alert(
	            100,
	            "",
	            "",
	            "",
	            "",
	            0
		    ); //wrong alert details (0 not accepted and 100 is not an alert type)		
		String json = new Gson().toJson(alert);// Upload alert
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
	}
	
	public void run(final EventLogApi eventlogapi) throws IOException {
		final Random randtwo = new Random();		
		this.executeclearAlerts(); //clears alerts at start
		eventlogapi.setEventLogApiAttributesFromGetRequest();
		int noOfAlerts = eventlogapi.noOfAlerts;
		System.out.println("Alert total:" + noOfAlerts);
		while(true){
			final int randomNumber = randtwo.nextInt(5);		
			switch(randomNumber){
			default:
				this.executesendGoodAlert();
				eventlogapi.setEventLogApiAttributesFromGetRequest();
				//when eventlogtype is 0 (AlertCreated) and number of alerts is one more than current number of alerts
				if (eventlogapi.eventLogType == 0 && eventlogapi.noOfAlerts == (noOfAlerts + 1)){
					noOfAlerts = eventlogapi.noOfAlerts;
					this.sendGoodAlert();
				}
				break;
			case 1:
				this.executesendBadAlert();
				eventlogapi.setEventLogApiAttributesFromGetRequest();
				if (eventlogapi.eventLogType == 0 && eventlogapi.noOfAlerts == (noOfAlerts + 1)){
					noOfAlerts = eventlogapi.noOfAlerts;
					this.sendBadAlert();
				} //only for testing purposes.
				break;
			case 2:
				this.executeclearAlerts();
				eventlogapi.setEventLogApiAttributesFromGetRequest();
				if (eventlogapi.eventLogType == 1 && eventlogapi.noOfAlerts == 0){
					noOfAlerts = eventlogapi.noOfAlerts;
					this.clearAlerts();
				}
				break;
			}//since we want to test all the good alerts as well, we give slightly higher odds of selecting a good alert.
			try {
				Thread.sleep(500);
			} catch (InterruptedException exception) {
				exception.printStackTrace(); //timer
			}
		}
	}
}