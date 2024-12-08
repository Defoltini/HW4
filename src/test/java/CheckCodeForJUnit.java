import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CheckCodeForJUnit {
    @Test
    void checkTextOnPage() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").$(".markdown-body").shouldHave(Condition.text("Soft assertions"));
            $(byText("Soft assertions")).click();
            //Ввожу переменнную text с необходимым текстом для проверки
            String text = "@ExtendWith({SoftAssertsExtension.class})\n" +
                    "class Tests {\n" +
                    "  @Test\n" +
                    "  void test() {\n" +
                    "    Configuration.assertionMode = SOFT;\n" +
                    "    open(\"page.html\");\n" +
                    "\n" +
                    "    $(\"#first\").should(visible).click();\n" +
                    "    $(\"#second\").should(visible).click();\n" +
                    "  }\n" +
                    "}";
        $(".repository-content").shouldHave(Condition.text(text));

    }
}
