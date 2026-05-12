package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String> ();

    //Constructor:
    public Book() {
        super();
    }
    public Book(String title) {
        super(title);
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Getter --> author
    public List<String> getAuthors() {
        return authors;
    }

    // THÊM TÁC GIẢ
    public void addAuthor(String authorName) {
        // Kiểm tra xem tác giả đã có trong danh sách chưa
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("The author " + authorName + " has been added.");
        } else {
            System.out.println("The author " + authorName + " is already in the list.");
        }
    }

    // xóa tác giả
    public void removeAuthor(String authorName) {
        // Kiểm tra xem tác giả có tồn tại để xóa không
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author " + authorName + " has been removed.");
        } else {
            System.out.println("The author " + authorName + " is not in the list.");
        }
    }

    // In thông tin:
    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - Authors: " + authors.toString() + ": " + this.getCost() + " $";
    }

}
