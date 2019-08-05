package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        final Logger LOGGER =
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Class noparamas[] = {};
        try (InputStream input = new FileInputStream("CountryAndAnimal.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out

            String countryName;
            Scanner sc = new Scanner(System.in);
            LOGGER.info("Enter the country : ");
            countryName = sc.nextLine();
            try{
                String result = prop.getProperty(countryName+".animals");
                String[] arrString = result.split(",");
                for (String animal: arrString) {
                    Class<?> eachAnimal = Class.forName("animals."+animal);
                    Object obj = eachAnimal.newInstance();
                    Method method = eachAnimal.getDeclaredMethod("makeSound", noparamas);
                    method.invoke(obj,null);

                }



            }catch (Exception e){
                    LOGGER.warning("Country Not Found ");
            }
            //System.out.println(prop.getProperty(name+".animals"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
