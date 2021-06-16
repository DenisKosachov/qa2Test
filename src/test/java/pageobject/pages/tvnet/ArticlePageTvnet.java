package pageobject.pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageobject.pages.BaseFunc;

public class ArticlePageTvnet {

    private final By COMMENTS_BTN = By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']");
    private final By ARTICLE = By.xpath(".//h1[@class = 'article-headline']");
    private final By COMMENTS_COUNT = By.xpath(".//span[@class = 'article-share__item--count']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public ArticlePageTvnet(BaseFunc baseFunc) { this.baseFunc = baseFunc; }

    public void goToComments() {
        baseFunc.click(COMMENTS_BTN);
    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        if (baseFunc.findElements(COMMENTS_COUNT).isEmpty()) {
            return baseFunc.getText(ARTICLE);
        } else {
            return baseFunc.getText(ARTICLE) + " ";
        }
    }

    public int getCommentsCount() {
        LOGGER.info("Getting article comments count");
        if (baseFunc.findElements(COMMENTS_COUNT).isEmpty()) {
            return 0;
        } else {
            String commentsCountToParse = baseFunc.getText(COMMENTS_COUNT);
            return Integer.parseInt(commentsCountToParse);
        }
    }

    public CommentsPageTvnet openCommentsPage() {
        LOGGER.info("Opening article comments page");
        baseFunc.click(COMMENTS_BTN);
        return new CommentsPageTvnet(baseFunc);
    }
}
