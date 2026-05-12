package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    // Check equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Track)) return false;
        
        Track other = (Track) obj;
        
        // So sánh cả tiêu đề (không phân biệt hoa thường) và độ dài
        return this.length == other.length && 
               (this.title != null && this.title.equalsIgnoreCase(other.title));
    }
}
