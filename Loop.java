import java.util.Scanner;

public class Loop {
    public static void running() {
        Scanner in = new Scanner(System.in);
        Property properti1 = new Rumah("Rumah Tipe C", 1, 40, 6, false);
        Property properti2 = new Rumah("Rumah Tipe D", 2, 40, 6, true);
        Property properti3 = new Apartment("Apartement tipe C", 3, 40, 3);
        LayananKebersihan layananKebersihan1 = new LayananKebersihan("Layanan Kebersihan Standart", 4);
        LayananKebersihan layananKebersihan2 = new LayananKebersihan("Layanan Kebersihan Premium", 8);
        LayananPerbaikan layananPerbaikan1 = new LayananPerbaikan("Layanan perbaikan Standart", 6);
        LayananPerbaikan layananPerbaikan2 = new LayananPerbaikan("Layanan perbaikan Premium", 10);
        Perumahan.addProperty(properti1);
        Perumahan.addProperty(properti2);
        Perumahan.addProperty(properti3);
        Perumahan.addLayananKebersihan(layananKebersihan1);
        Perumahan.addLayananKebersihan(layananKebersihan2);
        Perumahan.addLayananPerbaikan(layananPerbaikan1);
        Perumahan.addLayananPerbaikan(layananPerbaikan2);
        boolean mainLoop = true;
        while (mainLoop) {
            Sewa.mulai();
            Sewa.showTotal();
            boolean loop = true;
            while (loop) {
                if (Sewa.getPropertiKita() != null) {
                    System.out.println("Apakah ingin menyewa lagi ? (y/t)");
                } else {
                    System.out.println("Maaf properti telah disewa, apakah ingin menyewa properti lainnya ? (y/t)");

                }
                String jawab = in.next();
                if (jawab.equalsIgnoreCase("t")) {
                    Sewa.clearTerminal();
                    loop = false;
                    mainLoop = false;
                } else if (jawab.equalsIgnoreCase("y")) {
                    Sewa.clearTerminal();
                    loop = false;
                } else {
                    System.out.println("Inputan tidak sesuai !!! tolong input dengan benar !!");
                }

            }

        }
    }
}
