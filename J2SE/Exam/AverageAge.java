
import java.util.ArrayList;
import java.util.List;

class Student{
    String name;
    int age;

    Student(String name , int age) {
        this.name = name;
        this.age = age;
    }

    int getAge(){
        return age;
    }

    
}

public class AverageAge {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Parth", 21));
        studentList.add(new Student("Ayush", 30));
        studentList.add(new Student("Jenil", 25));
        studentList.add(new Student("Yogansh", 24));
        studentList.add(new Student("Aditya", 30));
        studentList.add(new Student("Deepak", 35));

        double averageAge = studentList.stream().mapToInt(x -> x.getAge()).average().orElse(0.0);

        System.out.println("All students average age is : "+averageAge);

    }
    
}
