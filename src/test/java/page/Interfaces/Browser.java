package page.Interfaces;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
            jsExecutor = (JavascriptExecutor) driver;
        }
    }

    public void InitElements(){
        PageFactory.initElements(driver, this);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(element)));
        highlightElement(element, "green", "2px solid");
        element.click();
    }

    protected void Input(WebElement element, String input){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.and(
//                ExpectedConditions.element(element)));
        highlightElement(element, "green", "2px solid");
        element.sendKeys(input);
    }

    protected boolean CheckForURL(String url){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this.getDriver().getCurrentUrl().equals(url);
    }

    protected boolean CheckIfPresence(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
        if(ele == null){
            return false;
        }
        return true;
    }

    protected String getInnerMessage(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
        return ele.getText();
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
