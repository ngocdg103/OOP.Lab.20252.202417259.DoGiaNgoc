public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100]; 
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore++] = dvd;
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full!");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int indexToRemove = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[--qtyInStore] = null;
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The DVD \"" + dvd.getTitle() + "\" was not found in the store.");
        }
    }
}