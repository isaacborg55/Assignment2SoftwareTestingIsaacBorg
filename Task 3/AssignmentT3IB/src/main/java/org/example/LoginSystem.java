package org.example;

public class LoginSystem {
    private boolean validLogin = false;
    private boolean seeingAlerts = false;
//methods to represent login system
    boolean isAvalidLogin(){
        return validLogin;
    }

    boolean isseeingAlerts(){
        return seeingAlerts;
    }

    void setValidLogin() {
        if (!validLogin){
            validLogin = true;
        }
    }

    void setInvalidLogin(){
        if (!validLogin){
            validLogin = false;
        }
    }

    void seeAlerts() {
        if (validLogin) {
            seeingAlerts = true;
        }
    }

    void loggingOut() {
        if (validLogin) {
            validLogin = false;
            seeingAlerts = false;
        }
    }
}