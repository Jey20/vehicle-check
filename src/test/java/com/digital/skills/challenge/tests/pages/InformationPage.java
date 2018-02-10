package com.digital.skills.challenge.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage {

    @FindBy(css = ".button")
    private WebElement startBtn;

    private WebDriver driver;

    public InformationPage(WebDriver driver){
        this.driver = driver;

    }
    public void clickStartBtn(){
        startBtn.click();
    }

    public void openVehicleEnquiryPage(){
        driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
    }
}
