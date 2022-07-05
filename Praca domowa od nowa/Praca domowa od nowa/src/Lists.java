import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Lists {


//    public void mainMenu(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Program ToDo zadania. wybierz opcję");
//        System.out.println("1. Wyświetl zadania");
//        System.out.println("2. Wyświetl szczegóły zadania");
//        System.out.println("3. Menadżer zadań");
//        System.out.println("0. Zapisz zmiany i wyjdź");
//        String choice = scanner.next();
//        switch (choice){
//            case "0":
//                System.exit();
//        }
//        case "1":
//    }

    public static void main(String[] args) throws IOException {


        ArrayList<Task> tasks = new ArrayList<>();
        tasks = readFromFile();
        Menu menu = new Menu();
//        System.out.println(tasks);
//        menu.displayNames(tasks);
//        menu.displayTask(tasks.get(0));
//        menu.finishTask(tasks.get(0));
//        menu.displayTask(tasks.get(0));
//        Task newTask = menu.createTask();
//        tasks.add(newTask);
//        menu.displayNames(tasks);
//        menu.displayNames(tasks);
//        menu.removeTask(tasks);
//        menu.displayNames(tasks);
        menu.mainMenu(tasks);



//        Task task1 = new Task("Śmieci","Wynieś śmieci do śmietnika",2,false);
//        Task task2 = new Task("Zakupy", "Kup mleko", 1, false);
//        Task task3 = new Task("Naczynia", "Umyj naczynia", 3, true);
//        tasks.add(task1);
//        tasks.add(task2);
//        tasks.add(task3);
//        saveToFile(tasks);


    }

    public static void saveToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fileWriter = new FileWriter("zadania.txt");
        for (Task task : tasks) {
            fileWriter.write(task.toCSV());
            fileWriter.flush();

        }
        fileWriter.close();

    }

    public static ArrayList<Task> readFromFile() throws IOException {
        Path path = Path.of("zadania.txt");
        Scanner scanner = new Scanner(path);
        ArrayList<Task> temporaryList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] taskAttributes = line.split(";");
            String name = taskAttributes[0];
            String description = taskAttributes[1];
            int priority = Integer.parseInt(taskAttributes[2]);
            boolean check = Boolean.parseBoolean(taskAttributes[3]);
            Task task = new Task(name, description, priority, check);
            temporaryList.add(task);
        }
        return temporaryList;
    }

}
