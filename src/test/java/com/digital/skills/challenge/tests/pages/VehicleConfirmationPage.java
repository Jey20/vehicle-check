package com.digital.skills.challenge.tests.pages;

import com.digital.skills.challenge.tests.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VehicleConfirmationPage {

    @FindBy(css = ".back-to-previous.link-back")
    private WebElement backLink;

    @FindBy(css = ".list-summary.margin-bottom-2> li:nth-child(1) > span.reg-mark")
    private WebElement regNumberLabel;


    @FindBy(css = ".list-summary.margin-bottom-2> li:nth-child(2) > span>strong")
    private WebElement makeLabel;

    @FindBy(css = ".list-summary.margin-bottom-2> li:nth-child(3) > span>strong")
    private WebElement colourLabel;

    public VehicleConfirmationPage(WebDriver driver){

        DriverManager.getWebDriverWait().until(ExpectedConditions.urlContains("ConfirmVehicle"));
    }

    public String getRegNumber(){
        return regNumberLabel.getText();
    }

    public String geMakeText(){
        return makeLabel.getText();
    }

    public String getColourText(){
        return colourLabel.getText();
    }

    public void clickBackLink(){
        backLink.click();
    }
}
