package tests;

import adapters.QaseResponse;
import models.Project;
import models.TestCase;
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

    @Test
    public void createProjectByApiTest() {
        Project project = Project.builder().
                code("1222").
                title("TestProject 2").
                build();
        projectAdapter.createByApi(project, 200);
        QaseResponse<Project> apiResponse = projectAdapter.getByApi(1222,200);
        Assert.assertTrue(apiResponse.isStatus());
        Assert.assertEquals(project.getCode(), apiResponse.getResult().getCode());
        Assert.assertEquals(project.getTitle(), apiResponse.getResult().getTitle());
    }

    @Test
    public void deleteProjectByApiUsingCodeTest() {
        QaseResponse<Project> projectQaseResponse = projectAdapter.deleteByApi(1222, 200);
        Assert.assertTrue(projectQaseResponse.isStatus());
    }

    @Test
    public void createTestCaseByApiTest() {
        TestCase testCase = TestCase.builder().
                projectCode(1234).
                description("IQ test").
                title("IQ").
                priority(2).
                severity(3).
                build();
        testCaseAdapter.createByApi(testCase, 200);
        QaseResponse<TestCase> apiResponse = testCaseAdapter.getByApi(1234, 7, 200);
        Assert.assertTrue(apiResponse.isStatus());
        Assert.assertEquals(apiResponse.getResult().getId(), 7);
        Assert.assertEquals(testCase.getTitle(), apiResponse.getResult().getTitle());
        Assert.assertEquals(testCase.getDescription(), apiResponse.getResult().getDescription());

    }

    @Test
    public void deleteTestCaseByApiTest() {
        QaseResponse<TestCase> testCaseFromApi = testCaseAdapter.deleteByApi(1234, 7, 200);
        Assert.assertTrue(testCaseFromApi.isStatus());
    }

}
