import java.util.ArrayList;

public class Subject  {
    private Enum<SubjectName> SubName;
    private final Evaluation<String,Integer> eval = new Evaluation<>();
    private final ArrayList<Assignment> Assignment = new ArrayList<>();

    public Subject(Enum<SubjectName> E) {
        SubName = E;
    }

    public Enum<SubjectName> getSubName() {
        return SubName;
    }

    public Evaluation<String, Integer> getEval() {
        return eval;
    }

    public ArrayList<Assignment> getAssignment() {
        return Assignment;
    }

    enum SubjectName {
        BIG,
        BIN,
        MATH,
        CIVIC,
        HISTORY,
    }

    public static SubjectName SubjectSelection(){
        SubjectName[] sub = SubjectName.values();
        int i = 1;
        for (SubjectName asg : SubjectName.values()){
            System.out.println(i + ". " + asg);
            i++;
        }
        System.out.print(">>"); int pil = Main.Sc.nextInt();
        return sub[pil-1];
    }
}

class Evaluation<K,V>{
    ArrayList<K> Type = new ArrayList<>();
    ArrayList<V> Grade = new ArrayList<>();
    void add(K name, V grade){
        Type.add(name);
        Grade.add(grade);
    }

    public ArrayList<K> getType() {
        return Type;
    }

    public ArrayList<V> getGrade() {
        return Grade;
    }
}



