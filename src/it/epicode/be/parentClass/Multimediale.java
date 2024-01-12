package it.epicode.be.parentClass;

public abstract class Multimediale {

    private String titolo;
    private File file;

    public Multimediale(String titolo, File file) {
        this.titolo = titolo;
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Multimediale{" +
                "titolo='" + titolo + '\'' +
                ", file=" + file +
                '}';
    }
}
