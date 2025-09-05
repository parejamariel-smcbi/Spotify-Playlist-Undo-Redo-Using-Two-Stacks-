/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spotify;

/**
 *
 * @author ACER
 */
 import java.util.*;

public class Spotify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> playlist = new ArrayList<>();
        Stack<ArrayList<String>> undoStack = new Stack<>();
        Stack<ArrayList<String>> redoStack = new Stack<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add song");
            System.out.println("2. Remove last song");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. View playlist");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            if (choice == 1) {
                System.out.print("Enter song name: ");
                String song = scanner.nextLine();
                undoStack.push(new ArrayList<>(playlist));
                redoStack.clear();
                playlist.add(song);
                System.out.println("Song added.");
            } else if (choice == 2) {
                if (playlist.isEmpty()) {
                    System.out.println("Playlist is empty.");
                } else {
                    undoStack.push(new ArrayList<>(playlist));
                    redoStack.clear();
                    String removed = playlist.remove(playlist.size() - 1);
                    System.out.println("Removed: " + removed);
                }
            } else if (choice == 3) {
                if (undoStack.isEmpty()) {
                    System.out.println("Nothing to undo.");
                } else {
                    redoStack.push(new ArrayList<>(playlist));
                    playlist = undoStack.pop();
                    System.out.println("Undo complete.");
                }
            } else if (choice == 4) {
                if (redoStack.isEmpty()) {
                    System.out.println("Nothing to redo.");
                } else {
                    undoStack.push(new ArrayList<>(playlist));
                    playlist = redoStack.pop();
                    System.out.println("Redo complete.");
                }
            } else if (choice == 5) {
                System.out.println("Current Playlist:");
                if (playlist.isEmpty()) {
                    System.out.println("[Empty]");
                } else {
                    for (int i = 0; i < playlist.size(); i++) {
                        System.out.println((i + 1) + ". " + playlist.get(i));
                    }
                }
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
