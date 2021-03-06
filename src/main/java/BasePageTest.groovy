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
    public void logoIsDisplayed(){
        BasePage bp = new BasePage(ff)
        WebElement w = bp.getCompanyLogo()
        assert w.isDisplayed()
    }

    @Test
    public void teamSectionIsDisplayed(){
        System.out.println("this should click the team section")
    }

    @Test
    public void ensureCorrectPhoneNumber(){
        BasePage basePage = new BasePage(ff)
        assert basePage.getPhoneNumber() == '307.200.7224'
    }

    @Test
    public void ensureEmailIsCorrect(){
        BasePage bp = new BasePage(ff)
        assert bp.getEmailAddress() == 'info@callawaycloudconsulting.com'
    }

    @Test
    public void contactFormIsDisplayed(){
        BasePage basePage = new BasePage(ff)
        List<WebElement> contactElements = basePage.returnContactFormInputs()
        assert contactElements.size() > 3
    }

    @Test
    public void whoWeAreSectionIsDisplayed(){
        BasePage basePage = new BasePage(ff)
        WebElement who = basePage.getWhoWeAreSection()
        assert who.isDisplayed()
    }

    @Test
    public void testimonialSectionIsDisplayed(){
        BasePage bp = new BasePage(ff)
        WebElement testimonial = bp.getTestimonialSection()
        assert testimonial.isDisplayed()
    }

    @Test
    public void satisfactionScoresAreDisplayed(){
        BasePage bp = new BasePage(ff)
        List<WebElement> scores = bp.getSatisfactionScores()
        assert scores.size() == 3
    }

    @Test
    public void partnersSectionIsDisplayed(){
        BasePage bp = new BasePage(ff)
        WebElement we = bp.partnersAreDisplayed()
        assert we.isDisplayed()
    }
}
