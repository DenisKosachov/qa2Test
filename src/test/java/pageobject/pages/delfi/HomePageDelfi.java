package pageobject.pages.delfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

import java.util.List;

public class HomePageDelfi {

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE = By.tagName("article");
    private final By COMMENTS = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By BLOCK_BTN = By.xpath(".//button[@class = 'close']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePageDelfi(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        LOGGER.info("Accepting cookies");
        baseFunc.click(ACCEPT_COOKIE_BTN);
        List<WebElement> closeButton = baseFunc.findElements(BLOCK_BTN);
        baseFunc.click(closeButton.get(1));
    }

    public WebElement getArticleById(int id) {
        LOGGER.info("Getting article Nr. " + (id + 1));
        List<WebElement> articles = baseFunc.findElements(ARTICLE);
        Assertions.assertFalse(articles.isEmpty(), "There are no articles");
        Assertions.assertTrue(articles.size() > id, "Articles amount is ;ess then id");
        return articles.get(id);
    }

    public String getTitle(int id) {
        LOGGER.info("Getting title for article Nr. " + (id + 1));
        return baseFunc.getText(getArticleById(id), TITLE);
    }

    public int getCommentsCount(int id) {
        LOGGER.info("Getting comments count for article Nr. " + (id + 1));
        if (baseFunc.findElements(getArticleById(id), COMMENTS).isEmpty()) {
            return 0;
        } else {
            String commentsCountToParse = baseFunc.getText(getArticleById(id), COMMENTS);
            commentsCountToParse = commentsCountToParse.substring(1, commentsCountToParse.length() - 1);
            return Integer.parseInt(commentsCountToParse);
        }
    }

    public ArticlePageDelfi openArticle(int id) {
        LOGGER.info("Opening article Nr. " + (id + 1));
        baseFunc.click(getArticleById(id));
        return new ArticlePageDelfi(baseFunc);
    }
}
