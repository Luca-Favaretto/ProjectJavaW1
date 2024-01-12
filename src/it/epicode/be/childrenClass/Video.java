package it.epicode.be.childrenClass;

import it.epicode.be.parentClass.File;
import it.epicode.be.parentClass.Luminosita;
import it.epicode.be.parentClass.Multimediale;
import it.epicode.be.parentClass.Riproduzione;

public class Video extends Multimediale implements Riproduzione, Luminosita {
    private int luminosita;
    private int durata;
    private int volume;


    public Video(String titolo, int luminosita, int durata, int volume) {
        super(titolo, File.VIDEO);
        this.volume = volume;
        this.durata = durata;
        this.luminosita = luminosita;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }


    @Override
    public void aumLum() {
        if (!(getLuminosita() == 10)) {
            setLuminosita(getLuminosita() + 1);
            System.out.println("LUMINOSITA ALZATO!!!!");
        }

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
    public void dimLum() {
        if (!(getLuminosita() == 0)) {
            setLuminosita(getLuminosita() - 1);
            System.out.println("Luminosita abbassata...");
        }

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
                System.out.print("!");
            }
            for (int j = 0; j < getLuminosita(); j++) {
                System.out.print("*");
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

    @Override
    public String toString() {
        return "Audio{" +
                "titolo=" + getTitolo() +
                ", durata=" + getDurata() +
                ", volume=" + getVolume() +
                ", luminosità=" + luminosita +
                '}';
    }


}
