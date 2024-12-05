import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CheckCodeForJUnit {
    @Test
    void checkTextOnPage() {
        // Открыть страницу
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").$(".markdown-body").shouldHave(Condition.text("Soft assertions"));
            $(byText("Soft assertions")).click();
        $(".repository-content").shouldHave(Condition.text("Using JUnit5 extend test class:"));
    }
}
