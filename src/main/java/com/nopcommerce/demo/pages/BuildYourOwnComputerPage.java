package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(BuildYourOwnComputerPage.class.getName());

    public BuildYourOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "product_attribute_1")
    WebElement processorDropDown;
    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement ramDropDown;
    @CacheLookup
    @FindBy(id = "product_attribute_3_6")
    WebElement hdd320GB;
    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement hdd400GB;
    @CacheLookup
    @FindBy(id = "product_attribute_4_8")
    WebElement vistaHome;
    @CacheLookup
    @FindBy(id = "product_attribute_4_8")
    WebElement vistaPremium;
    @CacheLookup
    @FindBy(id = "product_attribute_input_5")
    List<WebElement> softwareSelection;
    @CacheLookup
    @FindBy(id = "product_attribute_5_10")
    WebElement microsoftOffice;
    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='bar-notification success']/p")
    WebElement verifyProductAddedMessage;
    @CacheLookup
    @FindBy(xpath = "//span[@class = 'close']")
    WebElement crossButton;

    public void selectProcessorFromDropDown(String processor) {
        log.info("Selecting processor: " + processorDropDown.toString());
        selectByVisibleTextFromDropDown(processorDropDown, processor);
    }

    public void selectRamFromDropDown(String ram) {
        log.info("Selecting ram: " + ramDropDown.toString());
        selectByVisibleTextFromDropDown(ramDropDown, ram);
    }

    public void selectHDDRadios(String hddRadio) {
        log.info("Selecting HDD: ");
        switch (hddRadio) {
            case "320 GB":
                clickOnElement(hdd320GB);
                break;
            case "400 GB [+$100.00]":
                clickOnElement(hdd400GB);
                break;
            default:
                break;
        }
    }

    public void selectOSRadioButton(String osRadio) {
        log.info("Selecting OS: ");
        switch (osRadio) {
            case "Vista Home [+$50.00]":
                clickOnElement(vistaHome);
                break;
            case "Vista Premium [+$60.00]":
                clickOnElement(vistaPremium);
                break;
            default:
                break;
        }
    }

    public void selectSoftwareType(String software) {
        log.info("Selecting software type: " + softwareSelection.toString());
        for (WebElement softwareType : softwareSelection) {
            if (softwareType.getText().equalsIgnoreCase(software)) {
                clickOnElement(softwareType);
                break;
            }
        }
    }

    public void selectMicrosoftOffice() {
        log.info("Selecting microsoft office: " + microsoftOffice.toString());
        clickOnElement(microsoftOffice);
    }

    public void clickOnAddToCartButton() {
        log.info("Clicking on add to cart: " + addToCartButton.toString());
        clickOnElement(addToCartButton);
    }

    public String verifyProductHasBeenAddedText() {
        log.info("Verifying product has been added: " + verifyProductAddedMessage.toString());
        return getTextFromElement(verifyProductAddedMessage);
    }

    public void closeTheBar() {
        log.info("Closing the bar: " + crossButton.toString());
        clickOnElement(crossButton);
    }

    public void buildYourOwnComputer(String processor, String ram, String hdd, String os, String software) {
        log.info("Building your own computer: ");
        selectProcessorFromDropDown(processor);
        selectRamFromDropDown(ram);
        selectHDDRadios(hdd);
        selectOSRadioButton(os);
        selectMicrosoftOffice();
        selectSoftwareType(software);
    }

}


