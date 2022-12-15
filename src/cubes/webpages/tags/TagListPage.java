package cubes.webpages.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagListPage {

	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/tags";
	@FindBy(xpath = "//a[@class='btn btn-success']")
	private WebElement weAddNewTag;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement weDialogCancel;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement weDialogDelete;
	
	public TagListPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.driverWait = wait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
	}
	
	public void deleteTag(String tagName) {
//		WebElement weDeleteButton  = driver.findElement(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr//td[5]//button"));
//		weDeleteButton.click();
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr//td[5]//button")));
		WebElement weDeleteButton  = driver.findElement(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr//td[5]//button"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].click();", weDeleteButton);
		
		driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='btn btn-danger']"))));
		
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	}
	
	public String checkTag(String tagName) {
		try {
			WebElement webElementStrong = driver.findElement(By.xpath("//strong[text()='"+tagName+"']"));
			return webElementStrong.getText();
		} catch (Exception e) {
			return "";
		}
		
	}
	
	public boolean isTagInList(String tagName) {
		return !driver.findElements(By.xpath("//strong[text()='"+tagName+"']")).isEmpty();
	}
	
	public void openPage() {
		driver.get(PAGE_URL);
	}
	
	public void clickOnAddNewTag() {
		weAddNewTag.click();
	}
	
	public void clickOnDeleteTag(String tagName) {
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr//td[5]//button")));
		WebElement weDeleteButton  = driver.findElement(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr//td[5]//button"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].click();", weDeleteButton);
//		weDeleteButton.click();		
	}
	
	public void clickOnUpdateTag(String tagName) {
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr//td[5]//a[2]")));
		WebElement weUpdateButton  = driver.findElement(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr//td[5]//a[2]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].click();", weUpdateButton);
//		WebElement weUpdateButton  = driver.findElement(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr//td[5]//a[2]"));
//		weUpdateButton.click();		
	}

	public void clickOnDialogCancel() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogCancel));
		weDialogCancel.click();
	}
	
	public void clickOnDialogDelete() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogDelete));
		weDialogDelete.click();
	}
}
