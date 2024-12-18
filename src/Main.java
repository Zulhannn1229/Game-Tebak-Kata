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

                System.out.print("Pilih opsi: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan username: ");
                        String usernameSignUp = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String passwordSignUp = scanner.nextLine();
                        userList.signUp(usernameSignUp, passwordSignUp);
                        break;
                    case 2:
                        System.out.print("Masukkan username: ");
                        String usernameLogin = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String passwordLogin = scanner.nextLine();
                        currentUser = userList.login(usernameLogin, passwordLogin);
                        isLoggedIn = currentUser != null;
                        break;
                    case 3:
                        System.out.println("Keluar dari program. Sampai jumpa!");
                        return;
                }
            } else {
                System.out.println("\n=== Menu Login ===");
                System.out.println("1. Start Game");
                System.out.println("2. Cari User");
                System.out.println("3. Leaderboard");
                System.out.println("4. Logout");

                System.out.print("Pilih opsi: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        gameLevels.startGame(currentUser);
                        break;
                    case 2:
                        System.out.print("Masukkan nama user yang dicari: ");
                        String searchUser = scanner.nextLine();
                        userList.searchUser(searchUser);
                        break;
                    case 3:
                        userList.showLeaderboard();
                        break;
                    case 4:
                        System.out.println("Logout berhasil. Kembali ke menu utama.");
                        isLoggedIn = false;
                        currentUser = null;
                        break;
                }
            }
        }
    }
}
