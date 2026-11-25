package Jobsheet11;

import java.util.Scanner;

public class BankSampahNo18 {

    static final double HARGA_PER_KG = 3000;
    static Scanner sc = new Scanner(System.in);

    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        for (int i = 0; i < setoran.length; i++) {
            System.out.printf("Nasabah ke-%d: %.2f kg%n", i + 1, setoran[i]);
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }
        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int indeksMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeksMax]) {
                indeksMax = i;
            }
        }
        return indeksMax;
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah nasabah: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Jumlah nasabah harus lebih dari 0");
            return;
        }

        double[] setoran = inputSetoran(n);

        System.out.println("\n=== Data Setoran ===");
        tampilSetoran(setoran);

        System.out.println("\n=== Saldo Nasabah (Rp3.000 per kg) ===");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], HARGA_PER_KG);
            System.out.printf("Nasabah ke-%d: Rp%,.0f%n", i + 1, saldo);
        }

        System.out.printf("%nTotal setoran seluruh nasabah: %.2f kg%n", totalSetoran(setoran));

        int terbanyak = nasabahTerbanyak(setoran);
        System.out.printf("Setoran terbesar: nasabah ke-%d (%.2f kg)%n", terbanyak + 1, setoran[terbanyak]);

        sc.close();
    }
}
