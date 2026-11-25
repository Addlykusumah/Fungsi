package Jobsheet11;

import java.util.Scanner;

public class RekapLaundryNo18 {

    static Scanner sc = new Scanner(System.in);
    static String[] layanan;
    static int[] harga;

    static int bacaInt(String pesan) {
        System.out.print(pesan);
        return Integer.parseInt(sc.nextLine().trim());
    }

    static void inputLayanan(int n) {
        layanan = new String[n];
        harga = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine().trim();
            harga[i] = bacaInt("Harga per kg (Rp): ");
        }
    }

    static int[][] inputData(int n, int jumlahHari) {
        int[][] data = new int[n][jumlahHari];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < jumlahHari; j++) {
                data[i][j] = bacaInt(layanan[i] + " - Hari ke-" + (j + 1) + " (kg): ");
            }
        }
        return data;
    }

    static void tampilTabel(int[][] data) {
        System.out.printf("%-14s%8s", "Layanan", "Harga");
        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%10s", "Hari ke-" + (j + 1));
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-14s%8d", layanan[i], harga[i]);
            for (int berat : data[i]) {
                System.out.printf("%10d", berat);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int berat : data[idxLayanan]) {
            total += berat;
        }
        return total;
    }

    static void tampilLayananTertinggi(int[][] data) {
        int idx = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idx)) {
                idx = i;
            }
        }
        System.out.println("Layanan tertinggi: " + layanan[idx] + " (" + totalPerLayanan(data, idx) + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int idxMax = 0, maks = -1;
        for (int j = 0; j < data[0].length; j++) {
            int total = 0;
            for (int i = 0; i < data.length; i++) {
                total += data[i][j];
            }
            if (total > maks) {
                maks = total;
                idxMax = j;
            }
        }
        return idxMax;
    }

    static void tampilPendapatan(int[][] data) {
        int total = 0;
        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            total += pendapatan;
            System.out.println(layanan[i] + ": Rp" + pendapatan);
        }
        System.out.println("Total pendapatan: Rp" + total);
    }

    public static void main(String[] args) {
        int n = bacaInt("Jumlah layanan: ");
        int jumlahHari = bacaInt("Jumlah hari: ");
        if (n <= 0 || jumlahHari <= 0) {
            System.out.println("Jumlah layanan dan hari harus lebih dari 0");
            return;
        }

        inputLayanan(n);
        int[][] data = inputData(n, jumlahHari);

        System.out.println();
        tampilTabel(data);

        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }
        tampilLayananTertinggi(data);
        System.out.println("Hari tersibuk: Hari ke-" + (hariTersibuk(data) + 1));

        System.out.println();
        tampilPendapatan(data);
    }
}