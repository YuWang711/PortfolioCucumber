package page.LoginPage;

import page.Interfaces.Browser;

public class LoginPage extends Browser {
    static String url = "https://www.ytwang-my-code-blog.net/login";
    public LoginPage(){
        this.setDriver();
        this.InitElements();
    }
    public boolean checkIfOnLoginPage(){
        if(this.getDriver().getCurrentUrl().equals(url)){
            return true;
        }
        return false;
    }
    public void GoToLoginPage(){
        this.GoTo(url);
    }
}
