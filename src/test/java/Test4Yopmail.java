import driver.DriverInstanceManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.YopmailPage;

public class Test4Yopmail extends BaseTest{
    private YopmailPage yopmailPage;
    public Test4Yopmail() {this.yopmailPage = new YopmailPage();}

    @BeforeMethod
    public void goHome(){ DriverInstanceManager.getDriverInstance().navigate().to("http://www.yopmail.com/en/");}

    @Test
    public void it_gets_login_button_text(){
        Assert.assertEquals(yopmailPage.inbox_btn().getText().toLowerCase(),"check inbox");
    }

    @Test
    public void it_open_a_new_usermail(){
        yopmailPage.inbox_user_textbox().sendText("usertestmail");
        yopmailPage.inbox_btn().click();

        Assert.assertEquals(yopmailPage.banner_name().getText().toLowerCase(),
                "usertestmail@yopmail.com");
    }
}
