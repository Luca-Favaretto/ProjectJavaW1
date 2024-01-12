import it.epicode.be.childrenClass.Audio;
import it.epicode.be.childrenClass.Immagine;
import it.epicode.be.childrenClass.Video;
import it.epicode.be.parentClass.Multimediale;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Media Player");

//        Audio audio1 = new Audio("canzone", 5, 5);
//        Audio audio2 = new Audio("canzone2", 5, 5);
//        Immagine img1 = new Immagine("immagine", 5);
//        Video video1 = new Video("video", 5, 5, 5);
//        Video video2 = new Video("video2", 5, 3, 5);
//        Multimediale[] multimedia = new Multimediale[5];
//        multimedia[0] = audio1;
//        multimedia[1] = video1;
//        multimedia[2] = audio2;
//        multimedia[3] = video2;
//        multimedia[4] = img1;
        Multimediale[] multimedia = myArray();

        Scanner scanner = new Scanner(System.in);
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

    static private Multimediale[] myArray() {

        Multimediale[] multimedia = new Multimediale[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Vuoi creare un video/audio/immagine?");
            String str = scanner.nextLine();
            switch (str) {
                case "video" -> {
                    System.out.println("Che titolo vuoi dare?");
                    String titolo = scanner.nextLine();
                    System.out.println("Che luminosita mettiamo?");
                    int int1 = scanner.nextInt();
                    System.out.println("Quanto vuoi che duri?");
                    int int2 = scanner.nextInt();
                    System.out.println("Potenza volume?");
                    int int3 = scanner.nextInt();
                    multimedia[i] = new Video(titolo, int1, int2, int3);
                    break;
                }
                case "audio" -> {
                    System.out.println("Che titolo vuoi dare?");
                    String titolo = scanner.nextLine();
                    System.out.println("Quanto vuoi che duri?");
                    int int2 = scanner.nextInt();
                    System.out.println("Potenza volume?");
                    int int3 = scanner.nextInt();
                    multimedia[i] = new Audio(titolo, int2, int3);
                    break;
                }
                case "immagine" -> {
                    System.out.println("Che titolo vuoi dare?");
                    String titolo = scanner.nextLine();
                    System.out.println("Che luminosita mettiamo?");
                    int int1 = scanner.nextInt();
                    multimedia[i] = new Immagine(titolo, int1);
                    break;

                }
                default -> {
                    break;
                }

            }


        }
        scanner.close();


        return multimedia;

    }

    static private void loop(Scanner scanner, Multimediale[] multimedia) {
        int input = 0;
        do {

            System.out.println("Inserisci un numero da 1 a 5, 0 se vuoi concludere");
            input = scanner.nextInt();
            selection(input - 1, multimedia);
        }
        while (input != 0);


    }


    static private void selection(int num, Multimediale[] array) {
        Scanner scanner1 = new Scanner(System.in);
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
                    // Logica per il caso predefinito
                    System.out.println("Selezione non valida");
                }

            }


        } else {
            scanner1.close();
            System.out.println("Ciclo concluso");
        }


    }


}
