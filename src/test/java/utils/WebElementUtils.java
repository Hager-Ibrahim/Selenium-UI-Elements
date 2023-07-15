package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;

/**
 * Utility methods for working with WebElements.
 */
public class WebElementUtils {

    // Private constructor to prevent instantiation
    private WebElementUtils() {
        throw new AssertionError("Utility class should not be instantiated.");
    }

    /**
     * Clears the text field input character by character.
     *
     * @param element The WebElement representing the text field.
     */
    public static void clearTextFieldInputCharByChar(WebElement element) {
        String fieldValue = element.getAttribute("value");
        while (!fieldValue.isEmpty()) {
            element.sendKeys(Keys.BACK_SPACE);
            fieldValue = fieldValue.substring(0, fieldValue.length() - 1);
        }
    }

    /**
     * Performs the specified action on the list of WebElements if it is not empty.
     *
     * @param elements The list of WebElements.
     * @param action   The action to be performed on the list.
     */
    public static void performIfListNotEmpty(List<WebElement> elements, Consumer<List<WebElement>> action) {
        if (!elements.isEmpty()) {
            action.accept(elements);
        }
    }

    /**
     * Sends keys character by character to the specified WebElement.
     *
     * @param element The WebElement to send keys to.
     * @param text    The text to be entered.
     */
    public static void sendKeysCharByChar( WebElement element, String text) {
        //waitForElementToBeClickable(driver,element);

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            String charAsString = Character.toString(character);
            element.sendKeys(charAsString);
        }
    }


    /**
     * Waits for the element with the specified locator to be visible.
     *
     * @param driver  The WebDriver instance.
     * @param locator The locator of the element to wait for.
     * @return The visible WebElement.
     */
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
