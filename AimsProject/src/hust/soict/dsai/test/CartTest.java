package hust.soict.dsai.test;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
public class CartTest {
    
    public static void main(String[] args) {
        Cart cart = new Cart();
        
        // DVD test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // Book test
        Book book1 = new Book("Java Programming", "Education", 45.5f);
        book1.addAuthor("James Gosling");
        book1.addAuthor("Joshua Bloch");

        // CD test
        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music", "Various", 20.0f, "Queen");
        Track track1 = new Track("Bohemian Rhapsody", 6);
        Track track2 = new Track("We Will Rock You", 3);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        // addMedia
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book1);
        cart.addMedia(cd1);

        // In cart
        cart.print(); 

        // Test Playable
        System.out.println("\n--- Testing Play Method ---");
        dvd1.play();
        cd1.play();
        // book1.play(); --> lỗi

        // Test Search
        System.out.println("\n--- Testing Search ---");
        cart.searchById(1);    
        cart.searchByTitle("Star Wars"); 
        cart.searchByTitle("Aladdin");  
    }

}
