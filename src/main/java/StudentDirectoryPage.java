import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class StudentDirectoryPage {

    private SelenideElement searchField = $(byCssSelector("input[id=':r0:']"));

    private SelenideElement buttonViewProfile = $(byAttribute("href", "/student-details?recordId=recPsADjsBQx7TdKF"));

    private ElementsCollection students = $$(byXpath("//*[@class='MuiChip-label MuiChip-labelMedium css-1cjkvaf']"));

    private SelenideElement textWelcome = $(byXpath("((//*[@class='ql-editor'])/h1)[3]"));


    public void fillSearchField(String text) {
        searchField.shouldBe(visible);
        searchField.setValue(text);
    }

    public void checkStudentsList() {
        sleep(3000);
        for (SelenideElement student : students) {
            student.shouldHave(text("student"));
        }
    }

    public void pushTheButtonViewProfile() {
        buttonViewProfile.shouldBe(visible).click();
    }

    public void checkWelcomeTextOnThePage() {
        textWelcome.shouldBe(visible);
        textWelcome.shouldBe(text("student directory"));
    }

}
