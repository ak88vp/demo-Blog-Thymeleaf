package demo.model;

public class Blog {
    private int id;
    private String title;
    private String content;
    private int idCategory;

    public Blog() {
    }

    public Blog(int id, String title, String content, int idCategory) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.idCategory = idCategory;
    }

    public Blog(String title, String content, int idCategory) {
        this.title = title;
        this.content = content;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
