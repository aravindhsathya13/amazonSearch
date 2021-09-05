package com.amazonsearch.demo;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductSearch {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Aravindh\\Demo\\amazon_search_results\\src\\main\\resources\\chromdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.amazon.in");
			WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
			searchBar.sendKeys("iPhone");
			WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
			searchIcon.click();
			Thread.sleep(3000);
			List<WebElement> resultsList = driver
					.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
			int size = resultsList.size();
			int index = 0;
			StringBuilder sb = new StringBuilder();
			while(index<size) {
				System.out.println(resultsList.get(index).getText());
				sb.append(resultsList.get(index).getText());
				sb.append("\n");
				index++;
			}
			
			@SuppressWarnings("resource")
			PrintStream out = new PrintStream(new FileOutputStream("D:\\Aravindh\\Demo\\SearchResults.txt"));
			    out.print(sb);
			driver.quit();
		} catch (

		Exception e) {
			System.out.println("Error in Program" + e);
		}

	}

}
