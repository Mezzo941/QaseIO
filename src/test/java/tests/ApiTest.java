package tests;

import adapters.QaseResponse;
import models.Project;
import models.Suite;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {

    @Test
    public void createProjectByApiTest() {
        Project project = Project.builder().
                code("1234").
                projectCode("Test Project").
                build();
        projectAdapter.createByApi(project, 200);
        QaseResponse<Project> apiResponse = projectAdapter.getByApi(1234, 200);
        Assert.assertTrue(apiResponse.isStatus());
        Assert.assertEquals(project.getCode(), apiResponse.getResult().getCode());
        Assert.assertEquals(project.getProjectCode(), apiResponse.getResult().getProjectCode());
    }

    @Test(priority = 4)
    public void createSameProjectByApiTest(){
        Project project = Project.builder().
                code("1234").
                projectCode("Test Project").
                build();
        QaseResponse<Project> projectQaseResponse = projectAdapter.createByApi(project, 422);
        Assert.assertEquals(projectQaseResponse.getErrorFields().get(0).getField(),"project");
        Assert.assertEquals(projectQaseResponse.getErrorFields().get(0).getError(),"Project with the same code already exists.");
    }

    @Test
    public void deleteNonexistentTestCase(){
        QaseResponse<TestCase> testCaseQaseResponse = testCaseAdapter.deleteByApi(1234,3,404);
        String error = testCaseQaseResponse.getErrorMessage();
        Assert.assertEquals(error,"Test case not found");
    }

    @Test(priority = 5)
    public void deleteProjectByApiUsingCodeTest() {
        QaseResponse<Project> projectQaseResponse = projectAdapter.deleteByApi(1234, 200);
        Assert.assertTrue(projectQaseResponse.isStatus());
    }

    @Test
    public void createTestCaseByApiTest() {
        TestCase testCase = TestCase.builder().
                projectCode(1234).
                description("IQ test").
                title("IQ").
                priority(1).
                severity(2).
                build();
        testCaseId = testCaseAdapter.createByApi(testCase, 200).getResult().getId();
        QaseResponse<TestCase> apiResponse = testCaseAdapter.getByApi(1234, testCaseId, 200);
        Assert.assertTrue(apiResponse.isStatus());
        Assert.assertEquals(testCase.getTitle(), apiResponse.getResult().getTitle());
        Assert.assertEquals(testCase.getDescription(), apiResponse.getResult().getDescription());

    }

    @Test
    public void deleteTestCaseByApiTest() {
        QaseResponse<TestCase> testCaseFromApi = testCaseAdapter.deleteByApi(1234, testCaseId, 200);
        Assert.assertTrue(testCaseFromApi.isStatus());
    }

    @Test
    public void createSuiteByApiTest() {
        Suite suite = Suite.builder().
                projectCode(1234).
                title("smoke").
                description("smoke tests").
                build();
        QaseResponse<Suite> suiteQaseResponse = suiteAdapter.createByApi(suite, 200);
        suiteId = suiteQaseResponse.getResult().getId();
        Assert.assertTrue(suiteQaseResponse.isStatus());
    }

    @Test
    public void deleteSuiteByApiTest() {
        QaseResponse<Suite> suiteQaseResponse = suiteAdapter.deleteByApi(1234, suiteId, 200);
        Assert.assertTrue(suiteQaseResponse.isStatus());
    }

    @Test
    public void deleteNonexistentSuiteByApiTest() {
        QaseResponse<Suite> suiteQaseResponse = suiteAdapter.deleteByApi(1234,5,404);
        String error = suiteQaseResponse.getErrorMessage();
        Assert.assertEquals(error,"Suite not found");
    }

}
