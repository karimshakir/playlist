package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album1 = new Album("All eyes");
        Album album2 = new Album("LAD ");


        album1.addNewSong("song1", 3);
        album1.addNewSong("song2", 3);
        album2.addNewSong("song3", 3);
        album2.addNewSong("song4", 3);
        album2.addNewSong("song5", 3);

        albums.add(album1);
        albums.add(album2);



        PlayList playList1 = new PlayList("Best");
        playList1.addNewSong(album1, "song1");
        playList1.addNewSong(album1, "song2");
        playList1.addNewSong(album2, "song3");
        playList1.addNewSong(album2, "song4");
        playList1.addNewSong(album2, "song5");



        runPlaylist(playList1);


    }



    private static void runPlaylist(PlayList playlist) {
        boolean quit = false;
        boolean forward = true;
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> listIterator = playlist.getSongs().listIterator();
        System.out.println();
        if (playlist.getSongs() == null) {
            System.out.println("Playlist is empty");
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());

        }

        while(!quit) {
            System.out.println();
            System.out.println("Choose an option:");
            printMenu();
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Bye - Bye");
                    quit = true;
                    break;
                case 2:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("We are at the end of playlist");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                       // if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        //}
                        forward = false;
                    }
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().getTitle());
                        } else {
                            System.out.println("We are at the start of playlist");
                        }

                    break;
                case 4:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().getTitle());
                        forward = false;
                        } else {
                            System.out.println("We are at the start of playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().getTitle());
                        forward = true;
                        } else {
                            System.out.println("We are at the end of playlist");
                        }
                    }
                    break;
                case 5:
                    playlist.printSongsInPlaylist();
                    break;
                case 6:
                    printMenu();
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("1 - Quit\n" +
                "2 - Next song\n" +
                "3 - Previous Song\n" +
                "4 - Replay Current Song\n" +
                "5 - Show PLaylist\n" +
                "6 - Show Menu\n");
    }
}
