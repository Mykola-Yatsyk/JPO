package com.softserve.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.pages.HomePage;
import com.softserve.pages.ShoppingCartEmptyPage;

public class ShoppingCardTest extends TestRunnerFirst{

    @Test
    public void emptyShoppingCardTest(){
        SoftAssert asert = new SoftAssert();

        HomePage homePage = loadApplication();
        presentationSleep();

        ShoppingCartEmptyPage shoppingCartEmptyPage = homePage.gotoShoppingCartEmptyPage();
        String text = shoppingCartEmptyPage.getShoppingCardInfoText();
        asert.assertEquals(text, ShoppingCartEmptyPage.EXPECTED_EMPTY);
        presentationSleep();

        homePage = shoppingCartEmptyPage.gotoHomePageUsingContinue();
        asert.assertEquals(homePage.getSlideshow0FirstImageAttributeAltText(), HomePage.EXPECTED_IPHONE_6);
        presentationSleep();
        asert.assertAll();
    }
}