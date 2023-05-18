package adatszerkezetek;

import progtetelek.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FileEsAdatszerkezetek {

    private List<String> sorok;
    private Fuvar[] fuvarok;

    public static void main(String[] args) throws IOException, ParseException {
        new FileEsAdatszerkezetek().feladatok();
    }

    public FileEsAdatszerkezetek() throws IOException, ParseException {
        sorok = Files.readAllLines(Path.of("fuvar.csv"));
        assert !sorok.isEmpty() : "Üres a fájl";
        fuvarok = new Fuvar[sorok.size() - 1];
        for (int i = 1; i < sorok.size(); i++) {
            fuvarok[i - 1] = new Fuvar(sorok.get(i));
        }
        assert sorok.size() - 1 == fuvarok.length : "Nincs meg minden fuvar";
        assert fuvarok[0] != null : "Első fuvar hibás";
        assert fuvarok[fuvarok.length - 1] != null : "Utolsó fuvar hibás";
    }

    private void feladatok() throws IOException, ParseException {
        feladat1();
        feladat2();
        feladat3();
        feladat4();
        feladat5();
        feladat6();
        feladat7();
        feladat8();
        
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
        int szam = (int) (Math.random() * sorok.size() - 1) + 1;
        Fuvar f1 = new Fuvar(sorok.get(szam));
        System.out.println(f1);
    }

    private void feladat4() throws ParseException {
        System.out.println("----4. feladat, milyen dátumú a legnagyobb távolság?");

        double max = 0;
        int indexHelye = 0;

        for (int i = 0; i < fuvarok.length; i++) {
            if (fuvarok[i].getTavolsag() > max) {
                max = fuvarok[i].getTavolsag();
                indexHelye = i;
            }
        }
        System.out.println("Ez a dátum: " + fuvarok[indexHelye].getIndulas() + " a legnagyobb távolság!");

    }

    private void feladat5() throws ParseException {
        double osszErtek = 0;
        int index = 0;

        for (Fuvar fuvarok1 : fuvarok) {
            osszErtek += fuvarok1.getBorravalo();
            index++;
        }

        System.out.println("Az átlag: " + osszErtek / fuvarok.length);
    }

    private void feladat6() {
        int i = 0, N = fuvarok.length;
        boolean T = "bankkártya".equals(fuvarok[i].getFizMod());
        while (i < N && T) {
            i++;
        }

        System.out.println((i >= N) ? "igen" : "nem");
    }
    
    private void feladat7(){
        System.out.println("--------7. feladat: minden készpénzes fizet");
        int i = 0, N = fuvarok.length;
        while(i < N && kpNullBorravaloval(fuvarok[i])){
            i++;
        }
        System.out.println(i >= N ? "igen" : "nem");
    }

    private boolean kpNullBorravaloval(Fuvar fuvar) {
        boolean kp = fuvar.getFizMod().equals("készpénz");
        boolean borravaloNulla = fuvar.getBorravalo() == 0;
        return kp && borravaloNulla;
    }
    
    private void feladat8() throws IOException{
        System.out.println("--- 8. feladat: problémás kérdések");
        System.out.println("-- milyen fizetési módok vannak rögzítve?");
        List<Fuvar> kpFuvarok = new ArrayList<>(); //mérete: 0
        for (Fuvar fuvar : fuvarok) {
            if(fuvar.getFizMod().equals("készpénz")){
                kpFuvarok.add(fuvar);
            }
        }
        assert kpFuvarok.size() > 0 : "Üres a lista";
        String kimenet = "";
         for (Fuvar fuvar : fuvarok){
             kimenet += fuvar + "\n";
         }
         System.out.println("-konzolra:\n" + kimenet);
         Files.writeString(Path.of("kpFuvarok.txt"), kimenet);
         System.out.println("\"kpFuvarok.txt\" kiírva!");
        System.out.println("melyik fizetési módból mennyit volt?");
        
        HashSet<String> fizModok = new HashSet<>();
         for (Fuvar fuvar : fuvarok){
             fizModok.add(fuvar.getFizMod());
         }
         for (String fizMod : fizModok){
             System.out.println(fizMod);
         }
        
        /*HashMap<String, String> capitalCities = new HashMap<String, String>();*/
    }
}
