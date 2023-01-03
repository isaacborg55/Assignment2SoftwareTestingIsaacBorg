package org.example;

import nz.ac.waikato.modeljunit.*;
import org.junit.Test;
import java.io.IOException;
import java.util.Random;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.Tester;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import junit.framework.Assert;
import org.example.enums.MarketAlertUMStates;
import static org.junit.Assert.fail;
//reference: https://universityofmalta.zoom.us/rec/play/IBkCk7OHeC1wlE5ikLK2LtcFYi3wbsB4Xm-S1EGvLQkqfc9oHyrMJ5ZcT2oyD4gHHqgJvKzvxNsuB37k.i9U4fJFl-QkZ67e_?continueMode=true
public class MarketAlertUMAlertsModelTest implements FsmModel {
    private MarketAlertUMStates modelState;
    private boolean alertType;
    private boolean heading;
    private boolean description;
    private boolean url;
    private boolean imageUrl;
    private boolean postedBy;
    private boolean priceInCents;
    private int totalnoAlerts;
    private boolean sent;
    private boolean cleared;
    private MarketAlertUMAlerts sut;
    public MarketAlertUMAlerts check; //used to keep count of number of alerts.

    public MarketAlertUMStates getState() { return modelState; }

    public void reset(final boolean b){
        modelState = MarketAlertUMStates.STARTMARKETALERTUM;
        totalnoAlerts = 0;
        sent = false;
        cleared = false;
        alertType = false;
        heading = false;
        description = false;
        url = false;
        imageUrl = false;
        postedBy = false;
        priceInCents = false;
        if(b) {
            MarketAlertUMAlerts a = new MarketAlertUMAlerts();
            try {
                a.StartUpClearAlerts(); //clears at starup, resets alerts
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                EventLog el = a.getEventLogFromMarketAlertUm();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sut = new MarketAlertUMAlerts();
        }
    }
    public boolean clearAlertsGuard() {
        return getState().equals(MarketAlertUMStates.STARTMARKETALERTUM) || getState().equals(MarketAlertUMStates.SENT) || getState().equals(MarketAlertUMStates.CLEARED);
    }
    public @Action void clearAlerts() throws IOException {
        sut.clearAlerts();

        sent = false;
        cleared = true;
        totalnoAlerts = 0;

        modelState = MarketAlertUMStates.CLEARED;

        Assert.assertEquals("The model's sent state doesn't match the SUT's state.", sent, sut.issent());
        Assert.assertEquals("The model's total of alerts doesn't match the SUT's number of alerts.", totalnoAlerts, sut.gettotalnoAlerts());
        Assert.assertEquals("The model's cleared state doesn't match the SUT's state.", cleared, sut.iscleared());
    }

    public boolean executeSendGoodAlertGuard() {
        return getState().equals(MarketAlertUMStates.STARTMARKETALERTUM) || getState().equals(MarketAlertUMStates.SENT) || getState().equals(MarketAlertUMStates.CLEARED);
    }
    public @Action void executeSendGoodAlert() throws IOException {
        if(totalnoAlerts > 5) {
            check.clearAlerts();
        }  //clears alerts when >5
        reset(true);
        sut.executessendGoodAlert();

        sent = true;
        cleared = false;
        alertType = true;
        heading = true;
        description = true;
        url = true;
        imageUrl = true;
        postedBy = true;
        priceInCents = true;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            totalnoAlerts++;
        modelState = MarketAlertUMStates.SENT;


        Assert.assertEquals("The model's alert type state doesn't match the SUT's state.", alertType, sut.AlertType());
        Assert.assertEquals("The model's heading state doesn't match the SUT's state.", heading, sut.Heading());
        Assert.assertEquals("The model's description state doesn't match the SUT's state.", description, sut.Description());
        Assert.assertEquals("The model's url state doesn't match the SUT's state.", url, sut.Url());
        Assert.assertEquals("The model's image url state doesn't match the SUT's state.", imageUrl, sut.ImageUrl());
        Assert.assertEquals("The model's posted by state doesn't match the SUT's state.", postedBy, sut.PostedBy());
        Assert.assertEquals("The model's price in cents state doesn't match the SUT's state.", priceInCents, sut.PriceInCents());
        Assert.assertEquals("The model's sent state doesn't match the SUT's state.", sent, sut.issent());
        Assert.assertEquals("The model's cleared state doesn't match the SUT's state.", cleared, sut.iscleared());
    }
    public boolean executeSendBadAlertGuard() {
        return getState().equals(MarketAlertUMStates.STARTMARKETALERTUM) || getState().equals(MarketAlertUMStates.SENT) || getState().equals(MarketAlertUMStates.CLEARED);
    }
    public @Action void executeSendBadAlert() throws IOException {
        if(totalnoAlerts > 5) {
            check.clearAlerts();
        } //clears alerts when >5
        reset(true);
        sut.executesendBadAlert();
        sent = true;
        cleared = false;
        alertType = false;
        heading = false;
        description = false;
        url = false;
        imageUrl = false;
        postedBy = false;
        priceInCents = false;


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        modelState = MarketAlertUMStates.SENT;
        try {
            sut.executesendBadAlert();
            Assert.assertFalse("The model's alert type state should be false.", sut.AlertType());
            Assert.assertFalse("The model's heading state should be false.", sut.Heading());
            Assert.assertFalse("The model's description state should be false.", sut.Description());
            Assert.assertFalse("The model's url state should be false.", sut.Url());
            Assert.assertFalse("The model's image url state should be false.", sut.ImageUrl());
            Assert.assertFalse("The model's posted by state should be false.", sut.PostedBy());
            Assert.assertFalse("The model's price in cents state should be false.", sut.PriceInCents());
            Assert.assertTrue("The model's sent state should be true.", sut.issent());
            Assert.assertFalse("The model's cleared state should be false.", sut.iscleared());
        } catch (IOException e) {
            fail("");
        }
        }


    @Test
    public void MarketAlertUMAlertsModelTestRunner() throws IOException {
        final Tester tester = new RandomTester(new MarketAlertUMAlertsModelTest());
        tester.setRandom(new Random());
        tester.buildGraph();
        tester.addListener(new StopOnFailureListener());
        tester.addListener("verbose");
        tester.addCoverageMetric(new TransitionPairCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric(new ActionCoverage());
        tester.generate(200);
        tester.printCoverage();
    }
}
