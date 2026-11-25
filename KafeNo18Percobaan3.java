package Jobsheet11;

import java.util.Scanner;

public class KafeNo18Percobaan3 {

    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHargaNoAbsen(int pilihanMenu, int banyakItem) {
        int[] hargaItems = { 15000, 20000, 22000, 12000, 10000, 18000 };

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int diskon = 0;

        if (kodePromo.equals("DISKON50")) {
            diskon += total * 50 / 100;
        } else if (kodePromo.equals("DISKON30")) {
            diskon += total * 30 / 100;
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            diskon += total * 10 / 100;
        }

        return diskon;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String namaPelanggan = "Andi";
        boolean isMember = true;
        Menu(namaPelanggan, isMember);

        System.out.print("\nMasukkan jumlah jenis menu yang ingin dipesan: ");
        int jumlahJenis = sc.nextInt();

        int totalHarga = 0;

        for (int i = 1; i <= jumlahJenis; i++) {
            System.out.println("\nPesanan ke-" + i);

            int pilihanMenu;
            do {
                System.out.print("Masukkan nomor menu (1-6): ");
                pilihanMenu = sc.nextInt();

                if (pilihanMenu < 1 || pilihanMenu > 6) {
                    System.out.println("Menu tidak tersedia");
                }
            } while (pilihanMenu < 1 || pilihanMenu > 6);

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            totalHarga += hitungTotalHargaNoAbsen(pilihanMenu, banyakItem);
        }

        System.out.print("\nMasukkan kode promo: ");
        String kodePromo = sc.next();

        int diskon = hitungDiskon(totalHarga, kodePromo, isMember);
        int totalBayar = totalHarga - diskon;

        System.out.println("\nTotal harga   : Rp" + totalHarga);
        System.out.println("Besar diskon  : Rp" + diskon);
        System.out.println("Total dibayar : Rp" + totalBayar);
    }
}