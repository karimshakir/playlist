package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {
    private String name;
    private LinkedList<Song> songs;


    public PlayList(String name) {
        this.name = name;
        this.songs = new LinkedList<>();
    }

    // Below addNewSong:  write code such that if song is not on the album
    // error message is printed.



    public void addNewSong(Album album, String title) {
        boolean songExist = false;
        for (int i = 0; i < album.getSongs().size(); i++) {

                if (album.getSongs().get(i).getTitle().equals(title)) {
                    //if song title on album == desired song title
                    this.songs.add(album.getSongs().get(i));
                    //playlist adds desired song from album
                    songExist = true;
                }

            }
            if(!songExist) {
                System.out.println(title + " is not on " + album.getName());
            }
        }



    public void printSongsInPlaylist () {
        ListIterator<Song> listIterator = this.songs.listIterator();
        System.out.println("");

        if (this.songs.isEmpty()) {
            System.out.println("No songs to print");
        } else {
           //System.out.println("in else statement");
            while (listIterator.hasNext()) {
                System.out.println(listIterator.next().getTitle());
            }
        }
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


    public String getName() {
        return name;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }
}
