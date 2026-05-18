package hust.soict.dsai.test;
import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // Tạo các đối tượng thuộc các lớp con khác nhau
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Various", 20.0f, "Queen");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        Book book = new Book("Java Programming", "Education", 45.5f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // Duyệt qua list và in ra thông tin
        for (Media m : mediae) {
            System.out.println(m.toString());
        }

    }
}
