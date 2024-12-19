package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static void main(String[] args) {
        int numbers[] = {0, 2, -1, 5};
        System.out.println(App.getMinMax(numbers));
        // END
    }

    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread thread = new MaxThread(numbers);
        MinThread thread1 = new MinThread(numbers);

        thread.start();
        LOGGER.log(Level.INFO, "Thread " + thread.getName() + " started");
        thread1.start();
        LOGGER.log(Level.INFO, "Thread " + thread1.getName() + " started");

        try {
            thread.join();
            LOGGER.log(Level.INFO, "Thread " + thread.getName() + " finished");
            thread1.join();
            LOGGER.log(Level.INFO, "Thread " + thread1.getName() + " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var minMax = new HashMap<String, Integer>();
        minMax.put("max", thread.getMax());
        minMax.put("min", thread1.getMin());
        return minMax;
    }
}
