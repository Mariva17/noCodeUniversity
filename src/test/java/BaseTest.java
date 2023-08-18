import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String BASE_URL = PropertiesLoader.loadProperties("url");

    @Before
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(BASE_URL);
    }
    @After
    public void tearDown() {
        closeWebDriver();
    }

    HomePage homePage = new HomePage();

    LoginPage loginPage = new LoginPage();

    MainStudentPage mainStudentPage = new MainStudentPage();

    RegistrationPage registrationPage = new RegistrationPage();

    ForgotPasswordPage forgotPassword = new ForgotPasswordPage();

    MainTeacherPage mainTeacherPage = new MainTeacherPage();

    AddCoursePage addCoursePage = new AddCoursePage();

    ProfileOfTeacherPage profileOfTeacherPage = new ProfileOfTeacherPage();

    UserProfilePage userProfilePage = new UserProfilePage();

    ProfessorsPage professorsPage = new ProfessorsPage();

    Header header = new Header();


    public static String randomString(){
        String generatedString= RandomStringUtils.randomAlphabetic(15);
        return(generatedString);
    }



}
