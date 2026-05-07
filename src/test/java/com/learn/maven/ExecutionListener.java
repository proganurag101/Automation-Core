package com.learn.maven;

import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


public class ExecutionListener implements ITestListener { // if you go inside ITestListener it has inbuilt methods to handle events.
    @Override // this will override the inbuilt class to show testResult
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failed: "+ result.getStatus());
    }
}
