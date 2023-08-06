package page.LoginPage.Components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.LoginPage.LoginPage;

public class LoginForm extends LoginPage {
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[1]/label[1]/div/div/input")
    private WebElement Username;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[1]/label[2]/div/div/input")
    private WebElement Password;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[2]/button")
    private WebElement Submit;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[2]/div[2]/a")
    private WebElement SignUp;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/div[1]/p")
    private WebElement ErrorAlert;

    public LoginForm(){
        this.InitElements();
    }

    public void EnterUsername(String username){
        Input(Username, username);
    }
    public void EnterPassword(String password){
        Input(Password, password);
    }
    public void ClickOnSubmit(){
        Click(Submit);
    }
    public void ClickOnSignUp(){
        Click(SignUp);
    }

    public String getErrorMessage(){
        return getInnerMessage(ErrorAlert);
    }


}
