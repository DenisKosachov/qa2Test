package pageobject.pages.delfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageobject.pages.BaseFunc;

public class CommentsPage {

    private final By ANONIM_COMMENTS = By.xpath(".//li[contains(@class, 'show-anon')]");
    private final By REGISTR_COMMENTS = By.xpath(".//li[contains(@class, 'show-reg')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

 //   public CommentPage(BaseFunc baseFunc) { this.baseFunc = baseFunc; }
}
