package Jobsheet11;

import java.util.Scanner;

public class KubusLimas18 {

    static int luasPersegi(int s) {
        return s * s;
    }

    static int volumeKubus(int s) {
        return s * s * s;
    }

    static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    static double volumeLimasPersegi(int s, int t) {
        return (double) luasPersegi(s) * t / 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan, s, t;

        do {
            System.out.println("\n===== MENU BANGUN RUANG =====");
            System.out.println("1. Luas persegi");
            System.out.println("2. Volume kubus");
            System.out.println("3. Luas permukaan kubus");
            System.out.println("4. Volume limas persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan panjang sisi: ");
                    s = sc.nextInt();
                    System.out.println("Luas persegi = " + luasPersegi(s));
                    break;
                case 2:
                    System.out.print("Masukkan panjang rusuk: ");
                    s = sc.nextInt();
                    System.out.println("Volume kubus = " + volumeKubus(s));
                    break;
                case 3:
                    System.out.print("Masukkan panjang rusuk: ");
                    s = sc.nextInt();
                    System.out.println("Luas permukaan kubus = " + luasPermukaanKubus(s));
                    break;
                case 4:
                    System.out.print("Masukkan panjang sisi alas: ");
                    s = sc.nextInt();
                    System.out.print("Masukkan tinggi limas: ");
                    t = sc.nextInt();
                    System.out.printf("Volume limas persegi = %.2f%n", volumeLimasPersegi(s, t));
                    break;
                case 0:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);

        sc.close();
    }
}
