package io.appium.java_client.ios;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class IOSElementTest extends AppIOSTest {

    @Test
    public void findByAccessibilityIdTest() {
        assertThat(driver.findElements(AppiumBy.accessibilityId("Compute Sum")).size(), not(is(0)));
    }

    // FIXME: Stabilize the test on CI
    @Disabled
    @Test
    public void setValueTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement slider = wait.until(
                driver1 -> driver1.findElement(AppiumBy.className("XCUIElementTypeSlider")));
        slider.sendKeys("0%");
        assertEquals("0%", slider.getAttribute("value"));
    }
}
