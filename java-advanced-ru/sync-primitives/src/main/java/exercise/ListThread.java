package exercise;

// BEGIN
public class ListThread extends Thread {

    public ListThread(SafetyList l) throws InterruptedException {
        for(var i = 1; i <= 1000; i++) {
            Thread.sleep(1);
            l.add(i);
        }
    }
}
// END
