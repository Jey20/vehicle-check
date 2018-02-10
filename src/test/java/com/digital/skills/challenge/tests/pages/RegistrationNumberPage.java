package com.digital.skills.challenge.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationNumberPage {

    private WebDriver driver;

    @FindBy(css = "#Vrm")
    private WebElement registrationNumberText;

    @FindBy(css = ".button")
    private WebElement continueBtn;

    public RegistrationNumberPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterRegNumber(String regNumber){
        registrationNumberText.sendKeys(regNumber.trim());
        continueBtn.click();
    }
}
