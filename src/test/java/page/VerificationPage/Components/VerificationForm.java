package page.VerificationPage.Components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.VerificationPage.VerificationPage;

public class VerificationForm extends VerificationPage {

    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[3]/div[1]/label/div/div")
    private WebElement EmailVerificationCode;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[3]/div[2]/button[1]")
    private WebElement Resend;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[3]/div[2]/button[2]")
    private WebElement Submit;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[1]/p")
    private WebElement ErrorAlert;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/p[1]")
    private WebElement SuccessMessage;

    public VerificationForm(){
        this.InitElements();
    }
    public void inputEmailVerificationCode(String string){
        EmailVerificationCode.sendKeys(string);
    }
    public void clickResend(){
        Resend.click();
    }
    public void clickSubmit(){
        Submit.click();
    }
    public String getErrorMessage(){
        return getInnerMessage(ErrorAlert);
    }
    public String getSuccessMessage(){
        return getInnerMessage(SuccessMessage);
    }


}
