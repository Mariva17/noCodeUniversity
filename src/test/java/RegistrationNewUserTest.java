import api.ApiBase;
import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RegistrationNewUserTest extends BaseTest {

    Faker faker = new Faker();

    public String fullName = randomString();
    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password(6, 12);
    static String endpoint = "/users/";

    static List<String> invalidUsers = new ArrayList<>();

    @AfterClass
    public static void deleteInvalidUsers() {
        ApiBase apiBase = new ApiBase();
        for (String invalidUser : invalidUsers) {
            apiBase.deleteRequest(endpoint+invalidUser, 200);
        }

    }

    @Test
    public void successRegistrationStudentTest() {
        String createdEmail = email;
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        mainStudentPage.pushButtonAvatar();
        mainStudentPage.pushButtonMyProfile();
        userProfilePage.checkFieldRole("student");
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+createdEmail, 200);
    }
    @Test
    public void successRegistrationTeacherTest() {
        String createdEmail = email;
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleTeacher();
        registrationPage.checkSelectedElement("teacher");
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        mainTeacherPage.buttonAddCourseIsVisible();
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+createdEmail, 200);
    }
    @Test
    public void emptyFieldSelectYourRole() {
        String createdEmail = email;
        homePage.goToTheRegistrationPage();
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
    }
    @Test
    public void emptyFieldFullName() {
        String createdEmail = email;
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
    }
    @Test
    public void emptyFieldEmail() {
        String createdEmail = email;
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName(fullName);
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
    }
    @Test
    public void emptyFieldPassword() {
        String createdEmail = email;
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail(createdEmail);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
    }

    @Test
    public void withoutClickOnCheckBox() {
        String createdEmail = email;
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword(password);
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
    }

    @Test
    public void emptyAllInputFields() {
        homePage.goToTheRegistrationPage();
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
    }
    @Test
    public void unsuccessfulRegistrationWithEmailWithoutAt() {
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail("dina-rgmail.com");
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
    }

    @Test
    public void unsuccessfulRegistrationWithShortPassword() {
        String createdEmail = email;
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword("112");
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
        registrationPage.checkErrorMessageOfPasswordField("Password must contain at least 6 characters");
    }
    @Test
    public void unsuccessfulRegistrationWithTooLongPassword() {
        String createdEmail = email;
        invalidUsers.add(createdEmail);
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword("11223456789122333333333321232245678941234566789");
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
        registrationPage.checkErrorMessageOfPasswordField("Password must contain maximum 20 characters");
    }

    @Test
    public void unsuccessfulRegistrationWithShortFullName() {
        String createdEmail = email;
        invalidUsers.add(createdEmail);
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName("Di");
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Full Name should contain at least 5 characters");
    }
    @Test
    public void unsuccessfulRegistrationWithInvalidFullName() {
        String createdEmail = email;
        invalidUsers.add(createdEmail);
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName("123@345");
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Full name should contain only letters of the alphabet ");
    }

    @Test
    public void checkErrorMessageByRegistrationWithInvalidFullName() {
        String createdEmail = email;
        invalidUsers.add(createdEmail);
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName("123@345");
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword(password);
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Invalid Full Name");
    }
    @Test
    public void checkErrorMessageByRegistrationWithInvalidPassword() {
        String createdEmail = email;
        invalidUsers.add(createdEmail);
        homePage.goToTheRegistrationPage();
        registrationPage.selectRoleStudent();
        registrationPage.checkSelectedElement("student");
        registrationPage.enterFullName(fullName);
        registrationPage.enterEmail(createdEmail);
        registrationPage.enterPassword("11223456789122333333333321232245678941234566789");
        registrationPage.clickOnCheckBox();
        registrationPage.pushButtonSignUp();
        registrationPage.checkErrorMessageOfRegistration("Please make sure there are no empty required fields.");
        registrationPage.checkErrorMessageOfPasswordField("Invalid password. Password must contain maximum 20 characters");
    }

}
