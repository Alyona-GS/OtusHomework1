package common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
	private WebDriverWait webDriverWait;

	public Waiters(WebDriver driver) {
		this.webDriverWait = new WebDriverWait(
				driver,
				Duration.ofSeconds(10)
		);
	}

	public boolean waitForCondition(ExpectedCondition condition) {
		try {
			webDriverWait.until(condition);
			return true;
		} catch (TimeoutException ignored) {
			return false;
		}
	}

	public boolean waitForElementPresentByLocator(By locator) {
		return this.waitForCondition(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public boolean waitForElementVisibleElement(WebElement element) {
		return this.waitForCondition(ExpectedConditions.visibilityOf(element));
	}

	public boolean waitForElementVisibleByLocator(By locator) {
		return this.waitForCondition(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
