import java.util.ArrayList;

public class Sistem <K, V>{
    public static Integer Id = 1;
    ArrayList<K> key = new ArrayList<>();
    ArrayList<V> Value = new ArrayList<>();
    public void Add(K x, V y){
        key.add(x);
        Value.add(y);
    }
    public V Get(K x) {
        for (int i = 0; i < key.size(); i++) {
            if (key.get(i).equals(x)) {
                return Value.get(i);
            }
        }
        return null;
    }
    public ArrayList<K> getKey() {
        return key;
    }

    public void setKey(ArrayList<K> key) {
        this.key = key;
    }

    public ArrayList<V> getValue() {
        return Value;
    }

    public void setValue(ArrayList<V> value) {
        Value = value;
    }
}
