package exercise;

class SafetyList {
    private int[] list = new int[10];
    private int size;

    // BEGIN
    public synchronized void add(Integer number) {
        if (size == list.length) {
            int[] copyList = new int[list.length * 2];
            System.arraycopy(list, 0, copyList, 0, list.length);
            list = copyList;
        }
        list[size++] = number;
    }

    public Integer get(int index) {
        return list[index];
    }

    public int getSize() {
        return size;
    }

    // END
}
