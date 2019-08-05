package animals;
import animal.Animal;

import java.util.logging.Logger;

public class Elephant implements Animal{
    final Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Override
    public void makeSound(){
        LOGGER.info("Trumpets");
    }
}
