package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;

    @FindBy(css = "tbody > tr:first-child .column-id > a")
    private WebElement issueID;

    @FindBy(css = "tbody > tr:first-child .column-summary")
    private WebElement issueSummary;

    public ViewIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public ViewIssuePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void login(String login) {
        driver.get("https://academ-it.ru/mantisbt/view_all_bug_page.php");
    }

    public int countIssues() {
        return issues.size();
    }

    public String getIssueID() {
        return issueID.getText();
    }

    public String getIssueSummary() {
        return issueSummary.getText();
    }

    public void clickIssueID() {
        issueID.click();
    }
}