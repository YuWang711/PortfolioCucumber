package page.HomePage.Components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.HomePage.HomePage;

public class NavBar extends HomePage {
    @FindBy(xpath = "/html/body/div/div/nav/div/div[2]/a[text()='Login']")
    private WebElement Login;
    @FindBy(xpath = "/html/body/div/div/nav/div/div[2]/a[text()='Home']")
    private WebElement Home;
    @FindBy(xpath = "/html/body/div/div/nav/div/div[2]/a[text()='About']")
    private WebElement About;
    @FindBy(xpath = "/html/body/div/div/nav/div/div[2]/a[text()='Projects']")
    private WebElement Projects;
    @FindBy(xpath = "/html/body/div/div/nav/div/div[2]/a[text()='My Projects']")
    private WebElement MyProject;
    @FindBy(xpath = "/html/body/div/div/nav/div/div[2]/a[text()='Admin']")
    private WebElement Admin;
    @FindBy(xpath = "/html/body/div/div/nav/div/a/div")
    private WebElement SignOut;

    public NavBar(){
        this.InitElements();
    }

    public void clickOnLogin(){
        Click(Login);
    }
    public void clickOnHome(){
        Click(Home);
    }
    public void clickOnAbout(){
        Click(About);
    }
    public void clickOnProjects(){
        Click(Projects);
    }
    public void clickOnMyProject(){
        Click(MyProject);
    }
    public void clickOnAdmin(){
        Click(Admin);
    }
    public void clickOnSignOut(){
        Click(SignOut);
    }

    public boolean checkIfMyProjectIsAccessible(){
        return CheckIfPresence(MyProject);
    }

}
