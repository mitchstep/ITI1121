public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    public Dictionary() {
        this.count = 0;
        this.elems = new Pair[INITIAL_CAPACITY];
    }

    @Override
    public void put(String key, Integer value) {
        if(count==getCapacity()){
            increaseCapacity();
        }
        elems[count]=new Pair(key,value);
        count++;
    }

    private void increaseCapacity() {
        Pair[] temp =  elems;
        elems = new Pair[count+INCREMENT];
        for (int i = 0; i < count; i++){
            elems[i]= temp[i];
        }
    }

    @Override
    public boolean contains(String key) {
        for (int i = count-1; i >= 0; i--) {
            if(elems[i].getKey().equals(key)){
                return true;           }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
        for (int i = count-1; i >= 0; i--) {
            if(elems[i].getKey().equals(key)){
                return elems[i].getValue();
            }
        }
        return 0;
    }

    @Override
    public void replace(String key, Integer value) {
        for (int i = count-1; i >= 0; i--) {
            if(elems[i].getKey().equals(key)){
                elems[i] = new Pair(key, value);
                break;
            }
        }
    }

    @Override
    public Integer remove(String key) {
        int index = 0;
        Pair remove;
        for (int i = count-1; i >= 0; i--) {
            if(elems[i].getKey().equals(key)){
                index = i;
                break;
            }
        }
        remove =  elems[index];
        Pair[] temp = new Pair[getCapacity()-index];
        for (int j = 0,i = index+1;i<count;i++,j++){
            temp[j] = elems[i];
        }
        for (int i = index,j = 0;i<count;i++,j++){
            elems[i]=temp[j];
        }
        count--;
        return remove.getValue();
    }

    @Override
    public String toString() {
        String res;
        res = "Dictionary: {elems = [";
        for (int i = count-1; i >= 0 ; i--) {
            res += elems[i];
            if(i > 0) {
                res += ", ";
            }
        }
        return res +"]}";
    }

}