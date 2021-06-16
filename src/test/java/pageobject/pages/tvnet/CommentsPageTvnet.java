package pageobject.pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageobject.pages.BaseFunc;

public class CommentsPageTvnet {

    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'article-comments-heading__count')]");
    private final By ARTICLE = By.xpath(".//h1[@class = 'article-headline']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public CommentsPageTvnet(BaseFunc baseFunc) { this.baseFunc = baseFunc; }

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

}
