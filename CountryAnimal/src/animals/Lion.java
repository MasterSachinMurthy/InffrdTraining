package animals;
import animal.Animal;

import java.util.logging.Logger;

public class Lion implements Animal  {
    final Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public void makeSound(){
        LOGGER.info("Lioon Roar");
    }
}
