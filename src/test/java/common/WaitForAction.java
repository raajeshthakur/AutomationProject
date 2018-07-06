package common;

import org.testng.Reporter;


/**
 * Helper class for sleep  methods
 */
public class WaitForAction {

    /**
     * Sleep without throwing an exception
     *
     * @param  milliseconds  the time to sleep
     */
    static public void Sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            Reporter.log("WaitForAction.Sleep() Failed");
            Reporter.log("Exception: " + e.toString());
        }
    }
}
