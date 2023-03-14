package seedu.Commands;

import seedu.Database.FoodStorage;
import seedu.Database.MealStorage;
import seedu.Database.UserStorage;
import seedu.Entities.Food;
import seedu.Exceptions.InvalidCommandException;
import seedu.Exceptions.LifeTrackerException;
import seedu.Ui.GeneralUi;

public class AddMealCommand extends Command {
    private Food newFood;
    private int index;

    public AddMealCommand (String commandDescriptor) throws LifeTrackerException {
        parseInput(commandDescriptor);
    }

    private void parseInput(String commandDescriptor) throws LifeTrackerException {
        if (commandDescriptor.length() == 0) {
            throw new InvalidCommandException();
        }
        try {
            this.index = Integer.parseInt(commandDescriptor);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException();
        }
    }

    @Override
    public void execute(GeneralUi ui, FoodStorage foodStorage, MealStorage mealStorage, UserStorage userStorage)
                throws LifeTrackerException {
        Food food = foodStorage.getFoodById(index);
        ui.printNewFoodAdded(foodStorage, index);
    }
}