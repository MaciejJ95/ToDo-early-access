import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void displayNames(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task.getName());
        }
    }

    public void displayTask(Task task) {
        System.out.println(task.toString());
    }

    public void finishTask(Task task) {
        task.setCheck(true);
    }

    public Task createTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę zadania");
        String name = scanner.nextLine();
        System.out.println("Podaj opis zadania");
        String description = scanner.nextLine();
        System.out.println("Podaj priorytet zadania");
        int priority = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        Task newTask = new Task(name, description, priority, check);
        return newTask;
    }

    public Task modifyTask(Task task) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nową nazwę zadania");
        String newName = scanner.nextLine();
        System.out.println("Podaj nowy opis zadania");
        String newDescription = scanner.nextLine();
        System.out.println("Podaj nowy priorytet zadania");
        int newPriority = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        task = new Task(newName, newDescription, newPriority, check);
        return task;
    }

    public void removeTask(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz nazwę zadania aby je usunąć");
        String userInput = scanner.nextLine();
        for (Task task : tasks) {
            if (task.getName().equals(userInput)) {
                tasks.remove(task);
                System.out.println("Usunięto zadanie");
                return;
            }
        }
        System.out.println("Nie znaleziono takiego zadania!");


    }

    public void mainMenu(ArrayList<Task> tasks) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz opcje");
        System.out.println("0. Zapisz zmiany i zamknij");
        System.out.println("1. Pokaż zadania");
        System.out.println("2. Wyświetl szczegóły zadania");
        System.out.println("3. Ukończ zadanie");
        System.out.println("4. Utwórz nowe zadanie");
        System.out.println("5. Usuń zadanie");
        System.out.println("6. Edytuj nazwę");
        System.out.println("7. Edytuj opis");
        System.out.println("8. Edytuj priorytet");
        System.out.println("9. Zamknij bez zapisywania");
        while (true) {
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "0":
                    System.out.println("Zamykam program i zapisuję zmiany");
                    Lists.saveToFile(tasks);
                    System.exit(0);
                case "1":
                    displayNames(tasks);
                    mainMenu(tasks);
                case "2":
                    System.out.println("Które zadanie chcesz wyświetlić?");
                    String showTask = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.getName().equals(showTask)) {
                            displayTask(task);
                            mainMenu(tasks);
                        }
                    }
                    System.out.println("Nie ma takiego zadania!");
                    mainMenu(tasks);
                case "3":
                    System.out.println("Które zadanie chcesz ukończyć?");
                    String chooseTask = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.getName().equals(chooseTask)) {
                            finishTask(task);
                            System.out.println("Ukończono zadanie");
                            mainMenu(tasks);
                        }
                    }
                    System.out.println("Nie ma takiego zadania!");
                    mainMenu(tasks);
                case "4":
                    tasks.add(createTask());
                    System.out.println("Dodano nowe zadanie");
                    mainMenu(tasks);
                case "5":
                    removeTask(tasks);
                    System.out.println("Zadanie usunięto");
                    mainMenu(tasks);
                case "6":
                    System.out.println("w którym zadaniu chcesz zmienić nazwę??");
                    String changeName = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.getName().equals(changeName)) {
                            System.out.println("Wybierz nową nazwę");
                            task.setName(scanner.nextLine());
                            mainMenu(tasks);
                        }
                    }
                    System.out.println("Nie ma takiego zadania!");
                    break;
                case"7":
                    System.out.println("W którym zadaniu chcesz zmienić opis?");
                    String changeDescription = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.getName().equals(changeDescription)) {
                            System.out.println("Wybierz nowy opis");
                            String description = scanner.nextLine();
                            task.setDescription(description);
                            mainMenu(tasks);
                        }
                    }
                case"8":
                    System.out.println("W którym zadaniu chcesz zmienić priorytet?");
                    String changePriority = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.getName().equals(changePriority)) {
                            System.out.println("Wybierz nowy priorytet");
                            task.setPriority(scanner.nextInt());
                            mainMenu(tasks);
                        }
                    }
                case "9":
                    System.out.println("Zamykam program");
                    System.exit(0);
            }
        }
    }
}



