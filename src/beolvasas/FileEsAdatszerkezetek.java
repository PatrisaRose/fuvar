package beolvasas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;

public class FileEsAdatszerkezetek {

    private List<String> sorok;

    public static void main(String[] args) throws IOException, ParseException {
        new FileEsAdatszerkezetek().feladatok();
    }
    
    public FileEsAdatszerkezetek() throws IOException{
        sorok = Files.readAllLines(Path.of("fuvar.csv"));
    }

    private void feladatok() throws IOException, ParseException {
//        feladat1();
//        feladat2();
        feladat3();
    }

    private void feladat1() throws IOException {

        System.out.println("1. feladat: a file sorainak száma:");
        System.out.printf("A fájl %d db sort tartalmaz.\n", sorok.size());
    }

    private void feladat2() throws IOException, ParseException {
        System.out.println("2. feladat: 1. fuvar adatait");
        Fuvar f = new Fuvar(sorok.get(1));
        System.out.println(f);
    }

    private void feladat3() throws IOException, ParseException {
        System.out.println("----3. feladat: 1 véltelen fuvar adatai");
        int szam = (int) (Math.random() * sorok.size()-1) + 1;
        Fuvar f1 = new Fuvar(sorok.get(szam));
        System.out.println(f1);
    }

}
