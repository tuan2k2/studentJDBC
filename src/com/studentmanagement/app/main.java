package com.studentmanagement.app;

import com.studentmanagement.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class main {

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
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.deleteById();
                    break;
                case 4:
                    studentService.updateStudentName();
                    break;
                case 5:
                    studentService.findById();
                    break;
                case 6:
                    studentService.findByName();
                    break;
                case 7:
                    //                   classService.findStudentByClassName();
                    break;
                case 8:
                    //                    classService.findStudentByMajor();
                    break;
                case 9:
                    studentService.mediumScore();
                    break;
                case 10:
                    studentService.searchStudentMaxAverageScore();
                    break;
                case 11:
                    studentService.updateStudentScore();
                    break;
                case 12:
                    studentService.updateStudentDob();
                    break;
                case 13:
                    studentService.updateAllScore();
                    break;
                case 14:
                    studentService.averageAge();
                    break;
                case 15:
                    studentService.findByCity();
                    break;
                case 16:
                    studentService.sortByName();
                    break;
                case 17:
                    showMenu();
                    break;
                case 18:
                    System.out.println("Good bye.");
                    return;
                default:
                    System.out.println("Not a option. Please choose again");
            }
        }
    }

    public static void showMenu() {
        System.out.println("1. List Student");
        System.out.println("2. Add Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Update student name");
        System.out.println("5. Search student By Id");
        System.out.println("6. Search student By Name");
        System.out.println("7. List Students By Class name");
        System.out.println("8. List Students By major");
        System.out.println("9. AverageScore");
        System.out.println("10. Find the student with the highest GPA");
        System.out.println("11. Correct student grades");
        System.out.println("12. Edit student's date of birth");
        System.out.println("13. Edit all students' grades");
        System.out.println("14. Average age");
        System.out.println("15. Search students by accommodation ");
        System.out.println("16. Sort students by name");
        System.out.println("17. Show menu");
        System.out.println("18. Exist");
    }
}
