public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // SWAP LỖI 
        System.out.println("--- Before Failed Swap ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD); // Hàm sai do truyền tham số

        System.out.println("--- After Failed Swap ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        System.out.println();

        // CORRECT SWAP
        System.out.println("--- Before Correct Swap ---");
        correctSwap(jungleDVD, cinderellaDVD); 

        System.out.println("--- After Correct Swap ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
    }

    // Swap này không có tắc dụng
    public static void swap(Object o1, Object o2) {
        Object tmp = o1; 
        o1 = o2;
        o2 = tmp; 
    }

    // Hàm swap có tác dụng: tráo đổi thuộc tính 
    public static void correctSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Lưu tiêu đề cũ của dvd1
        String tmpTitle = dvd1.getTitle();
        // Gán tiêu đề dvd2 cho dvd1 thông qua setter 
        dvd1.setTitle(dvd2.getTitle());
        // Gán tiêu đề tạm cho dvd2
        dvd2.setTitle(tmpTitle);
    }
}