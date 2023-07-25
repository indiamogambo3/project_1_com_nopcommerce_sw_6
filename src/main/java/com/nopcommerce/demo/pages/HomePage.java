package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li")
    List<WebElement> menuTop;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;
    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]")
    WebElement nopcommerceLogo;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'My account')]")
    WebElement myAccountLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logout;

    public void selectTopMenu(String topMenu) {

        log.info("Selecting option from top menu: " + menuTop.toString());
        for (WebElement allMenu : menuTop) {
            if (allMenu.getText().equalsIgnoreCase(topMenu)) {
                clickOnElement(allMenu);
                break;
            }
        }
    }

    public void clickOnLoginLink() {
        log.info("Clicking on 'Log in'' link: " + loginLink.toString());
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink() {
        log.info("Clicking on 'Register' link: " + registerLink.toString());
        clickOnElement(registerLink);
    }

    public boolean nopCommerceLogoIsDisplayed() {
        log.info("Verifying 'nopCommerce' logo is displayed: " + nopcommerceLogo.toString());
        return nopcommerceLogo.isDisplayed();
    }

    public void clickOnMyAccountLink() {
        log.info("Clicking on 'My account' link: " + myAccountLink.toString());
        clickOnElement(myAccountLink);
    }

    public String verifyLoginLinkIsDisplayed() {
        log.info("Verifying 'Log in' link is displayed: " + loginLink.toString());
        return getTextFromElement(loginLink);
    }

}
