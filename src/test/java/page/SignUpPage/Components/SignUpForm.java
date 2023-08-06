package page.SignUpPage.Components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.SignUpPage.SignUpPage;

public class SignUpForm extends SignUpPage {
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[1]/label[1]/div/div/input")
    private WebElement FirstName;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[1]/label[2]/div/div/input")
    private WebElement LastName;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[1]/label[3]/div/div/input")
    private WebElement Email;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[1]/label[4]/div/div/input")
    private WebElement Password;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[1]/label[5]/div/div/input")
    private WebElement PasswordAgain;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div/div[2]/button")
    private WebElement Submit;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[1]/p")
    private WebElement ErrorAlert;
    public SignUpForm(){
        this.InitElements();
    }

    public void ClickOnSubmit(){
        Click(Submit);
    }
    public void EnterFirstName(String firstName){
        Input(FirstName, firstName);
    }
    public void EnterLastName(String lastName){
        Input(LastName, lastName);
    }
    public void EnterEmail(String email){
        Input(Email, email);
    }
    public void EnterPassword(String password){
        Input(Password, password);
    }
    public void EnterPasswordAgain(String passwordAgain){
        Input(PasswordAgain, passwordAgain);
    }
    public String getErrorMessage(){
        return getInnerMessage(ErrorAlert);
    }
}
