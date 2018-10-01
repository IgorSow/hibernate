package jdbc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mian {
    public static void main(String[] args) {

//        Student student = new Student("aga","marszalek");
//


        StudentRepository studentRepository = new StudentRepository();
//
//        studentRepository.insert(studentOnMap);
//
//        studentRepository.addMark(1,5);


//        Docelowo zadanie polega na utworzeniu aplikacji konsolowej, która wyświuetli użytkownikowi menu:
//        1. Pokaż rekordy
//        2. Dodaj rekordy
//        3. Usun rekord po id
//        4. Nadpisz rekord po id
//        5. Koniec


        while (true) {

            System.out.println("1. Pokaz studenta o ID: ");
            System.out.println("2. Dodaj rekord do bazy: ");
            System.out.println("3. Usuń rekord z bazy : ");
            System.out.println("4. Nadpisz studenta :");
            System.out.println("5. Koniec");

            Scanner scanner = new Scanner(System.in);
            int menu = scanner.nextInt();
            switch (menu) {

                case 1: {
                    studentRepository.get(menu);
                    break;
                }
                case 2: {
                    System.out.println("Podaj imie studenta");
                    String name = scanner.next();

                    System.out.println("Podaj nazwisko studenta");
                    String lastname = scanner.nextLine();

                    Student student = new Student(name, lastname);
                    Map<String, String> studentOnMap = new HashMap<>();

                    studentOnMap.put("NAME", student.getNAME());
                    studentOnMap.put("LASTNAME", student.getLASTNAME());

                    studentRepository.insert(studentOnMap);
                    break;
                }
                case 3: {
                    System.out.println("Podaj rekord, ktory chcesz usunac : ");
                    int idStudent = scanner.nextInt();

                    studentRepository.delete(idStudent);
                    break;
                }
                case 4: {
                    System.out.println("Nadpisz studenta: ");
                    int idStudent = scanner.nextInt();
                    System.out.println("Podaj imie studenta");
                    String name = scanner.next();

                    System.out.println("Podaj nazwisko studenta");
                    String lastname = scanner.nextLine();

                    Student student = new Student(name, lastname);
                    Map<String, String> studentOnMap = new HashMap<>();

                    studentOnMap.put("NAME", student.getNAME());
                    studentOnMap.put("LASTNAME", student.getLASTNAME());

                    studentRepository.update(idStudent,studentOnMap);

                }
                case 5:
                    System.out.println("Koniec programu");
                    System.exit(200);

            }
        }


    }
}