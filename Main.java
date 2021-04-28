package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<dataPelanggan> arrPel = new ArrayList<>();
        ArrayList<kursUang> arrUang = new ArrayList<>();
        int choice;
        String username, usernameInput, passwordInput;
        String Password;
        Scanner baca = new Scanner(System.in);

        Password = "111";
        username = "111";

        do {
            System.out.println("------LOGIN------");
            Scanner input1 = new Scanner(System.in);
            System.out.println("Masukkan Username : ");
            usernameInput = input1.nextLine();

            System.out.println("\nMasukkan Password : ");
            passwordInput = input1.nextLine();
        } while (!usernameInput.equals(username) && !passwordInput.equals(Password));

        do {
            System.out.println("\n\n===============================");
            System.out.println("Perusahaan : Dua Kertas");
            System.out.println("===============================");
            System.out.println("\n\n1. Input Data Nilai Tukar Mata Uang");
            System.out.println("2. Daftar Mata Uang");
            System.out.println("3. Input data Transaksi Penukaran");
            System.out.println("4. Tampilkan Data Transaski Penukaran");
            System.out.println("\n\n Menu Yang Anda Pilih : ");
            choice = baca.nextInt();

            switch (choice) {
                case 1:
                    addkursuang(arrUang);
                    break;
                case 2:
                    daftarmatauang(arrUang);
                    break;
                case 3:
                    addtransaksi(arrPel, arrUang);
                    break;
                case 4:
                    addpelanggan(arrPel);
            }
        } while (choice != 4);
    }

    public static void addkursuang(ArrayList<kursUang> arrUang) {
        Scanner baca = new Scanner(System.in);
        String mataUang, choice, input;
        float kursJual, kursBeli;

        do {
            System.out.println("Masukan Mata Uang : ");
            mataUang = baca.next();

            System.out.println("Masukan Kurs Jual : ");
            kursJual = baca.nextInt();

            System.out.println("Masukan Kurs Beli : ");
            kursBeli = baca.nextInt();

            kursUang uang = new kursUang(mataUang, kursJual, kursBeli);
            arrUang.add(uang);

            System.out.print("Apakah Anda Ingin Memasukan Mata Uang Lagi ? [Y/T]: \n");
            choice = baca.next();
        } while ("Y".equals(choice));
    }

    public static void daftarmatauang(ArrayList<kursUang> arrUang) {
        String mataUang = null;
        int index;
        float kursJual = 0;
        float kursBeli = 0;

        kursUang uang = new kursUang(mataUang, kursJual, kursBeli);

        if (arrUang.isEmpty()) {
            System.out.println("Tidak Ada Data!!!");

        } else {
            System.out.println("===============================================");
            System.out.println("| Mata uang|    Kurs Jual   |    Kurs Beli   |");
            System.out.println("===============================================");
            for (int i = 0; i < arrUang.size(); i++) {
                index = i + 1;
                arrUang.get(i).viewList();
            }
        }
    }

    public static void addtransaksi(ArrayList<dataPelanggan> arrPel, ArrayList<kursUang> arrUang) {
        String namaPelanggan, noTelp, muTukar, muDapat, choice;
        double jumlahUd, jumlahUt;
        String mataUang = null;
        float kursJual = 0;
        float kursBeli = 0;

        Scanner baca = new Scanner(System.in);


        daftarmatauang(arrUang);

        do {
            System.out.println("\nMasukan Nama Pelanggan : ");
            namaPelanggan = baca.next();

            System.out.println("Masukan Nomor Telp Pelanggan : ");
            noTelp = baca.next();

            System.out.println("Masukan Mata Uang Yang Ingin Ditukar: ");
            muTukar = baca.next();

            System.out.println("Masukan Nominal Uang : ");
            jumlahUt = baca.nextInt();

            System.out.println("Masukan Mata Uang Yang Ingin Didapat: ");
            muDapat = baca.next();

            if (muTukar.equals("IDR")) {
                for (int i = 0; i < arrUang.size(); i++) {
                    if (arrUang.get(i).getMataUang().equals(muDapat)) ;
                    {
                        kursJual = arrUang.get(i).getkursJual();
                    }
                }
                jumlahUd = jumlahUt / kursJual;

            } else {
                for (int i = 0; i < arrUang.size(); i++) {
                    if (arrUang.get(i).getMataUang().equals(muDapat)) ;
                    {
                        kursBeli = arrUang.get(i).getKursBeli();
                    }
                }
                jumlahUd = jumlahUt * kursBeli;
            }

            dataPelanggan pel = new dataPelanggan(namaPelanggan,noTelp,muTukar,muDapat,jumlahUt,jumlahUd);
            arrPel.add(pel);

            System.out.print("Adakah Transaksi Lain? [Y/T]: ");
            choice = baca.next();
        } while ("Y".equals(choice));
    }

    public static void addpelanggan(ArrayList<dataPelanggan> arrPel) {
        String namaPelanggan, noTelp, muTukar, muDapat;
        double jumlahUt, jumlahUd;
        int index = 0;

        if (arrPel.isEmpty()) {
            System.out.println("Tidak Ada Transaksi!!!");
        } else {
            System.out.println("==============================================================================================================");
            System.out.println("| Tanggal      | Mata Uang Kurs Jual |    Jumlah Kurs Jual  |    Mata Uang Kurs Beli      |  Jumlah Kurs Beli |");
            System.out.println("==============================================================================================================");
            for (int i = 0; i < arrPel.size(); i++) {
                index = i + 1;
                arrPel.get(i).viewList();
            }
        }
    }
}



