import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver

class BasePageTest {
    //vars
    private WebDriver ff

    @Before
    public void openBrowser(){
        ff = new FirefoxDriver()
    }

    @After
    public void closeBrowser(){
        ff.quit()
    }

    @Test
    public void clickTeamSection(){
        System.out.println("this should click the team section")
    }

    @Test
    public void ensureCorrectPhoneNumber(){
        BasePage basePage = new BasePage(ff)
        assert basePage.getPhoneNumber() == '307.200.7224'
    }

    //needs refactor, but quick smoke test
    @Test
    public void returnContactFormInputs(){
        BasePage basePage = new BasePage(ff)
        List<WebElement> contactElements = basePage.returnContactFormInputs()
//        contactElements[1].click()
//        sleep(5000)
        //click an input, then enter some data



        assert contactElements.size() == 3
    }

    @Test
    public void ensureStatCounterHasValue(){
        BasePage basePage = new BasePage(ff)
        basePage.getStatCounterValues()
    }

}
