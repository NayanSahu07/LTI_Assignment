package runner;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Workspace2020/AmazonAssignment/src/test/resources/features/amazonPage.feature",
glue = {"stepdefination" },
monochrome = true, 
tags = "@amazonProduct",
plugin = { "usage"})

public class RunnerClass {
	
}
