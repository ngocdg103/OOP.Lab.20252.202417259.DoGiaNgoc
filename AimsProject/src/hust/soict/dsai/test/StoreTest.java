package hust.soict.dsai.test;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;


public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        
        Book book1 = new Book("Java Programming", "Education", 45.5f);
        book1.addAuthor("James Gosling");

        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music", "Various", 20.0f, "Queen");
        cd1.addTrack(new Track("Bohemian Rhapsody", 6));

        // Test thêm vào kho
        System.out.println("--- Adding items to store ---");
        store.addMedia(dvd1);
        store.addMedia(book1);
        store.addMedia(cd1);

        store.print();

        // Test xóa khỏi kho
        System.out.println("\n--- Removing an item from store ---");
        store.removeMedia(book1);
        store.print();

        
    }
}