package com.company;
import java.time.LocalDate;
import java.util.ArrayList;


public class dataPelanggan
{
    private String namaPelanggan,noTelp,muTukar,muDapat;
    private double jumlahUt, jumlahUd;
    ArrayList<kursUang> uang;

    public dataPelanggan(String namaPelanggan,String noTelp,String muTukar,String muDapat,
                         double jumlahUt, double jumlahUd)
    {
        this.namaPelanggan = namaPelanggan;
        this.noTelp = noTelp;
        this.muTukar = muTukar;
        this.jumlahUt = jumlahUt;
        this.muDapat = muDapat;
        this.jumlahUd = jumlahUd;
    }

    public ArrayList<kursUang> getkursUang()
    {
        return uang;
    }
    public void setkursUang(ArrayList<kursUang> uang)
    {
        this.uang = uang;
    }
    public void viewList()
    {
        LocalDate date = LocalDate.now();
        System.out.println(String.format("| %-6s   | %-19s | %-21f | %-26s | %-16f |", date, muTukar, jumlahUt,muDapat,jumlahUd));
    }
}
