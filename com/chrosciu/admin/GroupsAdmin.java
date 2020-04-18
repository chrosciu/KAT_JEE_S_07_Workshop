package com.chrosciu.admin;

import com.chrosciu.dao.GroupDao;
import com.chrosciu.model.Group;

import java.sql.SQLOutput;
import java.util.Scanner;

//Program po uruchomieniu wyświetli na konsoli
//        listę wszystkich grup.
//        Następnie wyświetli w konsoli napis
//        "Wybierz jedną z opcji:
//        Po wpisaniu i zatwierdzeniu odpowiedniej opcji
//        program odpyta o dane i wykona odpowiednią
//        operacje:
//        add – dodanie grupy,
//        edit – edycja grupy,
//        delete – usunięcie grupy,
//        quit – zakończenie programu."
//        add – wszystkie dane występujące w klasie
//        Group , bez id ,
//        edit – wszystkie dane występujące w klasie
//        Group oraz id ,
//        delete – id grupy którą należy usunąć.
//        Po wykonaniu dowolnej z opcji, program ponownie wyświetli listę danych i zada pytanie o wybór
//        opcji.

public class GroupsAdmin {
    public static void main(String[] args) {
        GroupDao groupDao = new GroupDao();
        String option = null;
        do {
            Group[] allGroups = groupDao.findAll();
            for (Group group : allGroups) {
                System.out.println(group);
            }
            System.out.print("Wybierz jedną z opcji: ");
            System.out.println("add");
            System.out.println("edit");
            System.out.println("delete");
            System.out.println("quit");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextLine()) {
                System.out.print("Wprowadź poprawną opcję: ");
                scanner.nextLine();
            }
            option = scanner.nextLine();
            switch (option) {
                case "add":
                    Group group = new Group();
                    System.out.print("Wprowadź nazwę nowej grupy: ");
                    String name = scanner.nextLine();
                    group.setName(name);
                    groupDao.create(group);
                    break;
                case "edit":
                    System.out.print("Podaj id grupy do edycji: ");
                    int groupId = scanner.nextInt();
                    Group toUpdate = groupDao.readGroup(groupId);
                    if (toUpdate==null) {
                        System.out.println("Grupa o takim id nie istnieje.");
                        break;
                    }
                    System.out.print("Wprowadź nową nazwę: ");
                    String newName = scanner.next();
                    toUpdate.setName(newName);
                    groupDao.update(toUpdate);
                    break;
                case "delete":
                    System.out.print("Podaj id grupy do usunięcia: ");
                    groupId = scanner.nextInt();
                    groupDao.delete(groupId);
                    break;
                case "quit":
                default:
                    break;
            }
        } while (!"quit".equals(option));
    }
}
