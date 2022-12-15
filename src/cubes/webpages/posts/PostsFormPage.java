package cubes.webpages.posts;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostsFormPage {
	
	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add";
	@FindBy(name = "title")
	private WebElement weInputTitle;
	@FindBy(name = "description")
	private WebElement weInputDescription;
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, content']")
	private WebElement weInputContent;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement weButtonSave;
	
	@FindBy(xpath = "//*[text()='Cancel']")
	private WebElement weButtonCancel;
	
	@FindBy(id = "title-error")
	private WebElement weErrorTitle;
	
	@FindBy(id = "description-error")
	private WebElement weErrorDescription;
	
	@FindBy(id = "tag_id[]-error")
	private WebElement weErrorTag;
	
	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private WebElement weErrorContent;

	
	public PostsFormPage(WebDriver driver, WebDriverWait driverWait) {
//		super();
		this.driver = driver;
		this.driverWait = driverWait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
	}
	
	public void openPage() {
		this.driver.get(PAGE_URL);
	}
	
	public void clickOnSave() {	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", weButtonSave);
	}
	
	public void clickOnCancel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", weButtonCancel);
	}
	
	public void inputStringInTitle(String title) {
		weInputTitle.clear();
		weInputTitle.sendKeys(title);
	}
	
	public void inputStrigInDescription(String descritpion) {
		weInputDescription.clear();
		weInputDescription.sendKeys(descritpion);
	}
	
//	public void inputStrigInContent(String content) {
//		weInputContent.clear();
//		weInputContent.sendKeys(content);
//	}
	
	public void inputStrigInEmptyContent() {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys("");
		driver.switchTo().defaultContent();
	}
	
	public void inputStrigInContent() {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys("Lorem");
		driver.switchTo().defaultContent();
	}
	
		
	public String getTitleInputError() {
		return weErrorTitle.getText();
	}
	
	public String getDescriptionInputError() {
		return weErrorDescription.getText();
	}
	
	public String getTagInputError() {
		return weErrorTag.getText();
	}
	
	public String getContentInputError() {
		return weErrorContent.getText();
	}
		
	public void checkCategory() {
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
	
	public void checkTag() {
		WebElement option1 = driver.findElement(By.id("tag-checkbox-5"));
		option1.click();	
	}
	
	
}
