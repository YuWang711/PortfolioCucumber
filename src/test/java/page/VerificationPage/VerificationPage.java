package page.VerificationPage;

import page.Interfaces.Browser;

public class VerificationPage extends Browser {

    static String url = "https://www.ytwang-my-code-blog.net/emailVerification";
    public VerificationPage(){
        this.setDriver();
    }

    public boolean checkIfOnVerificationPage(){
        return CheckForURL(url);
    }
}
