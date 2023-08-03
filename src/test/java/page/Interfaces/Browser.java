package page.Interfaces;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    String chromePath = "src/driver/chrome/chromedriver.exe";
    String firefoxPath = "src/driver/firefox/geckodriver.exe";
    static WebDriver driver;
    static JavascriptExecutor jsExecutor;
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", firefoxPath);
        if(driver == null){
            driver = new FirefoxDriver();
            PageFactory.initElements(driver, this);
            jsExecutor = (JavascriptExecutor) driver;
        }
    }
    protected WebDriver getDriver(){
        return driver;
    }
    protected void GoTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected void Click(WebElement element){
        highlightElement(element, "green", "2px solid");
        element.click();
    }

    protected static void highlightElement(WebElement element, String color, String borderStyle) {
        String originalStyle = element.getAttribute("style");
        String newStyle = "border: " + borderStyle + "; background-color: " + color + ";";
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, newStyle);
        // Wait for a short period to make the highlight visible (you can adjust this value)
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    }
}
