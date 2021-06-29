package pageobject.pages.delfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

import java.util.List;

public class CommentsPageDelfi {

    private final By COMMENTS = By.xpath(".//span[@class = 'type-cnt']");
    private final By ARTICLE = By.xpath(".//h1[@class = 'article-title']");


    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public CommentsPageDelfi(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        return baseFunc.getText(ARTICLE);
    }

    public int getCommentsCount() {
        LOGGER.info("Getting article comments count");
        List<WebElement> commentsCount = baseFunc.findElements(COMMENTS);
        if (commentsCount.isEmpty()) {
            return 0;
        } else {
            String anonComToParse = commentsCount.get(0).getText();
            anonComToParse = anonComToParse.substring(1, anonComToParse.length() - 1);
            int anonCom = Integer.parseInt(anonComToParse);
            String regComToParse = commentsCount.get(1).getText();
            regComToParse = regComToParse.substring(1, regComToParse.length() - 1);
            int regCom = Integer.parseInt(regComToParse);
            return anonCom + regCom;
        }
    }

}
