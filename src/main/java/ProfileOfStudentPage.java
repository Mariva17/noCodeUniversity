import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class ProfileOfStudentPage {

    private ElementsCollection imageOfProfile = $$(byCssSelector("[class='static-image']"));

    private SelenideElement buttonBackToDirectory = $(byAttribute("href", "/student-directory?recordId=recPsADjsBQx7TdKF"));

    public void checkImageOfProfile(int number) {
        sleep(3000);
        imageOfProfile.shouldHave(size(number));
    }

    public void pushTheButtonBackToDirectory() {
        buttonBackToDirectory.shouldBe(visible).click();
    }

}
