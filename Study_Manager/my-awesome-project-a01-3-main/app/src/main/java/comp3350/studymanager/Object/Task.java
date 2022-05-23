package comp3350.studymanager.Object;

public class Task {
    int id;
    String name;
    String statue;

    public Task() {
    }

    public Task(int id, String name, String statue) {
        this.id = id;
        this.name = name;
        this.statue = statue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }
}
