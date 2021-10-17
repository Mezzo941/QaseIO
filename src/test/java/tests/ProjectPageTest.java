package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectsPage;

public class ProjectPageTest extends BaseTest {

    @Test
    public void testCaseCreateSuccessfully() {
        Assert.assertTrue(
                loginPage
                        .open()
                        .authorization(EMAIL, PASS)
                        .openProject("ShareLane")
                        .clickToCreateNewCase()
                        .setCaseData()
                        .saveCase()
                        .findCaseOnThePage(ProjectsPage.cases.get(0))
        );
    }

}
