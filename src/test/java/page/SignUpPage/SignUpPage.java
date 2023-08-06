package page.SignUpPage;

import page.Interfaces.Browser;

public class SignUpPage extends Browser {
    static String url = "https://www.ytwang-my-code-blog.net/login";
    public SignUpPage(){
        this.setDriver();
    }
    public void GoToSignUpPage(){
        this.GoTo(url);
    }
}
