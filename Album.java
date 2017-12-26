package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String name;
    private LinkedList<Song> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new LinkedList<Song>();
    }

    public boolean addNewSong(String title, double duration) {
        ListIterator<Song> listIterator = this.songs.listIterator();
        if (songExist(title) != null) {
            System.out.println("title already in album");
            return false;
        }
        this.songs.add(new Song(title, duration));
        return true;
    }

    public void deleteSong(String title) {
        for (int i = 0; i < this.songs.size(); i++) {
            if (this.songs.get(i).getTitle() == title) {
               this.songs.remove(i);
                return;
            }
        }
        System.out.println("this song does not exist");
    }

    public Song songExist (String title) {
        for (Song theSong : this.songs) {
            if(theSong.getTitle().equals(title)) {
                return theSong;
            }
        }
                return null;
    }

//
//    public boolean songExist(String title) {
//        ListIterator<Song> listIterator = this.songs.listIterator();
//        boolean searching = true;
//        while (searching) {
//            while (listIterator.hasNext()) {
//                if (listIterator.next().getTitle().equals(title)) {
//                    return true;
//                }
//            }
//            searching = false;
//        }
//        return false;
//    }


    public void printSongs() {
        ListIterator<Song> listIterator = this.songs.listIterator();
        System.out.println("");
        if (this.songs.isEmpty()) {
            System.out.println("No songs to print");
        } else {
            while (listIterator.hasNext()) {
                System.out.println(listIterator.next().getTitle());
            }
        }
    }


    public String getName() {
        return name;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }
}
