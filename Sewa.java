import java.io.IOException;
import java.util.Scanner;

public class Sewa {
    private static Property propertiKita;
    private static LayananKebersihan layananKebersihan;
    private static LayananPerbaikan layananPerbaikan;
    private static int indeks;
    private static int lamaSewa;
    private static int totalHarga;

    public static int getLamaSewa() {
        return lamaSewa;
    }
    public static Property getPropertiKita() {
        return propertiKita;
    }

    public static void mulai() {
        totalHarga = 0;
        propertiKita = pilihProperti();
        if (propertiKita != null) {
            System.out.println("============================================");
            System.out.println("Biaya sewa selama " + (lamaSewa * 12) + " bulan adalah "
                    + ((lamaSewa * 12) / 6) * Perumahan.listProperti.get(indeks).getHargaSewa() + " $");
            System.out.println("============================================");
            totalHarga = totalHarga + ((lamaSewa * 12) / 6) * Perumahan.listProperti.get(indeks).getHargaSewa();
            pilihLayanan();
            if (layananKebersihan != null) {
                totalHarga = totalHarga + layananKebersihan.getHargaLayanan() * (int) propertiKita.getLuas();
            }
            if (layananPerbaikan != null) {

                totalHarga = totalHarga + layananPerbaikan.getHargaLayanan() * ((lamaSewa*12)/3);
            }
        }

    }

    public static void showTotal() {
        Sewa.clearTerminal();
        if (propertiKita != null) {
            System.out.println("============================================");
            System.out.println("============================================");
            System.out.println("                Total Harga");
            System.out.println("============================================");
            System.out.println("============================================");
            propertiKita.info(true);

            if (layananKebersihan != null) {
                System.out.println("============================================");
                System.out.println("Harga tambahan " + layananKebersihan.getNamaLayanan() + " sebesar "
                        + layananKebersihan.getHargaLayanan() * propertiKita.getLuas());
                System.out.println("============================================");
            }
            if (layananPerbaikan != null) {
                System.out.println("============================================");
                System.out.println("Harga tambahan " + layananPerbaikan.getNamaLayanan() + " sebesar "
                        + layananPerbaikan.getHargaLayanan()* ((lamaSewa*12)/3));
                System.out.println("============================================");
            }

            System.out.println("============================================");
            System.out.println("Total harga sewa sebesar : " + totalHarga + " $");
            System.out.println("============================================");
        }

    }

    public static void pilihLayanan() {
        Scanner in = new Scanner(System.in);
        String pilih;
        int layanan = 0;
        System.out.print("Apa ingin tambah layanan kebersihan ? (y/t): ");
        pilih = in.nextLine();
        if (pilih.equalsIgnoreCase("y")) {
            Sewa.clearTerminal();
            Perumahan.listLayanan(true);
            boolean run = true;
            while (run) {
                System.out.print("Pilih layanan kebersihan : ");
                layanan = in.nextInt() - 1;
                if (layanan >= 0 && layanan <= Perumahan.listLayananKebersihan.size() - 1) {
                    run = false;
                } else {
                    System.out.println("Maaf input anda tidak ada di list !!! tolong masukkan dengan benar ");

                }
            }
            System.out.println(
                    "Berhasil memilih layanan : " + Perumahan.listLayananKebersihan.get(layanan).getNamaLayanan());
            layananKebersihan = Perumahan.listLayananKebersihan.get(layanan);
        } else {
            layananKebersihan = null;
        }
        System.out.print("Apa ingin tambah layanan Perbaikan ? (y/t): ");
        pilih = in.next();
        if (pilih.equalsIgnoreCase("y")) {
            Sewa.clearTerminal();
            Perumahan.listLayanan(false);
            boolean run = true;
            while (run) {
                System.out.print("Pilih layanan Perbaikan : ");
                layanan = in.nextInt() - 1;
                if (layanan >= 0 && layanan <= Perumahan.listLayananPerbaikan.size() - 1) {
                    run = false;
                } else {
                    System.out.println("Maaf input anda tidak ada di list !!! tolong masukkan dengan benar ");

                }
            }
            System.out.println(
                    "Berhasil memilih layanan : " + Perumahan.listLayananPerbaikan.get(layanan).getNamaLayanan());
            layananPerbaikan = Perumahan.listLayananPerbaikan.get(layanan);
        } else {
            layananPerbaikan = null;
        }

    }

    public static void clearTerminal() {
        try {
            String operatingSystem = System.getProperty("os.name").toLowerCase();

            if (operatingSystem.contains("win")) {
                // Untuk Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Untuk macOS dan Linux
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Property pilihProperti() {
        Perumahan.listProperti();
        Scanner in = new Scanner(System.in);
        int pilih = 0;
        boolean run = true;
        while (run) {
            System.out.print("Masukkan nomor properti yang ingin di sewa : ");
            pilih = in.nextInt();
            for (Property i : Perumahan.listProperti) {
                if (pilih == i.getnoProperti()) {
                    run = false;
                }
            }
            if (run) {
                System.out.println("Maaf nomor properti yang anda masukkan salah !!! tolong masukkan dengan benar ");

            }
        }
        indeks = pilih - 1;

        if (!Perumahan.listProperti.get((pilih - 1)).isRented()) {
            Perumahan.listProperti.get((pilih - 1)).setRented(true);
            System.out.println("Berhasil Sewa");
            System.out.print("Mau Sewa berapa lama (Input dalam Tahun) ?");
            lamaSewa = in.nextInt();
            return Perumahan.listProperti.get((pilih - 1));
        } else {
            System.out.println("Maaf Properti Sudah Disewa");
            return null;

        }

    }

}
