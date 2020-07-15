import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class BasePage {
    private final String BASE_URL = 'https://www.callawaycloud.com'
    private final String TEAM_LINK = '//*[@id="nav"]/li[4]/a'
    private final String CONTACT_US_LINK = '//*[@id="nav"]/li[5]/a'
    private final String PHONE_LINK = '//*[@id="give-us-a-shout"]/div/div[1]/div/div[2]/a'
    private final String EMAIL_LINK = '//html/body/div/div[2]/div[2]/div/div[1]/div/div[1]/a'
    private final String CONTACT_INPUTS = '//div[@id="give-us-a-shout"]//input'
    private final String WHO_WE_ARE = '//div[@id="who-we-are"]'
    private final String TESTIMONIALS = '//div[@id="what-people-are-saying"]'
    private final String SATISFACTION_SCORES = '//span[@class="stat-counter"]'
    private final String PARTNER_LOGOS = '//div[@class="company-logo-banner"]'
    private final String LOGO = '//img[@class="logo"]'

    private WebDriver driver

    public BasePage(WebDriver driver){
        driver.get(BASE_URL)
        this.driver = driver
    }

    public WebElement getCompanyLogo(){
        return driver.findElement(By.xpath(LOGO))
    }

    public void clickOnSection(){
        driver.findElement(By.xpath(TEAM_LINK)).click()
    }

    public String getPhoneNumber(){
        WebDriverWait wait = new WebDriverWait(driver, 5)
        WebElement s =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PHONE_LINK)))
        return s.getText()
    }

    public String getEmailAddress(){
        return driver.findElement(By.xpath(EMAIL_LINK)).getText().toLowerCase()
    }

    public List<WebElement> returnContactFormInputs(){
        Actions act=new Actions(driver)
        act.moveToElement(driver.findElement(By.xpath(CONTACT_US_LINK))).click().perform()

        List<WebElement> inputs = driver.findElements(By.xpath(CONTACT_INPUTS))

        return inputs
    }

    public WebElement getWhoWeAreSection(){
        return driver.findElement(By.xpath(WHO_WE_ARE))
    }

    public WebElement getTestimonialSection(){
        return driver.findElement(By.xpath(TESTIMONIALS))
    }

    public List<WebElement> getSatisfactionScores(){
        return driver.findElements(By.xpath(SATISFACTION_SCORES))
    }

    public WebElement partnersAreDisplayed(){
        return driver.findElement(By.xpath(PARTNER_LOGOS))
    }
}

