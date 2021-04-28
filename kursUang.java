package com.company;

public class kursUang
{
    private String mataUang;
    private float kursJual;
    private float kursBeli;

    public kursUang(String mataUang, float kursJual, float kursBeli)
    {
        this.mataUang = mataUang;
        this.kursJual = kursJual;
        this.kursBeli = kursBeli;
    }

    public String getMataUang()
    {
        return mataUang;
    }

    public float getkursJual()
    {
        return kursJual;
    }
    public float getKursBeli()
    {
        return kursBeli;
    }

    public void viewList()
    {
        System.out.println(String.format("| %-6s   | %-15f | %-14f |", mataUang,kursBeli, kursJual));
    }

}
