package pageobject.pages.delfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageobject.pages.BaseFunc;

public class ArticlePageDelfi {

    private final By TITLE = By.xpath(".//h1[contains(@class, 'text-size-md-30')]");
    private final By COMMENTS = By.xpath(".//a[contains(@class, 'text-size-md-28')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public ArticlePageDelfi(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        return baseFunc.getText(TITLE);
    }

    public int getCommentsCount() {
        LOGGER.info("Getting article comments count");
        if (baseFunc.findElements(COMMENTS).isEmpty()) {
            return 0;
        } else {
            String commentsCountToParse = baseFunc.getText(COMMENTS);
            commentsCountToParse = commentsCountToParse.substring(1, commentsCountToParse.length() - 1);
            return Integer.parseInt(commentsCountToParse);
        }
    }

    public CommentsPageDelfi openCommentsPage() {
        LOGGER.info("Opening article comments page");
        baseFunc.click(COMMENTS);
        return new CommentsPageDelfi(baseFunc);
    }
}
