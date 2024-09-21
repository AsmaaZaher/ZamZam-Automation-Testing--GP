package Tests;

import Pages.HomePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class HomePageTest extends BaseTest {
    Faker fake = new Faker();
    HomePage page;
    SoftAssert soft = new SoftAssert();
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Test
    public void TC_1() throws InterruptedException {
        reportTest = report.createTest("Zamzam Test");

        page = new HomePage(driver);
        soft.assertEquals(driver.getCurrentUrl(), "https://zamzam.com/");
        reportTest.pass("You have landed on the Home page");

        // Scroll to footer and validate social media links
        WebElement footer = page.getFooter();
        Actions actions = new Actions(driver);
        actions.moveToElement(footer).perform();
        reportTest.pass("Scrolled to the footer");
        soft.assertTrue(footer.isDisplayed(), "Footer is not displayed");
        reportTest.pass("Footer is displayed");

        // Verify social media URLs contain 'zamzam'
        List<WebElement> socialMediaIcons = page.getSocialMediaIcons();
        for (WebElement icon : socialMediaIcons) {
            String href = icon.getAttribute("href");

            // Check YouTube URL separately and make it fail
            if (href.contains("youtube.com")) {
                soft.assertFalse(href.contains("zamzam"), "The YouTube URL should not contain 'zamzam': " + href);
                reportTest.fail("YouTube URL contains 'zamzam', which should fail: " + href);
            } else {
                // For other URLs, check that they contain 'zamzam'
                soft.assertTrue(href.contains("zamzam"), "The URL does not contain 'zamzam': " + href);
                reportTest.pass("Verified the URL contains 'zamzam': " + href);
            }
        }

        // Scroll back up to the search area
        WebElement searchArea = page.getSearchArea();
        actions.moveToElement(searchArea).perform();
        reportTest.pass("Scrolled back up to the search area");

        // Search for city and select dates
        WebElement searchCityInput = page.getSearchCity();
        soft.assertTrue(searchCityInput.isDisplayed(), "Search city input is not displayed.");
        reportTest.pass("Search city input is displayed.");
        soft.assertTrue(searchCityInput.isEnabled(), "Search city input is not clickable.");
        reportTest.pass("Search city input is clickable");
        page.enterCity("makkah");

        WebElement selectDates = page.getSelectDates();
        soft.assertTrue(selectDates.isDisplayed(), "Select Dates is not displayed");
        soft.assertTrue(selectDates.isEnabled(), "Select Dates is not clickable");
        reportTest.pass("Select Dates is clickable");

        // Select check-in and check-out dates
        // 1 to 10 sep Dates not available to click
        page.selectDates();
        WebElement checkIn = page.getCheckInElement();
        WebElement checkOut = page.getCheckOutElement();
        soft.assertTrue(checkIn.isDisplayed(), "Check-in element is not displayed");
        soft.assertTrue(checkOut.isDisplayed(), "Check-out element is not displayed");

        page.checkInAndCheckOut();
        reportTest.pass("Check-in and check-out dates were successfully selected.");

        WebElement roomsButton = page.getRoomsButton();
        soft.assertTrue(roomsButton.isDisplayed(), "Rooms button is not displayed");
        soft.assertTrue(roomsButton.isEnabled(), "Rooms button is not clickable");
        page.clickOnRooms();
        reportTest.pass("Click on Room's is successfully clickable");

        // Select Two Rooms
        WebElement twoRoomsOption = page.getTwoRoomsOption();
        soft.assertTrue(twoRoomsOption.isDisplayed(), "Two Rooms option is not displayed");
        soft.assertTrue(twoRoomsOption.isEnabled(), "Two Rooms option is not selectable");
        page.selectTwoRooms();
        reportTest.pass("Two Rooms is successfully selected");

        WebElement selectCountry = page.getCountry();
        soft.assertTrue(selectCountry.isEnabled(), "select country is not clickable");
        page.selectEgyptCountry();
        reportTest.pass("the Egyptian Country is successfully selected");

        //click on search Button
        WebElement searchButton = page.getSearchButton();
        soft.assertTrue(searchButton.isEnabled(), "Search Button not clickable");
        page.clickOnSearchButton();
        reportTest.pass("Search Button is successfully clickable ");
        wait.until(ExpectedConditions.visibilityOf(page.getHotelPage()));
        soft.assertEquals(driver.getCurrentUrl(), "https://zamzam.com/hotels-saudi-arabia/makkah-hotels/");
        reportTest.pass("you have landed to 'Makkah Hotels Overview' Page");

        WebElement bookNowButton = page.getBookNowButton();
        actions.moveToElement(bookNowButton).perform();
        soft.assertTrue(bookNowButton.isEnabled(), "Book Now Button is not Clickable");
        page.clickObBookNowButton();
        reportTest.pass("Book Now Button is successfully clickable");
        soft.assertEquals(driver.getCurrentUrl(), "https://zamzam.com/hotels-saudi-arabia/makkah-hotels/al-noor-hotel/");
        reportTest.pass("you have Landed to Hotel Page");


        WebElement availabilityButton = page.getCheckAvailabilityBtn();
        actions.moveToElement(availabilityButton).perform();

        soft.assertTrue(availabilityButton.isDisplayed(), "Check availability Button is not displayed");
        soft.assertTrue(availabilityButton.isEnabled(), "Check availability Button is not clickable");
        page.clickOnCheckAvailabilityBtn();
        reportTest.pass("the check Availability Button is clickable successfully ");

        soft.assertEquals(driver.getCurrentUrl(), "https://zamzam.com/hotels-saudi-arabia/makkah-hotels/al-noor-hotel/");


        String errorMessage = page.getErrorMsg();
        System.out.println("Error message on page: " + errorMessage);
        reportTest.fail("Error message on the page: " + errorMessage);


        soft.assertAll();
    }
}

