package exercise;

import java.util.ArrayList;

class SafetyList {
    private ArrayList<Integer> list = new ArrayList<>();

    // BEGIN
    public synchronized void add(Integer number) {
        list.add(number);
    }

    public Integer get(int index) {
        return list.get(index);
    }

    public int getSize() {
        return list.size();
    }

    // END
}
