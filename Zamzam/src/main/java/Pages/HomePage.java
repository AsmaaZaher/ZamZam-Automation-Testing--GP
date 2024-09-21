package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    By footerLocator = By.cssSelector("footer[class=\"main_footer\"]");
    By faceBookLocator = By.cssSelector("a[href=\"https://www.facebook.com/zamzamtrips\"]");
    By twitterLocator = By.cssSelector("a[href=\"https://twitter.com/zamzamtrips\"]");
    By linkedInLocator = By.cssSelector("a[href=\"https://www.linkedin.com/company/zamzamtrips\"]");
    By instagramLocator = By.cssSelector("a[href=\"https://www.instagram.com/zamzamtrips\"]");
    By youtubeLocator = By.cssSelector("a[href=\"https://www.youtube.com/channel/UCc5uQ4hwnLgNsXhxv8pQtYQ\"]");
    By searchAreaLocator = By.cssSelector("div[class=\"search_form form-motif\"]");
    By searchCityLocator = By.cssSelector("input[id=\"HotelCity\"]");
    By selectHotelLocator = By.xpath("//ul[@id=\"ui-id-1\"]/li[1]");
    By hotelStayDatesLocator = By.cssSelector("input[id=\"hotelStayDates\"]");
    By checkInLocator = By.xpath("//span[@aria-label='September 16, 2024' and not(contains(@class, 'flatpickr-disabled'))]");
    By checkOutLocator = By.xpath("//span[@aria-label='September 24, 2024' and not(contains(@class, 'flatpickr-disabled'))]");
    By roomsLocator = By.cssSelector("input[id=\"paxAndRoomDetail\"]");
    By noOfRoomsLocator = By.cssSelector("select[id=\"roomCount\"]");
    By selectTwoRoomsLocator = By.xpath("//select[@id=\"roomCount\"]/option[2]");
    By selectCountryLocator = By.xpath("//select[@id=\"searchNationality\"]");
    By selectEgyptLocator = By.xpath("//select[@id=\"searchNationality\"]/option[65]");
    By searchButtonLocator = By.cssSelector("button[id=\"searchBtn\"]");
    By hotelsPageLocator = By.cssSelector("section[class=\"search_sec userjourney_sec\"]");
    By bookNowLocator = By.cssSelector("button[id=\"bookBtn_1067450\"]");
    By checkAvailabilityBtnLocator = By.cssSelector("button[id=\"checkAvailabilityBtn\"]");
    By errorMsgLocator = By.xpath("//div[@class=\"row w-100 m-0\"]/div/h5");


    // Get Footer Element
    public WebElement getFooter() {
        return driver.findElement(footerLocator);
    }

    // Get Social Media Icons
    public List<WebElement> getSocialMediaIcons() {
        List<WebElement> socialMediaIcons = new ArrayList<>();
        socialMediaIcons.add(driver.findElement(faceBookLocator));
        socialMediaIcons.add(driver.findElement(twitterLocator));
        socialMediaIcons.add(driver.findElement(linkedInLocator));
        socialMediaIcons.add(driver.findElement(instagramLocator));
        socialMediaIcons.add(driver.findElement(youtubeLocator));
        return socialMediaIcons;
    }

    // Get Search Area
    public WebElement getSearchArea() {
        return driver.findElement(searchAreaLocator);
    }

    // Get Search City Input
    public WebElement getSearchCity() {
        return driver.findElement(searchCityLocator);
    }

    // Enter City Name
    public void enterCity(String city) {
        myClick(searchCityLocator);
        write(searchCityLocator, city);
        myClick(selectHotelLocator);
    }

    // Get Select Dates Input
    public WebElement getSelectDates() {
        return driver.findElement(hotelStayDatesLocator);
    }

    // Select Dates (opens the calendar)
    public void selectDates() {
        myClick(hotelStayDatesLocator);
    }

    // Get Check-In Date Element
    public WebElement getCheckInElement() {
        return driver.findElement(checkInLocator);
    }

    // Get Check-Out Date Element
    public WebElement getCheckOutElement() {
        return driver.findElement(checkOutLocator);
    }

    // Select Check-In and Check-Out Dates
    public void checkInAndCheckOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        myClick(checkInLocator);
        System.out.println("Check-in date selected.");

        myClick(checkOutLocator);
        System.out.println("Check-out date selected.");
    }

    // Click on Rooms
    public WebElement getRoomsButton() {
        return driver.findElement(roomsLocator);
    }

    public void clickOnRooms() {
        myClick(roomsLocator);
    }

    // Get Two Rooms Option
    public WebElement getTwoRoomsOption() {
        return driver.findElement(selectTwoRoomsLocator);
    }

    public void selectTwoRooms(){
        myClick(noOfRoomsLocator);
        myClick(selectTwoRoomsLocator);
    }
    // get country button
    public WebElement getCountry() {
        return driver.findElement(selectCountryLocator);
    }
        // select Egypt
    public void selectEgyptCountry(){
        myClick(selectCountryLocator);
        myClick(selectEgyptLocator);

    }
    //get search button
    public WebElement getSearchButton(){
        return driver.findElement(searchButtonLocator);
    }
    //click on search button
    public void clickOnSearchButton(){
        myClick(searchButtonLocator);
    }
    public WebElement getHotelPage(){
        return driver.findElement(hotelsPageLocator);
    }
    public WebElement getBookNowButton(){
        return driver.findElement(bookNowLocator);
    }
    public void clickObBookNowButton(){
        myClick(bookNowLocator);
    }
    public WebElement getCheckAvailabilityBtn(){
        return driver.findElement(checkAvailabilityBtnLocator);
    }
    public void clickOnCheckAvailabilityBtn(){
        myClick(checkAvailabilityBtnLocator);
    }
    public String getErrorMsg(){
        return returnText(errorMsgLocator);
    }
}
