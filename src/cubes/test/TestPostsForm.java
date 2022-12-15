package cubes.test;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.webpages.LoginPage;
import cubes.webpages.posts.PostsFormPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPostsForm {

	private static ChromeDriver driver;
//	private static FirefoxDriver driver;
	private static LoginPage loginPage;
	private static PostsFormPage postsFormPage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://Users/acimo/Documents/QA kurs/Selenium/eclipse-workspace/QABlogProjectSelenium/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "C://Users/acimo/Documents/QA kurs/Selenium/geckodriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(10000));
		
		loginPage = new LoginPage(driver);
		
		loginPage.loginSuccess();
		postsFormPage = new PostsFormPage(driver, driverWait);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
		postsFormPage.openPage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tc05TestAddPostWithEmptyFields() {
		
		postsFormPage.inputStringInTitle("");
		
		postsFormPage.inputStrigInDescription("");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getTitleInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getDescriptionInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc06TestAddPostWithCategoryAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("");
		
		postsFormPage.inputStrigInDescription("");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getTitleInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getDescriptionInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc07TestAddPostWithCategoryInvalidTitleAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Car");
		
		postsFormPage.inputStrigInDescription("");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getTitleInputError(), "Please enter at least 20 characters.");
		
		assertEquals(postsFormPage.getDescriptionInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc08TestAddPostWithCategoryInvalidTitleInvalidDescriptionAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Car");
		
		postsFormPage.inputStrigInDescription("This");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getTitleInputError(), "Please enter at least 20 characters.");
		
		assertEquals(postsFormPage.getDescriptionInputError(), "Please enter at least 50 characters.");
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc09TestAddPostWithCategoryValidTitleAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Test case 1 quality assurance");
		
		postsFormPage.inputStrigInDescription("");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getDescriptionInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}

	@Test
	public void tc10TestAddPostWithCategoryValidTitleInvalidDescriptionAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Test case 1 quality assurance");
		
		postsFormPage.inputStrigInDescription("This");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getDescriptionInputError(), "Please enter at least 50 characters.");
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc11TestAddPostWithCategoryValidDescriptionAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("");
		
		postsFormPage.inputStrigInDescription("This test case is about testing add post fields on page");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getTitleInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc12TestAddPostWithCategoryInvalidTitleValidDescriptionAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Car");
		
		postsFormPage.inputStrigInDescription("This test case is about testing add post fields on page");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getTitleInputError(), "Please enter at least 20 characters.");
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc13TestAddPostWithCategoryValidTitleValidDescriptionAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Test case 1 quality assurance");
		
		postsFormPage.inputStrigInDescription("This test case is about testing add post fields on page");
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getTagInputError(), "This field is required.");
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc14TestAddPostWithCategoryValidTitleValidDescriptionTagAndEmptyOtherFields() {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Test case 1 quality assurance");
		
		postsFormPage.inputStrigInDescription("This test case is about testing add post fields on page");
		
		postsFormPage.checkTag();
		
		postsFormPage.inputStrigInEmptyContent();
		
		postsFormPage.clickOnSave();
		
		assertEquals(postsFormPage.getContentInputError(), "The content field is required.");
	}
	
	@Test
	public void tc15TestAddPostWithCategoryValidTitleDescriptionTagAndContent () {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Test case 1 quality assurance");
		
		postsFormPage.inputStrigInDescription("This test case is about testing add post fields on page");
		
		postsFormPage.checkTag();
		
		postsFormPage.inputStrigInContent();
		
		postsFormPage.clickOnSave();
	}
	
	@Test
	public void tc16TestAddPostWithCategoryValidTitleDescriptionTagContentAndCancelForm () {
		
		postsFormPage.checkCategory();
		
		postsFormPage.inputStringInTitle("Test case 1 quality assurance");
		
		postsFormPage.inputStrigInDescription("This test case is about testing add post fields on page");
		
		postsFormPage.checkTag();
		
		postsFormPage.inputStrigInContent();
		
		postsFormPage.clickOnCancel();
	}

}
