package com.studentmanagement.app;

import com.studentmanagement.service.ClassService;
import com.studentmanagement.service.StudentClassService;
import com.studentmanagement.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
    private static final StudentClassService studentClass = new StudentClassService();
    private static final ClassService classService = new ClassService();
    private static final StudentService studentService = new StudentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome Student management system!");
        showMenu();
        while(true) {
            System.out.println("Enter fuctions");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    studentService.findAll();
                    break;
                case 2:
                    studentClass.addStudentClass();
                    break;
                case 3:
                    studentService.deleteById();
                    break;
                case 4:
                    studentClass.updateClassName();
                    break;
                case 5:
                    studentClass.findStudentClassByClassName();
                    break;
                case 6:
                    studentClass.findStudentClassByMajor();
                    break;
                case 7:
                    studentClass.calculateAverageScoreByClassName();
                    break;
                case 8:
                    studentClass.displayTheNumberOfStudentsByClassName();
                    break;
                case 9:
                    studentClass.displayTheNumberOfStudentsByMajor();
                    break;
                case 10:
                    studentClass.averageAgeByClass();
                    break;
                case 11:
                    studentService.searchStudentMaxAverageScore();
                    break;
                case 12:
                    studentService.updateStudentScore();
                    break;
                case 13:
                    studentService.updateStudentDob();
                    break;
                case 14:
                    studentService.updateAllScore();
                    break;
                case 15:
                    studentService.averageAge();
                    break;
                case 16:
                    studentService.findByCity();
                    break;
                case 17:
                    studentService.sortByName();
                    break;
                case 18:
                    classService.findAll();
                    break;
                case 19:
                    classService.deleteClass();
                    break;
                case 20:
                    classService.addClass();
                    break;
                case 21:
                    classService.findIdClass();
                case 22:
                    showMenu();
                    break;
                case 23:
                    System.out.println("Good bye.");
                    return;
                default:
                    System.out.println("Not a option. Please choose again");
            }
        }
    }

    public static void showMenu() {
        // StudentClass
        System.out.println("1. List StudentClass");
        System.out.println("2. Add StudentClass");
        System.out.println("3. Delete StudentClass");
        System.out.println("4. update StudentClass By ClassName ");
        System.out.println("5. Search student By ClassName");
        System.out.println("6. Search student By major");
        System.out.println("7. grade point average");
        System.out.println("8. number of students according to Class Name");
        System.out.println("9. number of students according to Major");
        System.out.println("10. average age by class");
        //Student
        System.out.println("11. Find the student with the highest GPA");
        System.out.println("12. Correct student grades");
        System.out.println("13. Edit student's date of birth");
        System.out.println("14. Edit all students' grades");
        System.out.println("15. Average age");
        System.out.println("16. Search students by accommodation ");
        System.out.println("17. Sort students by name");
        // Class
        System.out.println("18. Display All Class");
        System.out.println("19. Delete Class");
        System.out.println("20. Add class");
        System.out.println("21. find Class");
        //End
        System.out.println("22. Show menu");
        System.out.println("23. Exist");
    }
}
