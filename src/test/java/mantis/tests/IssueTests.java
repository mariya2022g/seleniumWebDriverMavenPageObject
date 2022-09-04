package mantis.tests;

        import mantis.pages.*;
        import org.assertj.core.api.SoftAssertions;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;

public class IssueTests extends BaseTest {
    private MantisSite mantisSite;
    private MainPage mainPage;
    private ReportIssuePage reportIssuePage;
    private ViewIssuePage viewIssuePage;
    private DeleteIssuePage deleteIssuePage;

    @Test
    public void checkIssuesNumber() {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToViewIssuesPage();
        int actualIssuesNumber = mantisSite.getViewIssuePage().countIssues();
        Assertions.assertEquals(50, actualIssuesNumber);
    }

    @Test
    public void createDeleteIssueTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToReportIssuePage();
        mantisSite.getReportIssuePage().createNewReportIssue("Summary", "Description");
        mantisSite.getMainPage().goToViewIssuesPage();
        String actualIssueSummary = mantisSite.getViewIssuePage().getIssueSummary();
        String expectedIssueID = mantisSite.getViewIssuePage().getIssueID();

        Thread.sleep(1000);

        SoftAssertions softAssert = new SoftAssertions();

        softAssert.assertThat(actualIssueSummary).isEqualTo("Summary");

        mantisSite.deleteReportIssue();
        String actualIssueID = mantisSite.getViewIssuePage().getIssueID();

        softAssert.assertThat(actualIssueID).isNotEqualTo(expectedIssueID);

        Thread.sleep(1000);
    }

}