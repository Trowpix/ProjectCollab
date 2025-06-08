import java.util.ArrayList;

public class Sistem <K, V>{
    public static Integer Id = 1;
    ArrayList<K> Key = new ArrayList<>();
    ArrayList<V> Value = new ArrayList<>();
    public void Add(K x, V y){
        Key.add(x);
        Value.add(y);
    }
    /*penamaan penting, jangan terlalu Ambig
    jangan hanya Get, terlalu ambigi.
    harus taro spesifikasi getnya apa
    get ---> getvalue
     */
    public V GetValue(K x) {
        for (int i = 0; i < Key.size(); i++) {
            if (Key.get(i).equals(x)) {
                return Value.get(i);
            }
        }
        return null;
    }

    public ArrayList<K> getKey() {
        return Key;
    }

    public void setKey (K key) {
        Key.add(key);
    }

    public ArrayList<V> getValue() {
        return Value;
    }

    public void setValue(V value) {
        Value.add(value);
    }
    /*
    ini pasti pake auto refactor
    jangan biasakan pake refactor dari intellij nanti dia bisa tambah code yang redundant

    public int getSize() { return Value.size();}

    public V get(int index) { return Value.get(index);}
    public ArrayList<V> getAll(){ return Value;}
     */
}
