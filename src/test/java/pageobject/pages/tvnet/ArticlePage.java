package pageobject.pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

public class ArticlePage {

    private final By COMMENTS_BTN = By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) { this.baseFunc = baseFunc; }

    public void goToComments() {
        baseFunc.click(COMMENTS_BTN);
    }

}
