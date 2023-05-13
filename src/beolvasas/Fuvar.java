package beolvasas;

import java.text.NumberFormat;
import java.text.ParseException;


public class Fuvar {
    private int taxi_id;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizMod;

    public Fuvar(String sor) throws ParseException{
        String[] s = sor.split(";");
        this.taxi_id = Integer.parseInt(s[0]);
        this.indulas = s[1];
        this.idotartam = Integer.parseInt(s[2]);
//        this.tavolsag = Double.parseDouble(s[3].replace(",", "."));
        NumberFormat nf = NumberFormat.getInstance();
        Number num = nf.parse(s[3]);
        this.tavolsag = num.doubleValue();
        this.viteldij = Double.parseDouble(s[4].replace(",", "."));
        this.borravalo = Double.parseDouble(s[5].replace(",", "."));
        this.fizMod = s[6];
    }
    
    public Fuvar(int taxi_id, String indulas, int idotartam, double tavolsag, double viteldij, double borravalo, String fizMod) {
        this.taxi_id = taxi_id;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = tavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizMod = fizMod;
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizMod() {
        return fizMod;
    }

    @Override
    public String toString() {
        return "Fuvar{" + "taxi_id=" + taxi_id + ", indulas=" + indulas + ", idotartam=" + idotartam + ", tavolsag=" + tavolsag + ", viteldij=" + viteldij + ", borravalo=" + borravalo + ", fizMod=" + fizMod + '}';
    }
    
    
}
