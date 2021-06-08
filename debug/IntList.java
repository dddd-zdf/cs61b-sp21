public class IntList{
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size(){
        if (this.rest != null) {
            return this.rest.size() + 1;
        } else {
            return 1;
        }
    }

    public int iterativeSize() {
        int count = 0;
        IntList current = this;
        while (current!= null) {
            count += 1;
            current = current.rest;
        }
        return count;
    }

    public int get(int i) {
        if (i == 0) {
            return this.first;
        } else {
            return this.rest.get(i - 1);
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.get(0));
    }
}