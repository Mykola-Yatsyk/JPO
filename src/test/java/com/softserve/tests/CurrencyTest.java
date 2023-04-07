package com.softserve.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.data.Currencies;
import com.softserve.pages.HomePage;

public class CurrencyTest extends TestRunnerFirst {

    @DataProvider
    public Object[][] searchCurrencies() {
        return new Object[][] {
                { Currencies.EURO },
                { Currencies.US_DOLLAR },
        };
    }

    @Test(dataProvider = "searchCurrencies")
    public void checkFirst(Currencies currency) {
        HomePage homePage = loadApplication().chooseCurrency(currency);
        presentationSleep();
        Assert.assertTrue(homePage.getCurrencyText().contains(currency.getSymbol()));
        presentationSleep(4);
    }
}