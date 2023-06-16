import java.util.ArrayList;

public class Perumahan {
    public static ArrayList<Property> listProperti = new ArrayList<>();
    public static ArrayList<LayananKebersihan> listLayananKebersihan = new ArrayList<>();;
    public static ArrayList<LayananPerbaikan> listLayananPerbaikan = new ArrayList<>();;

    public static void addProperty(Property property) {
        Perumahan.listProperti.add(property);
    }

    public static void addLayananKebersihan(LayananKebersihan i) {
        Perumahan.listLayananKebersihan.add(i);
    }

    public static void addLayananPerbaikan(LayananPerbaikan i) {
        Perumahan.listLayananPerbaikan.add(i);
    }

    public static void listProperti() {
        System.out.println("================List Properti===============");
        for (Property property : Perumahan.listProperti) {
            property.info();
            System.out.println("============================================");
        }
    }

    public static void listLayanan(boolean cek) {
        System.out.println("============================================");
        System.out.println("================List Layanan================");
        System.out.println("============================================");
        if (cek) {
            System.out.println("Layanan Kebersihan");
            System.out.println("============================================");
            int urut = 1;
            for (LayananKebersihan i : Perumahan.listLayananKebersihan) {
                System.out.println("Layanan kebersihan ke-"+urut);
                urut++;
                i.infoLayanan();
                System.out.println("============================================");
            }
        }
        if (!cek) {
            System.out.println("============================================");
            System.out.println("Layanan Perbaikan");
            System.out.println("============================================");
            int urut = 1;
            for (LayananPerbaikan j : Perumahan.listLayananPerbaikan) {
                System.out.println("Layanan Perbaikan ke-"+urut);
                urut++;
                j.infoLayanan();
                System.out.println("============================================");
            }
        }
    }

}