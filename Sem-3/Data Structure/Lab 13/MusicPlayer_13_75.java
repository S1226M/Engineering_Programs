import java.util.Scanner;

class MusicPlayer {
    class Song {
        String name;
        Song prev;
        Song next;

        public Song(String name) {
            this.name = name;
            prev = null;
            next = null;
        }
    }

    Song first = null;

    int countNode() {
        int n = 1;
        Song temp = first;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        return n;
    }

    void addMusic(String x) {
        Song newNode = new Song(x);
        if (first == null) {
            first = newNode;
            return;
        } else {
            Song temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = null;
            System.out.println(newNode.name + " is added");
        }
    }

    public void deleteMusicNumber(int index) {
        if (first == null) {
            System.out.println("list undetflow");
            return;
        }
        int count = 1;
        Song save = first;
        Song pred = save;
        if (index == 1) {
            first = first.next;
            first.prev = null;
            return;
        }
        if (index == countNode()) {
            Song temp = first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            return;
        }
        if (index > countNode() || index < 1) {
            System.out.println("node at given index is not available");
            return;
        }
        while (count != index) {
            save = save.next;
            if (count == index - 1) {
                pred.next = save.next;
                save.next.prev = pred;
                return;
            }
            pred = save;
            count++;
            System.out.println("music deleted");
        }
    }

    Song curreSong = first;

    void playMusicAtSpicify(int index) {
        if (first == null) {
            System.out.println("the playlist is empty");
            return;
        } else if (index > countNode()) {
            System.out.println("there is no music at your specified number");
            return;
        } else {
            Song temp = first;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            curreSong = temp;
            System.out.println(curreSong.name + " is now playing");
        }
    }

    void nextMusic() {
        if (first == null) {
            System.out.println("the playlist is empty");
            return;
        }
        if (curreSong.next == null) {
            System.out.println("there is no next song");
            return;
        }
        curreSong = curreSong.next;
        System.out.println("next song " + curreSong.name + " is now playing");
    }

    void previousMusic() {
        if (first == null) {
            System.out.println("the playlist is empty");
            return;
        }
        if (curreSong.prev == null) {
            System.out.println("there is no next song");
            return;
        }
        curreSong = curreSong.prev;
        System.out.println("previous song " + curreSong.name + " is now playing");
    }

    public void displayPlayList() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }

        Song current = first;
        do {
            System.out.print(current.name + " ");
            current = current.next;
        } while (current != null);
        System.out.println();
    }
}

public class MusicPlayer_13_75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicPlayer list = new MusicPlayer();

        System.out.println("Please Enter 1 if you want add music.");
        System.out.println("Please Enter 2 if you want to delete a music from any position.");
        System.out.println("Please Enter 3 if you want to play from any position.");
        System.out.println("Please Enter 4 if you want to play next music form playlist.");
        System.out.println("Please Enter 5 if you want to play previous music form playlist.");
        System.out.println("Please Enter 6 if you want to Display your playlist.");
        System.out.println("Please Enter 7 if you want to exit the process");

        boolean isTheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the name of music");
                    String name = sc.next();
                    list.addMusic(name);
                    list.displayPlayList();
                    break;
                case 2:
                    System.out.println("Enter the number which you want to delete");
                    int num2 = sc.nextInt();
                    list.deleteMusicNumber(num2);
                    list.displayPlayList();
                    break;
                case 3:
                    System.out.println("Enter the number from where you want to play");
                    int pos = sc.nextInt();
                    list.playMusicAtSpicify(pos);
                    break;
                case 4:
                    list.nextMusic();
                    break;
                case 5:
                    list.previousMusic();
                    break;
                case 6:
                    list.displayPlayList();
                    break;
                case 7:
                    System.out.println("Exiting the process");
                    isTheEnd = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if (isTheEnd) {
                break;
            }
        }
    }
}