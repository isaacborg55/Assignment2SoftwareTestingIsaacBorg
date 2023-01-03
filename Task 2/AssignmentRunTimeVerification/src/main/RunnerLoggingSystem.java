package main;

import java.util.Random;

public class RunnerLoggingSystem {
	
	public class LoginSystem{
		private boolean validLogin = false;
		public boolean seeingAlerts = false;
		
		//constructor 
		public LoginSystem(final boolean validLogin, final boolean seeingAlerts) {
			super();
			this.validLogin = validLogin;
			this.seeingAlerts = seeingAlerts;
		}
		
		public void changeloginCondition(boolean loginCondition){
			if (loginCondition){
				this.validLogin = true;
			} else {
				this.validLogin = false;
			}
		}
		
		public void changeseeingAlertstatus(boolean seeingAlertCondition) {
			if (seeingAlertCondition){
				this.seeingAlerts = true;
			} else {
				this.seeingAlerts = false;
			}
		}
		
		public boolean getvalidloginCondition() {
			return validLogin;
		}
		
		public boolean getseeingAlertstatus() {
			return seeingAlerts;
		} 
	}
	public static void main(String[] args) {
		final RunnerLoggingSystem run = new RunnerLoggingSystem();
		final LoginSystem loginSystem = run.new LoginSystem(false, false);
		run.runner(loginSystem);
	}
	
		public void invalidLogin() {
			System.out.println("Invalid Login");
		}
		
		public void validLogin(){
			System.out.println("Login Successful");
		}
		
		public void loggingOut(){
			System.out.println("Currently Logging out");
		}
		
		public void seeAlerts(LoginSystem loginSystem){
			if (loginSystem.getvalidloginCondition()){
				seeAlerts();
			}
		}
		
		public void seeAlerts(){
			System.out.println("Seeing alerts");
		}
	public void runner(final LoginSystem loginSystem) {
		final Random random = new Random();
		while(true){
			final int rndnum = random.nextInt(3); //random selection of condition of login system
			switch(rndnum){
			case 0:
				this.invalidLogin();
				loginSystem.changeloginCondition(false);
				break;
			case 1:
				this.validLogin();
				loginSystem.changeloginCondition(true);
				int rndnumTwo = random.nextInt(2);
				
				if (rndnumTwo == 0){
					this.loggingOut();
					loginSystem.changeloginCondition(false); //log out
				} else {
					this.seeAlerts(loginSystem);
					loginSystem.changeseeingAlertstatus(true); //see alerts then log out
					
					this.loggingOut();
					loginSystem.changeloginCondition(false);
					loginSystem.changeseeingAlertstatus(false);
				}
				break;
			case 2:
				this.seeAlerts(loginSystem);
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException exception) {
				exception.printStackTrace(); //timer
			}
		}
	}
}