package hibernate;

import hibernate.mark.MarksHb;
import hibernate.mark.MarksRepositoryHb;
import hibernate.student.StudentHb;
import hibernate.student.StudentRepositoryHb;
import hibernate.subject.SubjectHb;
import hibernate.subject.SubjectRepositoryHb;

import java.util.Scanner;

public class MainHibernate {

    public static void main(String[] args) {
        Hibernate hibernate = new Hibernate();


        StudentRepositoryHb studentRepositoryHb = new StudentRepositoryHb(hibernate);
        MarksRepositoryHb marksRepositoryHb = new MarksRepositoryHb(hibernate);
        SubjectRepositoryHb subjectRepositoryHb = new SubjectRepositoryHb(hibernate);

        while (true) {
            System.out.println(" JESTES W MENU STUDENTA");
            System.out.println("1. Pokaz studenta o ID: ");
            System.out.println("2. Dodaj studenta do bazy: ");
            System.out.println("3. Usuń studenta z bazy : ");
            System.out.println("4. Popraw dane studenta studenta :");
            System.out.println("5. Dodaj ocene studentowi: ");
            System.out.println("6. Oceny studenta: ");
            System.out.println("7. Koniec");
            System.out.println("8. Dodaj studenta do okreslonego tematu");

            Scanner scanner = new Scanner(System.in);
            int menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu) {

                case 1: {
                    System.out.println("Podaj ID, ktorego szukasz");
                    int idStudentToFind = scanner.nextInt();
                    System.out.println(studentRepositoryHb.get(idStudentToFind));

                    break;
                }
                case 2: {
                    System.out.println("Podaj imie studenta");
                    String name = scanner.nextLine();

                    System.out.println("Podaj nazwisko studenta");
                    String lastname = scanner.nextLine();

                    StudentHb studentHb = new StudentHb();
                    studentHb.setNAME(name);
                    studentHb.setLASTNAME(lastname);

                    studentRepositoryHb.insert(studentHb);
                    break;

                }
                case 3: {
                    System.out.println("Podaj rekord, ktory chcesz usunac : ");
                    int idStudent = scanner.nextInt();
                    studentRepositoryHb.delete(idStudent);
                    break;
                }
                case 4: {
                    System.out.println("Edytuj studenta nr : ");
                    int idStudent = Integer.parseInt(scanner.nextLine());

                    System.out.println("Podaj imie studenta");
                    String name = scanner.nextLine();

                    System.out.println("Podaj nazwisko studenta");
                    String lastname = scanner.nextLine();

                    StudentHb studentHb = studentRepositoryHb.get(idStudent);
                    studentHb.setNAME(name);
                    studentHb.setLASTNAME(lastname);

                    studentRepositoryHb.update(studentHb);
                    break;
                }
                case 5: {
                    System.out.println("Podaj ID studenta, który ma dostac ocene");
                    int idStudent = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Podaj jaka ocene ma dostac: ");
                    int mark = scanner.nextInt();

                    StudentHb studentHb = studentRepositoryHb.get(idStudent);

                    MarksHb marksHb = new MarksHb();

                    marksHb.setMARK(mark);
                    marksHb.setIDSTUDENT(studentHb);

                    marksRepositoryHb.insert(marksHb);

                    break;


                }
                case 6: {
                    System.out.println("Wyswietl oceny studenta: ");
                    int idStudent = scanner.nextInt();
                    StudentHb studentHb = studentRepositoryHb.get(idStudent);


                    System.out.println(studentRepositoryHb.showStudentMarks(studentHb));
                    break;
                }

                case 7:
                    System.out.println("Koniec programu");
                    hibernate.cloesFactory();
                    System.exit(200);
                    break;

                case 8:
                    System.out.println("Powiazanie studenta z tematem");
                    SubjectHb subjectHb1 = new SubjectHb();
                    StudentHb studentHb1 = new StudentHb();

//                    StudentHb studentHb1 = studentRepositoryHb.get(7);
//
//                    SubjectHb subjectHb1 = subjectRepositoryHb.get(1);
//
//                    System.out.println(studentHb1);
//                    System.out.println(subjectHb1);
                    subjectHb1.setNAME("niemiecki");


                    studentHb1.setLASTNAME("lok");
                    studentHb1.setNAME("kjhd");
//TODO : tutaj mozemy wybrac czy ma byc wstawiony stary czy nowy element
                    studentRepositoryHb.addStudentToSubject(studentHb1, subjectHb1);

                case 9:
                    System.out.println("Usuń temat z listy tematów");
//                    MarksHb marksHb = new MarksHb();
//                    StudentHb studentHb2 = studentRepositoryHb.get(6);
//
//                    marksHb.setIDSTUDENT(studentHb2);
//                    marksHb.setMARK(9);
//
//
//                    marksRepositoryHb.insert(marksHb);

                    //TODO: tutaj tez nie rozumiem dlaczego nie usuwa wartości dla pojenynczej oceny
                    // todo - nie wiem czy znaczenie ma zalezność OneToMany
                    boolean delete = marksRepositoryHb.delete(6);
                    System.out.println(delete);


                    break;


            }
        }


    }


}


