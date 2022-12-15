package cubes.test;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.webpages.LoginPage;
import cubes.webpages.posts.PostsListPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPostsList {
	
	private static ChromeDriver driver;
	private static LoginPage loginPage;
	private static PostsListPage postsListPage;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://Users/acimo/Documents/QA kurs/Selenium/eclipse-workspace/QABlogProjectSelenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(10000));
		
		loginPage = new LoginPage(driver);
		postsListPage = new PostsListPage(driver, driverWait);
		
		
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
		postsListPage.openPage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tc05TestSearchByIncorrectTitleInputAndEmptyOtherFields () {
		postsListPage.inputStringInTitle("Car");
		assertEquals(postsListPage.getTitleInputError(), "No matching records found");
	}

	@Test
	public void tc06TestSearchByIncorrectTitleInputAndValidAuthor () {
		postsListPage.inputStringInTitle("Car");
		postsListPage.selectRandomAuthor();
		assertEquals(postsListPage.getTitleInputError(), "No matching records found");
	}
	
	@Test
	public void tc07TestSearchByIncorrectTitleInputAndValidAuthorAndValidCategory () {
		postsListPage.inputStringInTitle("Car");
		postsListPage.selectRandomAuthor();
		postsListPage.selectRandomCategory();
		assertEquals(postsListPage.getTitleInputError(), "No matching records found");
	}
	
	@Test
	public void tc08TestSearchByIncorrectTitleInputAndValidAuthorCategoryImportant () {
		postsListPage.inputStringInTitle("Car");
		postsListPage.selectRandomAuthor();
		postsListPage.selectRandomCategory();
		postsListPage.selectRandomImportant();
		assertEquals(postsListPage.getTitleInputError(), "No matching records found");
	}
	
	@Test
	public void tc09TestSearchByIncorrectTitleInputAndValidAuthorCategoryImportantStauts () {
		postsListPage.inputStringInTitle("Car");
		postsListPage.selectRandomAuthor();
		postsListPage.selectRandomCategory();
		postsListPage.selectRandomImportant();
		postsListPage.selectRandomStatus();
		assertEquals(postsListPage.getTitleInputError(), "No matching records found");
	}
	
	@Test
	public void tc10TestSearchByIncorrectTitleInputAndValidAuthorCategoryImportantStautsWithTag () {
		postsListPage.inputStringInTitle("Car");
		postsListPage.selectRandomAuthor();
		postsListPage.selectRandomCategory();
		postsListPage.selectRandomImportant();
		postsListPage.selectRandomStatus();
		postsListPage.selectRandomWithTag();
		assertEquals(postsListPage.getTitleInputError(), "No matching records found");
	}
	
	@Test
	public void tc11TestSearchByValidTitleInputAndEmptyOtherFields () {
		postsListPage.inputStringInTitle("In odio soluta.");
		assertEquals(postsListPage.getFoundResult(), "In odio soluta.");
	}
	
	@Test
	public void tc12TestSearchByValidTitleInputAndInvalidAuthor () {
		postsListPage.inputStringInTitle("In odio soluta.");
		postsListPage.selectAuthor(1);
		assertEquals(postsListPage.getTitleInputError(), "No matching records found");
	}
	
	@Test
	public void tc13TestSearchByEmptyTitleFieldAndValidAuthor () {
		postsListPage.inputStringInTitle("");
		postsListPage.selectAuthor(1);
		assertEquals(postsListPage.getTitleInputError(), "No matching records found");
	}
	
	@Test
	public void tc14TestClickOnAddNewPostsButton () {
		postsListPage.clickOnAddNewCategory();
	}
	
	@Test
	public void tc15TestClickOnIconViewOnPost () {
		postsListPage.inputStringInTitle("Test case 1 quality assurance");
		postsListPage.clickOnViewButton();
	}
	
	@Test
	public void tc16TestClickOnIconEditOnPost () {
		postsListPage.inputStringInTitle("Test case 1 quality assurance");
		postsListPage.clickOnEditButton();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.close();
	    driver.switchTo().window(tabs2.get(1));
	}
	
	@Test
	public void tc17TestClickOnIconDisableOnPost () {
		postsListPage.inputStringInTitle("Test case 1 quality assurance");
		postsListPage.clickOnDisableCategory("Test case 1 quality assurance");
		postsListPage.clickOnDialogDisable();
		assertEquals(postsListPage.getSuccessMessage(), "Post has been disabled");
	}
	
	@Test
	public void tc18TestClickOnIconEnableOnPost () {
		postsListPage.inputStringInTitle("Test case 1 quality assurance");
		postsListPage.clickOnEnableCategory("Test case 1 quality assurance");
		postsListPage.clickOnDialogEnable();
		assertEquals(postsListPage.getSuccessMessage(), "Post has been enabled");
	}
	
	@Test
	public void tc19TestClickOnIconImportantOnPost () {
		postsListPage.inputStringInTitle("Test case 1 quality assurance");
		postsListPage.clickOnImportantCategory("Test case 1 quality assurance");
		postsListPage.clickOnDialogImportant();
		assertEquals(postsListPage.getSuccessMessage(), "Post has been set as important");
	}
	
	@Test
	public void tc20TestClickOnIconUnimportantOnPost () {
		postsListPage.inputStringInTitle("Test case 1 quality assurance");
		postsListPage.clickOnUnimportantCategory("Test case 1 quality assurance");
		postsListPage.clickOnDialogUnimportant();
		assertEquals(postsListPage.getSuccessMessage(), "Post has been set as unimportant");
	}
	
	@Test
	public void tc21TestClickOnIconDeleteOnPost () {
		postsListPage.inputStringInTitle("Test case 1 quality assurance");
		postsListPage.clickOnDeleteCategory("Test case 1 quality assurance");
		postsListPage.clickOnDialogDelete();
	}
	
}
