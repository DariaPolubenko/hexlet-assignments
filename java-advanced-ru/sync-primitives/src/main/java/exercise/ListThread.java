package exercise;

// BEGIN
public class ListThread extends Thread {

    private SafetyList list;

    public ListThread(SafetyList list) throws InterruptedException {
      this.list = list;
    }

    public void run() {
        for(var i = 1; i <= 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(i);
        }
    }
}
// END
