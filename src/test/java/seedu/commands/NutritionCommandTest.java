package seedu.commands;

import org.junit.jupiter.api.Test;
import seedu.exceptions.LifeTrackerException;
import seedu.storage.ExerciseStorage;
import seedu.storage.FoodStorage;
import seedu.storage.MealStorage;
import seedu.storage.UserStorage;
import seedu.ui.GeneralUi;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
public class NutritionCommandTest {
    private NutritionCommand nutritionCommand;
    private GeneralUi ui = new GeneralUi();
    private final ExerciseStorage exerciseStorage = new ExerciseStorage("./data/exerciseData.csv");
    private final FoodStorage foodStorage = new FoodStorage();
    private final MealStorage mealStorage = new MealStorage("./data/mealData.csv", foodStorage);
    private final UserStorage userStorage = new UserStorage("./data/userData.csv");

    @Test
    public void nutrition_validInput_expectNoExceptionsThrown() throws LifeTrackerException {
        nutritionCommand = new NutritionCommand();
        assertDoesNotThrow(() -> nutritionCommand.execute(ui, foodStorage, mealStorage, userStorage, exerciseStorage));
    }
}
