package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSetup(); // Initialize some sample data

        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    storeMenuLoop();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenuLoop();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thank you for using AIMS!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        scanner.close();
    }

    // --- MENUS ---
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // --- STORE LOGIC LOOP ---
    public static void storeMenuLoop() {
        boolean back = false;
        while (!back) {
            store.print(); 
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the media to view details: ");
                    String titleDetail = scanner.nextLine();
                    Media mediaDetail = store.searchByTitle(titleDetail);
                    if (mediaDetail != null) {
                        System.out.println(mediaDetail.toString());
                        mediaDetailsMenuLoop(mediaDetail);
                    } else {
                        System.out.println("Media not found in store!");
                    }
                    break;
                case 2:
                    System.out.print("Enter the title of the media to add to cart: ");
                    String titleAdd = scanner.nextLine();
                    Media mediaAdd = store.searchByTitle(titleAdd);
                    if (mediaAdd != null) {
                        cart.addMedia(mediaAdd);
                    } else {
                        System.out.println("Media not found in store!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the media to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = store.searchByTitle(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof Playable) {
                            ((Playable) mediaPlay).play();
                        } else {
                            System.out.println("This media cannot be played!");
                        }
                    } else {
                        System.out.println("Media not found in store!");
                    }
                    break;
                case 4:
                        cartMenuLoop();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void mediaDetailsMenuLoop(Media media) {
        boolean back = false;
        while (!back) {
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played!");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void updateStoreMenu() {
        System.out.println("\n--- UPDATE STORE ---");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Choose media type:");
            System.out.println("1. DVD");
            System.out.println("2. Book");
            System.out.println("3. CD");
            System.out.print("Your choice: ");
            int typeChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter cost: ");
            float cost = scanner.nextFloat();
            scanner.nextLine();

            if (typeChoice == 1) {
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                System.out.print("Enter length (mins): ");
                int length = scanner.nextInt();
                scanner.nextLine();
                store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));

            } else if (typeChoice == 2) {
                Book book = new Book(title, category, cost);
                System.out.print("Enter author (or press Enter to skip): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) book.addAuthor(author);
                store.addMedia(book);

            } else if (typeChoice == 3) {
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                CompactDisc cd = new CompactDisc(title, category, director, cost, artist);
                store.addMedia(cd);

            } else {
                System.out.println("Invalid media type.");
            }

        } else if (choice == 2) {
            System.out.print("Enter the title of the media to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) store.removeMedia(m);
            else System.out.println("Media not found!");
        }
    }

    // --- CART LOGIC LOOP ---
    public static void cartMenuLoop() {
        boolean back = false;
        while (!back) {
            cart.print(); 
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Filter by ID | 2. Filter by Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Enter ID: ");
                        cart.searchById(scanner.nextInt());
                    } else {
                        System.out.print("Enter Title: ");
                        cart.searchByTitle(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("1. Sort by Title -> Cost | 2. Sort by Cost -> Title");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) {
                        cart.sortByTitleCost();
                        System.out.println("Sorted successfully!");
                    } else if (sortChoice == 2) {
                        cart.sortByCostTitle();
                        System.out.println("Sorted successfully!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the media to remove: ");
                    String titleRemove = scanner.nextLine();
                    Media mRemove = cart.searchMedia(titleRemove);
                    if (mRemove != null) cart.removeMedia(mRemove);
                    else System.out.println("Media not found in cart!");
                    break;
                case 4:
                    System.out.print("Enter the title of the media to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mPlay = cart.searchMedia(titlePlay);
                    if (mPlay != null) {
                        if (mPlay instanceof Playable) ((Playable) mPlay).play();
                        else System.out.println("This media cannot be played!");
                    } else System.out.println("Media not found in cart!");
                    break;
                case 5:
                    System.out.println("An order has been created successfully! The cart is now empty.");
                    cart.emptyCart(); 
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // --- INITIAL DATA SETUP ---
    public static void initSetup() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "Lucas", 124, 24.95f));
        store.addMedia(new Book("Java Programming", "Education", 45.5f));
    }
}