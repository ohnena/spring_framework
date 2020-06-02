package me.ohnena.demospring51;

public class OurEvent {

    private Integer id;
    private String title;

    public OurEvent(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "OurEvent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
