package it.epicode.be.childrenClass;

import it.epicode.be.parentClass.File;
import it.epicode.be.parentClass.Luminosita;
import it.epicode.be.parentClass.Multimediale;

public class Immagine extends Multimediale implements Luminosita {
    private int luminosita;


    public Immagine(String titolo, int luminosita) {
        super(titolo, File.IMMAGINE);
        this.luminosita = luminosita;

    }

    @Override
    public void aumLum() {
        if (!(getLuminosita() == 10)) {
            setLuminosita(getLuminosita() + 1);
            System.out.println("LUMINOSITA ALZATO!!!!");
        }

    }

    @Override
    public void dimLum() {
        if (!(getLuminosita() == 0)) {
            setLuminosita(getLuminosita() - 1);
            System.out.println("Luminosita abbassata...");
        }

    }

    public void show() {

        System.out.print(getTitolo());
        for (int i = 0; i < getLuminosita(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    @Override
    public String toString() {
        return "Immagine{" +
                "titolo=" + getTitolo() +
                ", luminosita=" + luminosita +
                '}';
    }
}
