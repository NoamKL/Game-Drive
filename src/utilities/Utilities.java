package utilities;

import java.util.Random;


public interface Utilities {
    /**
     * Checks whether a value is valid, means its between the maximum and minimum values
     * @param Val - value to validate
     * @param min - minimum accepted value
     * @param max - maximum accepted value
     * @return true if Val is valid, false otherwise
     */
    default boolean checkValue(double Val, double min, double max) {
        return ((Val >= min) && (Val <= max));
    }

    /**
     * Prints a message that a wrong value has been inserted and therefore has been replaced
     * @param wrongVal - wrong input value
     * @param correctVal - correct value that replaces the wrong one
     * @param varName - name of replaced variable
     */
    default void correctingMessage(double wrongVal, double correctVal, String varName) {
        System.out.printf("The value %f is illegal for %s, therefore has been replaced with %f",
                wrongVal, varName, correctVal
        );
    }

    /**
     * Prints error message about wrong value
     * @param wrongVal - the wrong value received
     * @param varName - variable name that got the wrong value
     */
    default void errorMessage(double wrongVal, String varName) {
        // TODO - I didn't fully understand what the output should be...
        System.out.printf("The value %s is illegal for %s", wrongVal, varName);
    }

    /**
     * Helper method to generate a random boolean
     * @return true or false, randomly
     */
    default boolean getRandomBoolean() {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    /**
     * Helper method to generate a random double withing defined range
     * @param min - minimum accepted value
     * @param max - maximum accepted value
     * @return - random double between min and max
     */
    default double getRandomDouble(double min, double max) {
        return (min + (max - min) * new Random().nextDouble());
    }

    /**
     * Helper method to generate a random int within defined range
     * @param min - minimum accepted value
     * @param max - maximum accepted value
     * @return - random int between min and max
     */
    default int getRandomInt(int min, int max) {
        return (min + (max - min) * new Random().nextInt());
    }

    /**
     * Helper method to generate a random int array of specified size, each element
     * within defined range
     * @param min - minimum accepted value for each int
     * @param max - maximum accepted value for each int
     * @param arraySize - number of ints to generate in the array
     * @return - array with arraySize element, each between min and max values
     */
    default int[] getRandomIntArray(int min, int max, int arraySize) {
        Random rd = new Random();
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = min + (max - min) * rd.nextInt();
        }
        return arr;
    }

    /**
     * Prints a message that an object has been successfully created
     * @param objName - name of the successfully created object
     */
    default void successMessage(String objName) {
        System.out.printf("%s has been created.\n", objName);
    }


}
