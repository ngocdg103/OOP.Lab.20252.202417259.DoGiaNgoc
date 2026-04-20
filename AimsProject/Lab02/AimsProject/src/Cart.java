public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 

    private int qtyOrdered = 0;

    // Thêm vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) { 
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc; 
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        }
        else {
            System.out.println("The cart is full"); 
        }
    }

    // Xóa khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
            return;
        }

        int indexToRemove = -1;
        for (int j = 0; j < qtyOrdered; j++) {
            if (itemsOrdered[i].equals(disc)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int j = indexToRemove; j < qtyOrdered - 1; j++) {
                itemsOrdered[j] = itemsOrdered[j + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null; 
            qtyOrdered--; 
            System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the cart.");
        }
    }
    }

    // Tính tổng chi phí
    public float totalCost() {
        float total = 0; 
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost(); 
        } return total; 
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
    
        for (int i = 0; i < qtyOrdered; i++) {
       
        System.out.println(itemsOrdered[i].getId() + ". DVD - " 
            + itemsOrdered[i].getTitle() + " - " 
            + itemsOrdered[i].getCategory() + " - " 
            + itemsOrdered[i].getDirector() + " - " 
            + itemsOrdered[i].getLength() + ": " 
            + itemsOrdered[i].getCost() + " $");
    }
    
    System.out.println("Total cost: " + totalCost() + " $");
    System.out.println("***************************************************");
    
    }
}





