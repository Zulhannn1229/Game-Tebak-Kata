// Main.java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DLL userList = new DLL();

        userList.signUp("b", "b");
        userList.signUp("a", "a");
        userList.signUp("c", "c");

        LevelTree gameLevels = new LevelTree();
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        User currentUser = null;

        Helper.clearScreen();
        while (true) {
            if (!isLoggedIn) {
                System.out.println("=====================");
                System.out.println("      MENU UTAMA     ");
                System.out.println("=====================");
                System.out.println("  [1] Sign up       ");
                System.out.println("  [2] Login         ");
                System.out.println("  [3] Exit          ");
                System.out.println("=====================");

                // System.out.println("╔═══════════════════╗");
                // System.out.println("║     MENU UTAMA    ║");
                // System.out.println("╠═══════════════════╣");
                // System.out.println("║  1. Sign up       ║");
                // System.out.println("║  2. Login         ║");
                // System.out.println("║  3. Exit          ║");
                // System.out.println("╚═══════════════════╝");

                // String reset = "\u001B[0m";
                // String green = "\u001B[32m";
                // String yellow = "\u001B[33m";

                // System.out.println("green + "=====================");
                // System.out.println("      MENU UTAMA     ");
                // System.out.println("=====================" + reset);
                // System.out.println("  " + yellow + "[1] Sign up" + reset);
                // System.out.println("  " + yellow + "[2] Login" + reset);
                // System.out.println("  " + yellow + "[3] Exit" + reset);
                // System.out.println("=====================");

                int choice = 0;
                boolean validInput = false;

                // Validasi input untuk menu utama
                while (!validInput) {
                    System.out.print(">> ");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice < 1 || choice > 3) {
                            System.out.println("Opsi tidak valid, silakan pilih antara 1-3");
                        } else {
                            validInput = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid, harap masukkan angka");
                    }
                }

                switch (choice) {
                    case 1:
                        Helper.clearScreen();
                        System.out.println("---------------------");
                        System.out.println("       SIGN UP       ");
                        System.out.println("---------------------");
                        String usernameSignUp;
                        String passwordSignUp;
                        do {
                            System.out.print("Masukkan username: ");
                            usernameSignUp = scanner.nextLine();
                            if (usernameSignUp.trim().isEmpty()) {
                                System.out.println("Username tidak boleh kosong");
                            }
                        } while (usernameSignUp.trim().isEmpty());
                        do {
                            System.out.print("Masukkan password: ");
                            passwordSignUp = scanner.nextLine();
                            if (passwordSignUp.trim().isEmpty()) {
                                System.out.println("Password tidak boleh kosong");
                            }
                        } while (passwordSignUp.trim().isEmpty());

                        userList.signUp(usernameSignUp, passwordSignUp);

                        Helper.pressEnterKeyToContinue();
                        Helper.clearScreen();
                        break;

                    case 2:
                        Helper.clearScreen();
                        System.out.println("---------------------");
                        System.out.println("        LOGIN        ");
                        System.out.println("---------------------");
                        System.out.print("Masukkan username: ");
                        String usernameLogin = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String passwordLogin = scanner.nextLine();
                        currentUser = userList.login(usernameLogin, passwordLogin);
                        isLoggedIn = currentUser != null;
                        // if (!isLoggedIn) {
                        //     System.out.println("Login gagal. Username atau password salah.");
                        // }
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
                System.out.println("=======================");
                System.out.println("       MENU GAME       ");
                System.out.println("=======================");
                System.out.println("  [1] Mulai Game       ");
                System.out.println("  [2] Cari User        ");
                System.out.println("  [3] Papan Peringkat  ");
                System.out.println("  [4] Logout           ");
                System.out.println("=======================");

                int choice = 0;
                boolean validInput = false;

                // Validasi input untuk menu login
                while (!validInput) {
                    System.out.print(">> ");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice < 1 || choice > 4) {
                            System.out.println("Opsi tidak valid, silakan pilih antara 1-4");
                        } else {
                            validInput = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid, harap masukkan angka");
                    }
                }

                switch (choice) {
                    case 1:
                        gameLevels.startGame(currentUser);
                        break;

                    case 2:
                        Helper.clearScreen();
                        System.out.println("---------------------");
                        System.out.println("      CARI USER      ");
                        System.out.println("---------------------");
                        System.out.print("Masukkan nama user yang dicari: ");
                        String searchUser = scanner.nextLine();
                        userList.searchUser(searchUser);
                        Helper.pressEnterKeyToContinue();
                        Helper.clearScreen();
                        break;

                    case 3:
                        Helper.clearScreen();
                        System.out.println("---------------------");
                        System.out.println("   PAPAN PERINGKAT   ");
                        System.out.println("---------------------");
                        userList.showLeaderboard();
                        Helper.pressEnterKeyToContinue();
                        Helper.clearScreen();
                        break;

                    case 4:
                        System.out.println("Logout berhasil, kembali ke menu utama");
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
