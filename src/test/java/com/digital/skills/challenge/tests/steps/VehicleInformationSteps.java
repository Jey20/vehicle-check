package com.digital.skills.challenge.tests.steps;

import com.digital.skills.challenge.domain.VehicleDetails;
import com.digital.skills.challenge.reader.CsvReader;
import com.digital.skills.challenge.tests.pages.InformationPage;
import com.digital.skills.challenge.tests.pages.RegistrationNumberPage;
import com.digital.skills.challenge.tests.pages.VehicleConfirmationPage;
import com.digital.skills.challenge.tests.util.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.digital.skills.challenge.tests.util.DriverManager.getDriver;

public class VehicleInformationSteps {

    private CsvReader csvReader;
    private WebDriver driver;
    List<VehicleDetails> vehicleDetailsList;


    @Before
    public void browserSetup() {
        csvReader = new CsvReader();
        DriverManager.openBrowser();
    }

    @After
    public void tearDown() {
        DriverManager.cleanUp();
    }

    @Given("^invoke csv reader and read the vehicle details$")
    public void invokeCsvReaderAndReadTheVehicleDetails() throws Throwable {
        vehicleDetailsList = csvReader.readCSVForVehicleRegistrationNumber();
        vehicleDetailsList.forEach(System.out::println);
    }


    @When("^enter vehicle registration number$")
    public void enterVehicleRegistrationNumber() throws Throwable {
        driver = getDriver();
        InformationPage informationPage = PageFactory.initElements(driver,InformationPage.class);
        informationPage.openVehicleEnquiryPage();
        informationPage.clickStartBtn();

    }


    @Then("^verify the vehicle details$")
    public void verifyTheVehicleDetails() throws Throwable {

        for (VehicleDetails vehicleDetails : vehicleDetailsList) {

            RegistrationNumberPage registrationNumberPage = PageFactory.initElements(driver, RegistrationNumberPage.class);

            registrationNumberPage.enterRegNumber(vehicleDetails.getRegistrationNumber());

            VehicleConfirmationPage vehicleConfirmationPage = PageFactory.initElements(driver, VehicleConfirmationPage.class);

            Assert.assertEquals("Vehicle Registration Number doesn't matches :",vehicleDetails.getRegistrationNumber(), vehicleConfirmationPage.getRegNumber());
            Assert.assertEquals("Vehicle Registration Make doesn't matches :",vehicleDetails.getMake(), vehicleConfirmationPage.geMakeText());
            Assert.assertEquals("Vehicle Registration Color doesn't matches :",vehicleDetails.getColour(), vehicleConfirmationPage.getColourText());

            vehicleConfirmationPage.clickBackLink();


        }
    }
}
