package com.softserve.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.pages.HomePage;

public class HomeTest extends TestRunnerFirst {

    @Test
    public void checkHome() {
        HomePage homePage = loadApplication();
        presentationSleep();
        Assert.assertEquals(homePage.getSlideshow0FirstImageAttributeAltText(), HomePage.EXPECTED_IPHONE_6);
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }
}