package iscteiul.ista.blackbattleship.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import iscteiul.ista.blackbattleship.pages.UserStory12;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;

@Epic("Black Battleship")
@Feature("Profile and progress")
class UserStory12Test extends SelenideTestBase {

    private final UserStory12 page = new UserStory12();

    @Test
    @Story("Consult the history of played games")
    @DisplayName("UserStoryTest12 - Navigate to game history")
    void navigateToGameHistory() {
        page.openBattleshipPage();
        page.historyLink().shouldBe(visible);

        page.openHistory();
        page.historyLink().shouldBe(visible);
    }
}
