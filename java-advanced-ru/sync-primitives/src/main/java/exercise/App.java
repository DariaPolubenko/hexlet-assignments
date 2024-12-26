package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        // BEGIN
        SafetyList safeList = new SafetyList();

        var tread1 = new Thread(new ListThread(safeList));
        var tread2 = new Thread(new ListThread(safeList));

        tread1.start();
        tread2.start();

        try {
            tread1.join();
            tread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(safeList.getSize());
        // END
    }
}

