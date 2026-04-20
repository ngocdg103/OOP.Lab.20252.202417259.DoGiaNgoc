package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
            "Cars", "Animation", "John Lasseter", 117, 19.95f
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
            "The Departed", "Crime/Drama", "Martin Scorsese", 151, 24.95f
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
            "Pirates of the Caribbean: Dead Man's Chest", "Action/Adventure", "Gore Verbinski", 151, 29.95f
        );

        System.out.println("--- Check Auto-increment ID ---");
        System.out.println("DVD 1 ID: " + dvd1.getId()); // 1
        System.out.println("DVD 2 ID: " + dvd2.getId()); // 2
        System.out.println("DVD 3 ID: " + dvd3.getId()); // 3

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("\n--- Order Status ---");
        anOrder.printCart();

        System.out.println("\nTesting removal:");
        anOrder.removeDigitalVideoDisc(dvd1);

        System.out.println("Total cost is: " + anOrder.totalCost() + "$");
    }
}