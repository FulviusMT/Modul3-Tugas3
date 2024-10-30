import java.util.Scanner;

class PC {
    private int pcId;
    private boolean isRented;

    /**
     * @param pcId
     */
    public PC(int pcId) {
        this.pcId = pcId;
        this.isRented = false;
    }

    public int getPcId() {
        return pcId;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        isRented = true;
    }

    public void returnPC() {
        isRented = false;
    }

    /**
     * @return
     */
    public String getStatus() {
        return isRented ? "Sedang disewa" : "Tersedia";
    }
}

class RentalSystem {

    private PC[] pcs;

    /**
     * @param jumlahPC
     */
    public RentalSystem(int jumlahPC) {
        pcs = new PC[jumlahPC];
        for (int i = 0; i < jumlahPC; i++) {
            pcs[i] = new PC(i + 1);
        }
    }

    public void displayPCs() {
        System.out.println("Daftar PC:");
        for (PC pc : pcs) {
            System.out.println("PC " + pc.getPcId() + ": " + pc.getStatus());
        }
    }

    /**
     * @param pcId
     * @return
     */
    private PC findPCById(int pcId) {
        if (pcId > 0 && pcId <= pcs.length) {
            return pcs[pcId - 1];
        }
        return null;
    }

    /**
     * @param pcId
     */
    public void rentPC(int pcId) {
        PC pc = findPCById(pcId);
        if (pc != null) {
            if (!pc.isRented()) {
                pc.rent();
                System.out.println("PC " + pcId + " berhasil disewa!");
            } else {
                System.out.println("PC " + pcId + " sedang disewa.");
            }
        } else {
            System.out.println("PC " + pcId + " tidak ditemukan.");
        }
    }

    /**
     * @param pcId
     */
    public void returnPC(int pcId) {
        PC pc = findPCById(pcId);
        if (pc != null) {
            if (pc.isRented()) {
                pc.returnPC();
                System.out.println("PC " + pcId + " berhasil dikembalikan!");
            } else {
                System.out.println("PC " + pcId + " sudah tersedia.");
            }
        } else {
            System.out.println("PC " + pcId + " tidak ditemukan.");
        }
    }
}

public class RentalPC {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RentalSystem rentalSystem = new RentalSystem(5);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            handleMenuChoice(choice);
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu Rental PC");
        System.out.println("1. Lihat daftar PC");
        System.out.println("2. Sewa PC");
        System.out.println("3. Kembalikan PC");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
    }


    /**
     * @param choice
     */
    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                rentalSystem.displayPCs();
                break;
            case 2:
                System.out.print("Masukkan ID PC yang ingin disewa: ");
                int rentId = scanner.nextInt();
                rentalSystem.rentPC(rentId);
                break;
            case 3:
                System.out.print("Masukkan ID PC yang ingin dikembalikan: ");
                int returnId = scanner.nextInt();
                rentalSystem.returnPC(returnId);
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan layanan rental PC.");
                scanner.close();
                System.exit(0); // Menghentikan program
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}