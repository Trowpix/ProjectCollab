import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static Sistem<String, Student> Stud = new Sistem<>();
    public static Sistem<String, Professor> Prof = new Sistem<>();
    public static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        SistemMenu:
        while (true) {
            String id = GenerateId();
            Student s = Stud.GetValue(id);
            System.out.print("1. Add Student" +
                    "2. Student Menu" +
                    "3. Professor Menu" +
                    "4. Exit" +
                    ">> ");
            int pil = Sc.nextInt();
            switch (pil) {
                case 1:
                    AddStudent();
                    break;
                case 2:
                    StudMenu:
                    while (true) {
                        System.out.print("1. View data" +
                                "2. View Grades" +
                                "3. Enroll In SubjectName" +
                                "4. Return" +
                                ">> ");
                        pil = Sc.nextInt();
                        switch (pil) {
                            case 1:

                                if (Stud.GetValue(id) != null) {
                                    s.display();
                                } else {
                                    System.out.println("Tidak ditemukan!");
                                }
                                break;
                            case 2:
                                System.out.println("== All Students' Grades ==");

                                for (Student student : Stud.getValue()) {
                                    System.out.println("Name: " + student.getName());

                                    if (student.getSub().isEmpty()) {
                                        System.out.println("No subjects enrolled.");
                                    } else {
                                        for (Subject subject : student.getSub()) {
                                            System.out.println("Subject: " + subject.getSubName());

                                            Evaluation<String, Integer> eval = subject.getEval();
                                            if (eval.getGrade().isEmpty()) {
                                                System.out.println("  No grades available.");
                                            } else {
                                                for (int i = 0; i < eval.getGrade().size(); i++) {
                                                    System.out.println("  " + eval.getType().get(i) + ": " + eval.getGrade().get(i));
                                                }
                                            }
                                        }
                                    }
                                    System.out.println("-----------------------------");
                                }
                                break;

                            case 3:
                                System.out.print("Input Student ID: ");
                                String inputNIP = Sc.nextLine();

                                Student targetStudent = Stud.GetValue(inputNIP);
                                if (targetStudent == null) {
                                    System.out.println("Student not found!");
                                    break;
                                }

                                // Tampilkan list subject
                                Subject.SubjectName[] subList = Subject.SubjectName.values();
                                System.out.println("Available Subjects:");
                                for (int i = 0; i < subList.length; i++) {
                                    System.out.println((i + 1) + ". " + subList[i]);
                                }

                                System.out.print("Choose subject (1-" + subList.length + "): ");
                                int subChoice = Sc.nextInt();

                                if (subChoice < 1 || subChoice > subList.length) {
                                    System.out.println("Invalid choice!");
                                    break;
                                }

                                Subject.SubjectName chosenSubject = subList[subChoice - 1];

                                boolean alreadyEnrolled = false;
                                for (Subject subject : targetStudent.getSub()) {
                                    if (subject.getSubName() == chosenSubject) {
                                        alreadyEnrolled = true;
                                        break;
                                    }
                                }

                                if (alreadyEnrolled) {
                                    System.out.println("Student already enrolled in " + chosenSubject + "!");
                                } else {
                                    targetStudent.setSub(new Subject(chosenSubject));
                                    System.out.println("Subject " + chosenSubject + " successfully enrolled for " + targetStudent.getName() + "!");
                                }
                                break;
                        }
                    }
                case 3:
                    ProfMenu:
                    while (true) {
                        System.out.print("1. Give assignment" +
                                "2. Grade" +
                                "3. Return" +
                                ">> ");
                        pil = Sc.nextInt();
                        switch (pil) {
                            case 1:
                    /*
                    System.out.println("Current id: " + id);
                    if (Stud.GetValue(id) != null){
                        System.out.println("What assignment will you give?");
                        Enum<assignment> assign = assignmentSelection();

                        biasakan penaroan function jangan di main
                        main hanya digunakan untuk yaaa main
                        menu begitu fucntion function nanti milik class masing masing
                     */
                                break;
                            case 2:
                                break;
                            case 3:
                                break ProfMenu;
                        }
                    }
                    break;
                case 4:
                    break SistemMenu;
            }
        }
        System.out.println();
}

            public static void AddStudent() {
                System.out.print("Enter Name >> ");
                String name = Sc.nextLine();
                System.out.println("Select A Major >> ");
                Enum<MajorSelection> major = MajorSelect();
                Stud.Add(String.valueOf(Sistem.Id), new Student(GenerateId(), name, major, NewDate()));
                Sistem.Id++;
            }
            public static String GenerateId () {
                return UUID.randomUUID().toString().substring(0, 8);
            }

            public static Date NewDate () {
                return new Date(10, 2, 2006);
            }


            public enum Assignment {
                MIDTERM_EXAM,
                ENDTERM_EXAM,
                TEST1,
                TEST_2,
                PROJECT
            }

            public enum MajorSelection {
                COMMUNICATION,
                INDUSTRY,
                BUSINESS,
                HOTEL
            }

            public static MajorSelection MajorSelect () {
                MajorSelection[] mj = MajorSelection.values();
                int i = 1;
                for (MajorSelection mjs : MajorSelection.values()) {
                    System.out.println(i + ". " + mjs);
                    i++;
                }
                System.out.print(">>");
                int pil = Sc.nextInt();
                return mj[pil - 1];
            }

            public Student SelectStudent () {
                return null;
            }

        }
