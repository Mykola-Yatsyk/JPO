package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.data.Currencies;

public abstract class TopPart {
	protected final String OPTION_NULL_MESSAGE = "DropdownComponent is null";
	protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
	protected final String PAGE_DO_NOT_EXIST = "Page do not exist!!!";
	protected final String TAG_ATTRIBUTE_VALUE = "value";
	protected final String TAG_ATTRIBUTE_SRC = "src";
	protected final String TAG_ATTRIBUTE_ALT = "alt";
	protected final String LIST_CURRENCIES_CSSSELECTOR = "div.btn-group.open ul.dropdown-menu li";

	protected WebDriver driver;
	private WebElement currency;
	private WebElement myAccount;
	private WebElement wishList;
	private WebElement shoppingCart;
	private WebElement logo;
	private WebElement searchTopField;
	private WebElement searchTopButton;
	private WebElement cartButton;

	private DropdownComponent dropdownComponent;
	private GuestDropdown dropdownGuest;
	private LoggedDropdown dropdownLogged;

	public TopPart(WebDriver driver) {
		this.driver = driver;
		shoppingCart = driver.findElement(By.cssSelector("a[title='Shopping Cart']"));
	}

	public WebElement getCurrency() {
		return currency;
	}

	public String getCurrencyText() {
		return getCurrency().getText();
	}

	public void clickCurrency() {
		getCurrency().click();
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public String getMyAccountText() {
		return getMyAccount().getText();
	}

	public void clickMyAccount() {
		getMyAccount().click();
	}

	public WebElement getWishList() {
		return wishList;
	}

	public String getWishListText() {
		return getWishList().getText();
	}

	public void clickWishList() {
		getWishList().click();
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public String getShoppingCartText() {
		return getShoppingCart().getText();
	}

	public void clickShoppingCart() {
		getShoppingCart().click();
	}

	public WebElement getLogo() {
		return logo;
	}

	public void clickLogo() {
		getLogo().click();
	}

	public WebElement getSearchTopField() {
		return searchTopField;
	}

	public String getSearchTopFieldText() {
		return getSearchTopField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clearSearchTopField() {
		getSearchTopField().clear();
	}

	public void clickSearchTopField() {
		getSearchTopField().click();
	}

	public void setSearchTopField(String text) {
		getSearchTopField().sendKeys(text);
	}

	public WebElement getSearchTopButton() {
		return searchTopButton;
	}

	public void clickSearchTopButton() {
		getSearchTopButton().click();
	}

	public WebElement getCartButton() {
		return cartButton;
	}

	public String getCartButtonText() {
		return getCartButton().getText();
	}

	public void clickCartButton() {
		getCartButton().click();
	}

	protected DropdownComponent getDropdownComponent() {
		if (dropdownComponent == null)
			throw new RuntimeException(OPTION_NULL_MESSAGE);
		return dropdownComponent;
	}

	private DropdownComponent createDropdownComponent(By searchLocator) {
		dropdownComponent = new DropdownComponent(driver, searchLocator);
		return getDropdownComponent();
	}

	private void clickDropdownComponentByPartialName(String optionName) {
		if (!getDropdownComponent().isExistDropdownOptionByPartialName(optionName)) {
			throw new RuntimeException(String.format(OPTION_NOT_FOUND_MESSAGE, optionName,
					getDropdownComponent().getListOptionsText().toString()));
		}
		getDropdownComponent().clickDropdownOptionByPartialName(optionName);
		dropdownComponent = null;
	}

	protected GuestDropdown getDropdownGuest() {
		if (dropdownGuest == null)
			throw new RuntimeException(OPTION_NULL_MESSAGE);
		return dropdownGuest;
	}

	private GuestDropdown createDropdownGuest() {
		dropdownGuest = new GuestDropdown(driver);
		return getDropdownGuest();
	}

	private void clickDropdownGuestRegister() {
		getDropdownGuest().clickRegister();
		dropdownGuest = null;
	}

	private void clickDropdownGuestLogin() {
		getDropdownGuest().clickLogin();
		dropdownGuest = null;
	}

	protected LoggedDropdown getDropdownLogged() {
		if (dropdownLogged == null) {
			throw new RuntimeException(OPTION_NULL_MESSAGE);
		}
		return dropdownLogged;
	}

	private LoggedDropdown createDropdownLogged() {
		dropdownLogged = new LoggedDropdown(driver);
		return getDropdownLogged();
	}

	private void clickDropdownLoggedLogout() {
		getDropdownLogged().clickLogout();
		dropdownLogged = null;
	}

	private void openCurrencyDropdownComponent() {
		clickSearchTopField();
		clickCurrency();
		createDropdownComponent(By.cssSelector(LIST_CURRENCIES_CSSSELECTOR));
	}

	protected void clickCurrencyByPartialName(Currencies optionName) {
		openCurrencyDropdownComponent();
		clickDropdownComponentByPartialName(optionName.toString());
	}

	protected void openMyAccountDropdown() {
		clickSearchTopField();
		clickMyAccount();
	}

	protected void scrollToElement(WebElement webElement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

	public HomePage gotoHomePage() {
		clickLogo();
		return new HomePage(driver);
	}

	public LoginPage gotoLoginPage() {
		openMyAccountDropdown();
		createDropdownGuest();
		clickDropdownGuestLogin();
		return new LoginPage(driver);
	}

	public RegisterPage gotoRegisterPage() {
		openMyAccountDropdown();
		createDropdownGuest();
		clickDropdownGuestRegister();
		return new RegisterPage(driver);
	}

	public AccountLogoutPage logout() {
		openMyAccountDropdown();
		createDropdownLogged();
		clickDropdownLoggedLogout();
		return new AccountLogoutPage(driver);
	}

	public ShoppingCartEmptyPage gotoShoppingCartEmptyPage() {
		clickShoppingCart();
		return new ShoppingCartEmptyPage(driver);
	}
}