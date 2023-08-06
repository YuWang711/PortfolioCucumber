package page.HomePage;

import page.Interfaces.Browser;
public class HomePage extends Browser {

    static String url = "https://www.ytwang-my-code-blog.net/";
    public HomePage(){
        this.setDriver();
    }
    public void GoToHomePage(){
        this.GoTo(url);
    }

    public boolean checkIfOnHomePage(){
        return CheckForURL(url);
    }
}