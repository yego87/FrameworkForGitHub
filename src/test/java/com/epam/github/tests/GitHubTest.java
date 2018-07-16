package com.epam.github.tests;

import com.epam.github.framework.data.UserData;
import com.epam.github.framework.utils.BaseDriver;
import com.epam.github.tests.github.page.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This test case contain different tests for GitHub fiches
 */
public class GitHubTest extends BasicTestCase {

    //need to create random data in tests
    private Faker faker = new Faker();
    private String fakeText;
    private String fakeEmail;
    private String fakeCompanyName;
    //user with good credential that takes it from properties
    private UserData user = new UserData();
    //pages
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private GistPage gistPage = new GistPage();
    private MainPage mainPage = new MainPage();
    private ProfilePage profilePage = new ProfilePage();
    private RepositoryPage repositoryPage = new RepositoryPage();
    private OrganizationPage organizationPage = new OrganizationPage();
    private CreateRepositoryPage createRepositoryPage = new CreateRepositoryPage();


    @BeforeTest(
            description = "Generate fake data and login in GitHub account",
            alwaysRun = true
    )
    public void setUp() {
        //authorization steps
        mainPage.open();
        mainPage.signIn();
        loginPage.loginAs(user);
        //generate fake data
        fakeCompanyName = faker.lorem().characters(5);
        fakeText = faker.lorem().word();
        fakeEmail = faker.internet().emailAddress();
    }

    @Test(
            description = "Test check that user can change public profile settings",
            priority = 1
    )
    public void checkUserCanChangePublicProfileSettings() {
        homePage.enterProfile();
        profilePage.editName(fakeText);

        Assert.assertTrue(profilePage.isProfileEdit(fakeText));
    }

    @Test(
            description = "Test check that user can create new repository",
            priority = 2
    )
    public void checkUserCanCreateRepository() {
        createRepositoryPage.open();
        createRepositoryPage.createRepo(fakeText);

        Assert.assertTrue(repositoryPage.isRepoCreate(fakeText));
    }

    @Test(
            description = "Test check that user can create new organization",
            priority = 3
    )
    public void checkUserCanCreateOrganization() {
        organizationPage.open();
        organizationPage.createOrganization(fakeCompanyName, fakeEmail);

        Assert.assertTrue(organizationPage.isOrganizationCreate(fakeCompanyName));
    }

    @Test(
            description = "Test check that user can create new gist",
            priority = 4
    )
    public void checkUserCanCreateGist() {
        gistPage.open();
        gistPage.createGist(fakeText, fakeText);

        Assert.assertTrue(gistPage.isGistCreate(fakeText));
    }

    @Test(
            description = "Test check that user can comment gist",
            dependsOnMethods = "checkUserCanCreateGist",
            priority = 5
    )
    public void checkUserCanCommentGist() {

        gistPage.addComment(fakeText);

        Assert.assertTrue(gistPage.isCommentAdded(fakeText));
    }

    @Test(
            description = "Test check that commit was",
            priority = 6
    )
    public void checkCommitInRepo() {
        repositoryPage.open();
        repositoryPage.openItem("src");

        Assert.assertNotNull(repositoryPage.getItemLastCommit());
    }

    @AfterClass(description = "Close browser after tests execution")
    public void shutDown(){
        BaseDriver.closeWebBrowser();
    }

}
