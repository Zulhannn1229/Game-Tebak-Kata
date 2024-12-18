// Main.java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DLL userList = new DLL();
        LevelTree gameLevels = new LevelTree();
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        User currentUser = null;

        while (true) {
            if (!isLoggedIn) {
                System.out.println("\n=== Menu ===");
                System.out.println("1. Sign Up");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice = 0;
                boolean validInput = false;

                // Validasi input untuk menu utama
                while (!validInput) {
                    System.out.print("Pilih opsi: ");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice < 1 || choice > 3) {
                            System.out.println("Opsi tidak valid, silakan pilih antara 1-3.");
                        } else {
                            validInput = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid. Harap masukkan angka.");
                    }
                }

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan username: ");
                        String usernameSignUp = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String passwordSignUp = scanner.nextLine();
                        userList.signUp(usernameSignUp, passwordSignUp);
                        Helper.pressEnterKeyToContinue();
                        Helper.clearScreen();
                        break;

                    case 2:
                        System.out.print("Masukkan username: ");
                        String usernameLogin = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String passwordLogin = scanner.nextLine();
                        currentUser = userList.login(usernameLogin, passwordLogin);
                        isLoggedIn = currentUser != null;
                        if (!isLoggedIn) {
                            System.out.println("Login gagal. Username atau password salah.");
                        }
                        Helper.pressEnterKeyToContinue();
                        Helper.clearScreen();
                        break;

                    case 3:
                        System.out.println("Keluar dari program. Sampai jumpa!");
                        scanner.close();
                        return;

                    default:
                        // Tidak diperlukan karena sudah divalidasi sebelumnya
                        break;
                }
            } else {
                System.out.println("\n=== Menu Login ===");
                System.out.println("1. Start Game");
                System.out.println("2. Cari User");
                System.out.println("3. Leaderboard");
                System.out.println("4. Logout");

                int choice = 0;
                boolean validInput = false;

                // Validasi input untuk menu login
                while (!validInput) {
                    System.out.print("Pilih opsi: ");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice < 1 || choice > 4) {
                            System.out.println("Opsi tidak valid, silakan pilih antara 1-4.");
                        } else {
                            validInput = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid. Harap masukkan angka.");
                    }
                }

                switch (choice) {
                    case 1:
                        gameLevels.startGame(currentUser);
                        break;

                    case 2:
                        System.out.print("Masukkan nama user yang dicari: ");
                        String searchUser = scanner.nextLine();
                        userList.searchUser(searchUser);
                        Helper.pressEnterKeyToContinue();
                        Helper.clearScreen();
                        break;

                    case 3:
                        System.out.println("Menampilkan leaderboard...");
                        userList.showLeaderboard();
                        Helper.pressEnterKeyToContinue();
                        Helper.clearScreen();
                        break;

                    case 4:
                        System.out.println("Logout berhasil. Kembali ke menu utama.");
                        Helper.pressEnterKeyToContinue();
                        Helper.clearScreen();
                        isLoggedIn = false;
                        currentUser = null;
                        break;

                    default:
                        // Tidak diperlukan karena sudah divalidasi sebelumnya
                        break;
                }
            }
        }
    }
}
