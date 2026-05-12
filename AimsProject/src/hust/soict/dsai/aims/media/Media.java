package hust.soict.dsai.aims.media;


public class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constuctor:
    public Media() {

    }
    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    //Getters, Setters
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Check unique
    @Override
    public boolean equals(Object obj) {
        // Check có cùng là một đối tượng k
        if (this == obj) return true; 

        // Check xem đối tượng truyền có null hoặc khác lớp không
        if (obj == null || !(obj instanceof Media)) return false; 

        // Ép kiểu để so sánh title
        Media other = (Media) obj;

        // cả 2 title đều null --> bằng nhau
        if (this.title == null) {
            return other.title == null;
        } return this.title.equalsIgnoreCase(other.title); 
    }

}
