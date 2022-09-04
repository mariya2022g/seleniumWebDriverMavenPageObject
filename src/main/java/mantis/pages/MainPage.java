package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "span.user-info")
    private WebElement userName;

    @FindBy(css = "a[href='/mantisbt/view_all_bug_page.php']")
    private WebElement viewIssuesPageButton;

    @FindBy(xpath = "//*[@id='assigned']//h4//a")
    private WebElement assignToMeBlock;

    @FindBy(xpath = "//*[@id='unassigned']//h4//a")
    private WebElement unassignedBlock;

    @FindBy(id = "timeline")
    private WebElement timeline;

    @FindBy(css = "a[href='/mantisbt/bug_report_page.php']")
    private WebElement reportIssuePageButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void goToViewIssuesPage() {
        viewIssuesPageButton.click();
    }

    public boolean isAssignedToMeBlockDisplay() {
        return assignToMeBlock.isDisplayed();
    }

    public boolean isUnassignedBlockDisplayed() {
        return unassignedBlock.isDisplayed();
    }

    public String getTitleAssignedToMeBlock() {
        return driver.findElement(By.xpath("//h4/a")).getText();
    }

    public void goToReportIssuePage() {
        reportIssuePageButton.click();
    }

}
