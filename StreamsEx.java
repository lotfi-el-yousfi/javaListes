import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;

public class StreamsEx {
    static Random r = new Random();
    /*

    Processing Student Data

Imagine you have a list of Student objects,
where each Student has
 attributes such as name, age, gender,
  and a list of courses they are
 enrolled in. Your task is to perform
 various operations using streams
  to process and analyze this data.

    * Exercise Tasks:

Task 1: Filter and Count:

Create a list of Student objects.
Use a stream to filter students who are older than 20 years old.
Count the number of students who match the criteria.
Task 2: Map and Collect:

Create a list of all unique courses taken by students using streams.
Ensure the courses list does not contain duplicates.
Task 3: Sorting and Limiting:

Sort the list of students by their age in descending order using streams.
Limit the output to the first 5 students.
Task 4: Grouping and Collecting:

Group students by gender using streams.
Collect and store the grouped data in a Map<String, List<Student>>,
* where the key is the gender and the value is the list of students belonging to that gender.
    * */

    public static void main(String[] args) {
        ArrayList<Student> StudentsList = new ArrayList<>();
        String[] gender = {"MALE", "FEMALE"};
        initList(StudentsList, gender);

        Older30(StudentsList);
        DistictCoursesList(StudentsList);
        SortingNLimiting(StudentsList);

        Groupping(StudentsList);


    }

    private static void Groupping(ArrayList<Student> StudentsList) {
        Map<String, List<Student>> studentsByGender = StudentsList.stream()
                .collect(Collectors.groupingBy(Student::getGender)) ;
        System.out.println("Students grouped by gender: " + studentsByGender);
    }

    private static void SortingNLimiting(ArrayList<Student> StudentsList) {
        StudentsList.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .limit(5)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void DistictCoursesList(ArrayList<Student> StudentsList) {
        StudentsList.stream()
                .flatMap(e -> e.getCourses().stream())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void Older30(ArrayList<Student> StudentsList) {
        int count = (int) StudentsList.stream()
                .filter(e -> e.getAge() > 30)
                .count();
        System.out.printf("numbre of student older that 30 years :%d of 500 %n", count);
    }

    private static void initList(ArrayList<Student> StudentsList, String[] gender) {
        ArrayList<String> courseslist = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            courseslist.add("one".concat(String.valueOf(r.nextInt(50, 200))));
            courseslist.add("two".concat(String.valueOf(r.nextInt(50, 200))));
            courseslist.add("three".concat(String.valueOf(r.nextInt(50, 200))));
            StudentsList.add(
                    new Student(
                            "student ".concat(String.valueOf(r.nextInt(50, 200))),
                            r.nextInt(21, 45),
                            gender[r.nextInt(0, 2)],
                            courseslist
                    ));
        }
    }
}
