import java.util.Scanner;

class Music {
    class Song {
        String name;
        Song lptr;
        Song rptr;

        Song(String data) {
            this.name = data;
            this.lptr = null;
            this.rptr = null;
        }
    }

    private Song first = null;
    private Song last = null;

    // Add music to the playlist
    void add(String name) {
        Song newSong = new Song(name);
        if (first == null) {
            first = newSong;
            last = newSong;
        } else {
            newSong.rptr = first;
            first.lptr = newSong;
            first = newSong;
        }
        System.out.println(name + " has been added to the playlist.");
    }

    // Display the liked music names
    void display() {
        if (first == null) {
            System.out.println("No liked music available");
        } else {
            Song temp = first;
            while (temp != null) {
                System.out.print(temp.name);
                if (temp.rptr != null) {
                    System.out.print(" , ");
                }
                temp = temp.rptr;
            }
            System.out.println();
        }
    }

    // Count music
    int count() {
        Song temp = first;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.rptr;
        }
        return count;
    }

    // Remove music from list
    void remove(int n) {
        if (first == null) {
            System.out.println("No liked music available");
        } else {
            if (n == 1) {
                if (first.rptr == null) {
                    first = null;
                    last = null;
                } else {
                    first = first.rptr;
                    first.lptr = null;
                }
            } else if (n == count()) {
                Song temp = last;
                last = last.lptr;
                if (last != null) {
                    last.rptr = null;
                } else {
                    first = null;
                }
            } else {
                Song temp = first;
                for (int i = 1; i < n; i++) {
                    temp = temp.rptr;
                }
                temp.lptr.rptr = temp.rptr;
                if (temp.rptr != null) {
                    temp.rptr.lptr = temp.lptr;
                }
            }
            System.out.println("Song at position " + n + " has been removed.");
        }
    }
}

public class MusicPlayer_13_75_2 {
    public static void main(String[] args) {
        Music music = new Music();
        Scanner sc = new Scanner(System.in);

        System.out.println("Press 1 to add music");
        System.out.println("Press 2 to remove music");
        System.out.println("Press 3 to exit");

        boolean isFinish = false;
        while (!isFinish) {
            System.out.println("Enter the number:");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.print("Enter the name of music: ");
                    sc.nextLine(); // Consume newline
                    String musicName = sc.nextLine();
                    music.add(musicName);
                    music.display();
                    break;

                case 2:
                    System.out.println("Enter the number of the song to remove: ");
                    int musicRemoveNumber = sc.nextInt();
                    music.remove(musicRemoveNumber);
                    music.display();
                    break;

                case 3:
                    isFinish = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        sc.close();
        System.out.println("Exiting the music player.");
    }
}