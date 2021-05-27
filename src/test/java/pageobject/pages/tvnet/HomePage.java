package pageobject.pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

import java.util.List;

public class HomePage {

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By HEADLINES = By.xpath(".//span[@class = 'list-article__headline']");
    private final By COMMENTS_BTN = By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']");
    private final By COMMENTS = By.xpath(".//span[@class = 'list-article__comment section-font-color']");
    private final By LOGO_IMAGE = By.xpath(".//img[@src = 'https://f.pmo.ee/logos/4133/7b1236dab95abca45083322781760e97.svg']");
    private final By MENUTOP = By.xpath(".//div[@class = 'menu-items menu-items--top']");
    private final By ITEMMENUTOP = By.xpath(".//a[@class = 'menu-item']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies () {
        LOGGER.info("Accepting cookies");
        baseFunc.click(ACCEPT_COOKIE_BTN);
    }

    public List<WebElement> currentHeadlines() {
        return baseFunc.findHeadlines(HEADLINES);
    }
}
