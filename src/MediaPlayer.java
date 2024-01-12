import it.epicode.be.childrenClass.Audio;
import it.epicode.be.childrenClass.Immagine;
import it.epicode.be.childrenClass.Video;
import it.epicode.be.parentClass.Multimediale;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MediaPlayer {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Media Player");
        Scanner scanner = new Scanner(System.in);
        Multimediale[] multimedia = myArray(scanner);
        try {
            loop(scanner, multimedia);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input non valido");
            loop(scanner, multimedia);
        } catch (Exception e) {
            System.out.println("Numero non valido");
            loop(scanner, multimedia);
        } finally {
            scanner.close();
        }
    }

    static private Multimediale[] myArray(Scanner scanner) {
        Multimediale[] multimedia = new Multimediale[5];
        for (int p = 0; p < 5; p++) {
            System.out.println("Vuoi creare un video/audio/immagine?");
            String str = scanner.nextLine();
            switch (str) {
                case "video" -> {
                    System.out.println("Che titolo vuoi dare?");
                    String titolo = scanner.nextLine();

                    System.out.println("Che luminosita mettiamo?");
                    int int1 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Quanto vuoi che duri?");
                    int int2 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Potenza volume?");
                    int int3 = scanner.nextInt();
                    scanner.nextLine();

                    multimedia[p] = new Video(titolo, int1, int2, int3);
                }
                case "audio" -> {
                    System.out.println("Che titolo vuoi dare?");
                    String titolo = scanner.nextLine();

                    System.out.println("Quanto vuoi che duri?");
                    int int2 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Potenza volume?");
                    int int3 = scanner.nextInt();
                    scanner.nextLine();

                    multimedia[p] = new Audio(titolo, int2, int3);
                }
                case "immagine" -> {
                    System.out.println("Che titolo vuoi dare?");
                    String titolo = scanner.nextLine();

                    System.out.println("Che luminosita mettiamo?");
                    int int1 = scanner.nextInt();
                    scanner.nextLine();

                    multimedia[p] = new Immagine(titolo, int1);
                }
                default -> {
                    multimedia[p] = new Immagine("immagine", 5);
                    System.out.println("Errore generato oggetto casuale");
                }
            }
        }
        System.out.println(Arrays.toString(multimedia));
        return multimedia;
    }

    static private void loop(Scanner scanner, Multimediale[] multimedia) {
        int input = 0;
        do {
            try {
                System.out.println("Inserisci un numero da 1 a 5, 0 se vuoi concludere");
                input = scanner.nextInt();
                scanner.nextLine();
                selection(input - 1, multimedia, scanner);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero intero.");
                scanner.nextLine();
            }
        } while (input != 0);
    }

    static private void selection(int num, Multimediale[] array, Scanner scanner1) {
        if (num != -1) {
            Multimediale selezionato = array[num];
            System.out.printf("Hai selezionato un '%s' %n", selezionato.getFile());
            switch (selezionato.getFile()) {
                case AUDIO -> {
                    Audio audio = (Audio) selezionato;
                    System.out.println("Vuoi alzare il volume?true/false");
                    boolean input1 = scanner1.nextBoolean();
                    if (input1) {
                        audio.plusVol();
                    } else {
                        audio.minVol();
                    }
                    audio.play();
                }
                case VIDEO -> {
                    Video video = (Video) selezionato;
                    System.out.println("Vuoi alzare la luminosità?true/false");
                    boolean input1 = scanner1.nextBoolean();
                    if (input1) {
                        video.aumLum();
                    } else {
                        video.dimLum();
                    }
                    System.out.println("Vuoi alzare il volume?true/false");
                    boolean input2 = scanner1.nextBoolean();
                    if (input1) {
                        video.plusVol();
                    } else {
                        video.minVol();
                    }
                    video.play();
                }
                case IMMAGINE -> {
                    Immagine img = (Immagine) selezionato;
                    System.out.println("Vuoi alzare la luminosità?true/false");
                    boolean input1 = scanner1.nextBoolean();
                    if (input1) {
                        img.aumLum();
                    } else {
                        img.dimLum();
                    }
                    img.show();
                }
                default -> {
                    System.out.println("Selezione non valida");
                }
            }
        } else {
            System.out.println("Ciclo concluso");
        }
    }
}
