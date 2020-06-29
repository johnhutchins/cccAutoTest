import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class BasePage {
    private final String BASE_URL = 'https://www.callawaycloud.com'
    private final String HOME_LINK = '//*[@id="nav"]/li[1]/a'
    private final String ABOUT_US_LINK = '//*[@id="nav"]/li[2]/a'
    private final String TESTIMONIALS_LINK = '//*[@id="nav"]/li[3]/a'
    private final String TESTIMONIALS_SECTION = '#testimonials'
    private final String TESTIMONIALS_NEXT
    private final String TESTIMONIALS_PREVIOUS
    private final String TESTIMONIAL_CLIENT_SECTION = '.owl-wrapper'
    private final String TEAM_LINK = '//*[@id="nav"]/li[4]/a'
    private final String CONTACT_US_LINK = '//*[@id="nav"]/li[5]/a'
    private final String CONTACT_FORM = '.contact-form'
    private final String STAT_COUNTER = '.stat-counter'
    private final String PHONE_LINK = '//*[@id="give-us-a-shout"]/div/div[1]/div/div[2]/a'


    private final String FORM_NAME_INPUT = '//*[@id="wpcf7-f49-o1"]/form/div[2]/span[2]/span/input'
    private final String FORM_EMAIL_INPUT = '//*[@id="wpcf7-f49-o1"]/form/div[3]/span[2]/span/input'
    private final String FORM_TEXTAREA_INPUT = '//*[@id="wpcf7-f49-o1"]/form/p[1]/span[2]/span/textarea'

    private WebDriver driver

    public BasePage(WebDriver driver){
        driver.get(BASE_URL)
        this.driver = driver
    }

    public String getPageHeader(){
        WebDriverWait wait = new WebDriverWait(driver, 5)
        WebElement s =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(HEADER_H1)))
        return s.getText()
    }

    public void clickOnSection(){
        driver.findElement(By.xpath(TEAM_LINK)).click()
    }

    public String getPhoneNumber(){
        WebDriverWait wait = new WebDriverWait(driver, 5)
        WebElement s =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PHONE_LINK)))
        return s.getText()
    }

    public void clickEmail(){

    }

    public void clickMap(){

    }

    public void sendEmailFromContactForm(){

    }

    public List<WebElement> returnContactFormInputs(){
        Actions act=new Actions(driver)
        act.moveToElement(driver.findElement(By.xpath(CONTACT_US_LINK))).click().perform()

        List<WebElement> inputs = driver.findElements(By.xpath("//div[@id='give-us-a-shout']//input"))

        return inputs
    }

    public String getStatCounterValues(){
        WebDriverWait wait = new WebDriverWait(driver, 5)
        WebElement s =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(STAT_COUNTER)))
        System.out.println(s)
        return s
    }

    public WebElement getWhoWeAreSection(){
        return driver.findElement(By.xpath("//div[@id='who-we-are']"))
    }

    public WebElement getTestimonialSection(){
        return driver.findElement(By.xpath("//div[@id='what-people-are-saying']"))
    }

    public List<WebElement> getSatisfactionScores(){
        return driver.findElements(By.xpath("//span[@class='stat-counter']"))
    }
}

