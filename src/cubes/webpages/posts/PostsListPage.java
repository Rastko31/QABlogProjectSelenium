package cubes.webpages.posts;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostsListPage {

	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts";
	@FindBy(name = "title")
	private WebElement weInputTitle;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement weErrorTitle;
	@FindBy(xpath = "//a[@class='btn btn-success']")
	private WebElement weAddnewCategory;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement weDialogDelete;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement weDialogCancel;
	@FindBy(css = "td:nth-of-type(5)")
	private WebElement weFoundResult;
	@FindBy(name = "user_id")
	private WebElement weAuthor;
	@FindBy(xpath = "//i[@class='fas fa-eye']")
	private WebElement weViewButton;
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement weEditButton;
	@FindBy(xpath = "//button[contains(.,'Disable')]")
	private WebElement weDialogDisable;
	@FindBy(xpath = "//button[contains(.,'Enable')]")
	private WebElement weDialogEnable;
	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement weSuccessMessage;
	@FindBy(xpath = "//button[contains(.,'Set as Important')]")
	private WebElement weDialogImportant;
	@FindBy(xpath = "//button[contains(.,'Set as Unimportant')]")
	private WebElement weDialogUnimportant;
	

	public PostsListPage(WebDriver driver, WebDriverWait driverWait) {
		super();
		this.driver = driver;
		this.driverWait = driverWait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
	}
	
	public void openPage() {
		this.driver.get(PAGE_URL);
	}
	
	public void inputStringInTitle(String title) {
		weInputTitle.clear();
		weInputTitle.sendKeys(title);
	}
	
	public String getTitleInputError() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='dataTables_empty']")));
		return weErrorTitle.getText();
	}
	
	public String getFoundResult() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td:nth-of-type(5)")));
		return weFoundResult.getText();
	}
	
	public void selectAuthor(int user_id) {
		Select authorSelect = new Select(weAuthor);
		authorSelect.selectByIndex(user_id);
//		System.out.println(authorSelect.getFirstSelectedOption().getText());
	}
	
	public void selectRandomAuthor(){
//		Select authorSelect = new Select(driver.findElement(By.name("user_id")));
//		authorSelect.selectByIndex(1);
//		List <WebElement> elementCount = authorSelect.getOptions();
//		System.out.println(elementCount.size());
		
		WebElement dropdown=driver.findElement(By.name("user_id"));
		Select authorSelect = new Select(dropdown);
		List <WebElement> weblist = authorSelect.getOptions();
		int iCnt = weblist.size();
		for(int i=0;i<1;i++){
			Random random = new Random();
			int num = random.nextInt(iCnt);
			authorSelect.selectByIndex(num);
//			System.out.println(authorSelect.getFirstSelectedOption().getText());
		}
	}
	
	public void selectRandomCategory() {
//		Select categorySelect = new Select(driver.findElement(By.name("post_category_id")));
//		categorySelect.selectByIndex(1);
		
		WebElement dropdown=driver.findElement(By.name("post_category_id"));
		Select categorySelect = new Select(dropdown);
		List <WebElement> weblist = categorySelect.getOptions();
		int iCnt = weblist.size();
		for(int i=0;i<1;i++){
			Random random = new Random();
			int num = random.nextInt(iCnt);
			categorySelect.selectByIndex(num);
//			System.out.println(categorySelect.getFirstSelectedOption().getText());
		}
	}
	
	public void selectRandomImportant() {
//		Select importantSelect = new Select(driver.findElement(By.name("important")));
//		importantSelect.selectByValue("1");
		
		WebElement dropdown=driver.findElement(By.name("important"));
		Select importantSelect = new Select(dropdown);
		List <WebElement> weblist = importantSelect.getOptions();
		int iCnt = weblist.size();
		for(int i=0;i<1;i++){
			Random random = new Random();
			int num = random.nextInt(iCnt);
			importantSelect.selectByIndex(num);
//			System.out.println(importantSelect.getFirstSelectedOption().getText());
		}
	}
	
	public void selectRandomStatus() {
//		Select statusSelect = new Select(driver.findElement(By.name("status")));
//		statusSelect.selectByValue("1");
		
		WebElement dropdown=driver.findElement(By.name("status"));
		Select statusSelect = new Select(dropdown);
		List <WebElement> weblist = statusSelect.getOptions();
		int iCnt = weblist.size();
		for(int i=0;i<1;i++){
			Random random = new Random();
			int num = random.nextInt(iCnt);
			statusSelect.selectByIndex(num);
//			System.out.println(statusSelect.getFirstSelectedOption().getText());
		}
	}
	
	public void selectRandomWithTag() {
//		Select tagSelect = new Select(driver.findElement(By.name("tag_ids")));
//		tagSelect.selectByValue("4");
		
		WebElement dropdown=driver.findElement(By.name("tag_ids"));
		Select tagSelect = new Select(dropdown);
		List <WebElement> weblist = tagSelect.getOptions();
		int iCnt = weblist.size();
		for(int i=0;i<1;i++){
			Random random = new Random();
			int num = random.nextInt(iCnt);
			tagSelect.selectByIndex(num);
//			System.out.println(tagSelect.getFirstSelectedOption().getText());
		}
	}
	
	public void clickOnAddNewCategory() {
		weAddnewCategory.click();
	}
	
	public void clickOnViewButton() {
		driverWait.until(ExpectedConditions.visibilityOf(weViewButton));
		weViewButton.click();
	}
	
	public void clickOnEditButton() {
		driverWait.until(ExpectedConditions.visibilityOf(weEditButton));
		weEditButton.click();
	}
	
	public void clickOnDisableCategory(String name) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-minus-circle']")));
		WebElement weDisableButton  = driver.findElement(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-minus-circle']"));
		weDisableButton.click();		
	}
	
	public void clickOnDialogDisable() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogDisable));
		weDialogDisable.click();
	}
	
	public void clickOnEnableCategory(String name) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-check']")));
		WebElement weEnableButton  = driver.findElement(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-check']"));
		weEnableButton.click();		
	}
	
	public void clickOnDialogEnable() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogEnable));
		weDialogEnable.click();
	}
	
	public String getSuccessMessage () {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast toast-success']")));
		return weSuccessMessage.getText();
	}
	
	public void clickOnImportantCategory(String name) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-bookmark']")));
		WebElement weImportantButton  = driver.findElement(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-bookmark']"));
		weImportantButton.click();		
	}
	
	public void clickOnDialogImportant() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogImportant));
		weDialogImportant.click();
	}
	
	public void clickOnUnimportantCategory(String name) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-times']")));
		WebElement weUnimportantButton  = driver.findElement(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-times']"));
		weUnimportantButton.click();		
	}
	
	public void clickOnDialogUnimportant() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogUnimportant));
		weDialogUnimportant.click();
	}
	
	public void clickOnDeleteCategory(String name) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-trash']")));
		WebElement weDeleteButton  = driver.findElement(By.xpath("//td[text()='"+name+"']//ancestor::tr//td[12]//i[@class='fas fa-trash']"));
		weDeleteButton.click();		
	}
	
	public void clickOnDialogDelete() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogDelete));
		weDialogDelete.click();
	}
	
	public void clickOnDialogCancel() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogCancel));
		weDialogCancel.click();
	}

}
