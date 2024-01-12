package it.epicode.be.childrenClass;

import it.epicode.be.parentClass.File;
import it.epicode.be.parentClass.Multimediale;
import it.epicode.be.parentClass.Riproduzione;

public class Audio extends Multimediale implements Riproduzione {


    private int durata;
    private int volume;


    public Audio(String titolo, int durata, int volume) {
        super(titolo, File.AUDIO);
        this.durata = durata;
        this.volume = volume;

    }


    @Override
    public void plusVol() {
        if (!(getVolume() == 10)) {
            setVolume(getVolume() + 1);
            System.out.println("VOLUME ALZATO!!!!");
        }

    }

    @Override
    public void minVol() {
        if (!(getVolume() == 0)) {
            setVolume(getVolume() - 1);
            System.out.println("Volume abbassato...");
        }

    }

    @Override
    public void play() {
        System.out.println("------------------");
        ;
        for (int i = 0; i < getDurata(); i++) {
            System.out.printf(getTitolo());
            for (int j = 0; j < getVolume(); j++) {
                System.out.printf("!");
            }
            if (i == getDurata() - 1) {
                break;
            } else {
                System.out.println(" ");
            }
        }
        System.out.println(" ");
        System.out.println("------------------");


    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "titolo=" + getTitolo() +
                ", durata=" + durata +
                ", volume=" + volume +
                '}';
    }
}
