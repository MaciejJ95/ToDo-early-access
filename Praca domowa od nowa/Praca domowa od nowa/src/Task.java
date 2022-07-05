
public class Task {
    private String name;
    private String description;
    private int priority;
    private boolean check;




    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    Task(String name, String description, int priority, boolean check){
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.check = check;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", check=" + check +
                '}';
    }
    public String toCSV(){
        return name+";"+description+";"+priority+";"+check+'\n';
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCheck() {
        return check;
    }
}


