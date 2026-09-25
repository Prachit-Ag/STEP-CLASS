public class Problem2 {
    private String[] songs;
    private int songCount;
    public Problem2(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }
    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }
    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }
    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Problem2 p = new Problem2(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println(p.getSongs()[0]);
        System.out.println("Song Count = " + p.getSongCount());
    }
}