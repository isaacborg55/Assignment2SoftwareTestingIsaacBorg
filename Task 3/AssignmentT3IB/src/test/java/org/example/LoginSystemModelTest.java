package org.example;

import nz.ac.waikato.modeljunit.*;
import org.junit.Test;
import java.io.IOException;
import java.util.Random;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GraphListener;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.Tester;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import junit.framework.Assert;
import org.example.enums.LoginSystemStates;
//reference: https://universityofmalta.zoom.us/rec/play/IBkCk7OHeC1wlE5ikLK2LtcFYi3wbsB4Xm-S1EGvLQkqfc9oHyrMJ5ZcT2oyD4gHHqgJvKzvxNsuB37k.i9U4fJFl-QkZ67e_?continueMode=true
public class LoginSystemModelTest implements FsmModel{
    private LoginSystemStates modelState;
    private LoginSystem sut;
    private boolean validlogin;
    private boolean seeingalerts;
    public LoginSystemStates getState() { return modelState; }
    public void reset(final boolean b){
        modelState = LoginSystemStates.LOGGEDOUT;
        validlogin = false;
        seeingalerts = false;
        if (b) {
            sut = new LoginSystem();
        }
    }
    public boolean seeingAlertsGuard() {
        return getState().equals(LoginSystemStates.LOGGEDIN);
    }
    public @Action void seeingAlerts() {
        sut.seeAlerts();
        seeingalerts = true;
        modelState = LoginSystemStates.SEEINGALERTS;
        Assert.assertEquals("The model's valid login state doesn't match the SUT's state.", validlogin, sut.isAvalidLogin());
        Assert.assertEquals("The model's seeing alert state doesn't match the SUT's state.", seeingalerts, sut.isseeingAlerts());
    }

    public boolean validLoginGuard() {
        return getState().equals(LoginSystemStates.LOGGEDOUT);
    }
    public @Action void validLogin() {
        sut.setValidLogin();
        validlogin = true;
        modelState = LoginSystemStates.LOGGEDIN;
        Assert.assertEquals("The model's valid login state doesn't match the SUT's state.", validlogin, sut.isAvalidLogin());
    }

    public boolean invalidLoginGuard() {
        return getState().equals(LoginSystemStates.LOGGEDOUT);
    }
    public @Action void invalidLogin() {
        sut.setInvalidLogin();
        validlogin = false;
        modelState = LoginSystemStates.LOGGEDOUT;
        Assert.assertEquals("The model's valid login state doesn't match the SUT's state.", validlogin, sut.isAvalidLogin());
    }

    public boolean logOutGuard() {
        return getState().equals(LoginSystemStates.LOGGEDIN) || getState().equals(LoginSystemStates.SEEINGALERTS);
    }
    public @Action void logOut() {
        sut.loggingOut();
        validlogin = false;
        seeingalerts = false;
        modelState = LoginSystemStates.LOGGEDOUT;
        Assert.assertEquals("The model's valid login state doesn't match the SUT's state.", validlogin, sut.isAvalidLogin());
        Assert.assertEquals("The model's seeing alert state doesn't match the SUT's state.", seeingalerts, sut.isseeingAlerts());
    }

    @Test
    public void LoginSystemModelTestRunner() throws IOException {
        final Tester tester = new RandomTester(new LoginSystemModelTest());
        tester.setRandom(new Random());
        tester.buildGraph();
        tester.addListener(new StopOnFailureListener());
        tester.addListener("verbose");
        tester.addCoverageMetric(new TransitionPairCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric(new ActionCoverage());
        tester.generate(250);
        tester.printCoverage();
    }
}
