package iscteiul.ista.blackbattleship.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import iscteiul.ista.blackbattleship.pages.UserStory9;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;

@Epic("Black Battleship")
@Feature("Multiplayer and invitations")
class UserStory9Test extends SelenideTestBase {

    private final UserStory9 page = new UserStory9();

    @Test
    @Story("Generate an invitation link to play with friends")
    @DisplayName("UserStoryTest9 - Generate and copy invitation link")
    void generateAndCopyInvitationLink() {
        page.openBattleshipPage()
                .startInvitationFlow()
                .copyInvitationLink()
                .dismissCopyConfirmation();

        if (page.inviteLink().exists()) {
            page.inviteLink()
                    .shouldBe(visible)
                    .shouldHave(matchText("https://papergames.io/en/r/.+"));
        } else {
            webdriver().shouldHave(com.codeborne.selenide.WebDriverConditions.urlContaining("/en/r/"));
        }
    }
}
