package iscteiul.ista.blackbattleship.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import iscteiul.ista.blackbattleship.pages.UserStory10;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.webdriver;

@Epic("Black Battleship")
@Feature("Multiplayer and invitations")
class UserStory10Test extends SelenideTestBase {

    private final UserStory10 page = new UserStory10();

    @Test
    @Story("Enter a game using an invitation link")
    @DisplayName("UserStoryTest10 - Open invitation link and join game")
    void openInvitationAndJoinGame() {
        page.openInvitationLink();
        page.playButton().should(exist);

        page.joinGame();

        webdriver().shouldHave(com.codeborne.selenide.WebDriverConditions.urlContaining("/en/r/UZz0nlPw9h"));
    }
}
