package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage  extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Clear list")
	public WebElement clearListLink ;
	
	@FindBy(css="div.no-data")
	public WebElement noDataLbl ;
	
	@FindBy(css="table.compare-products-table")
	public WebElement compareTable ;
	
	@FindBy(tagName="tr")
	List<WebElement> allRows;
	
	@FindBy(tagName="td")
	List<WebElement> allcol;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
    public WebElement firstProductName; 
    
    @FindBy(linkText="Apple MacBook Pro 13-inch")
    public WebElement secodProductName ; 
	
	
	public void clearCompareList()
	{
		clickButton(clearListLink);
	}
	
	public void compareProducts()
	{
		System.out.println(allRows.size());
		
		for (WebElement row : allRows)
			System.out.println(row.getText() + "\t");
		for (WebElement col : allcol)
			System.out.println(col.getText() + "\t");
	}
	

}
