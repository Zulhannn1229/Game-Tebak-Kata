import java.util.Scanner;

class LevelTree {
    private class LevelNode {
        String level;
        InitData.Tebak[] questions;
        LevelNode left;
        LevelNode right;

        public LevelNode(String level, InitData.Tebak[] questions) {
            this.level = level;
            this.questions = questions;
        }
    }

    private LevelNode root;

    public LevelTree() {
        root = new LevelNode("Easy", InitData.initEasy());
        root.left = new LevelNode("Medium", InitData.initMedium());
        root.left.left = new LevelNode("Hard", InitData.initHard());
    }

    public void startGame(User user) {
        playLevel(root, user);
    }

    private void playLevel(LevelNode node, User user) {
        System.out.println("\nAnda berada di level: " + node.level);
        int attempts = 3;
        Scanner scanner = new Scanner(System.in);

        for (InitData.Tebak tebak : node.questions) {
            boolean correct = false;
            while (attempts > 0 && !correct) {
                System.out.println(tebak);
                System.out.print("Jawaban Anda: ");
                String answer = scanner.nextLine().trim().toLowerCase();

                if (answer.equals(tebak.jawaban)) {
                    System.out.println("Benar!");
                    user.score += 10;
                    correct = true;
                } else {
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("Salah! Kesempatan tersisa: " + attempts);
                    } else {
                        System.out.println("Kesempatan habis! Jawaban yang benar adalah: " + tebak.jawaban);
                    }
                }
            }
            if (attempts == 0) {
                System.out.println("Game over. Skor Anda: " + user.score);
                return;
            }
        }

        if (node.left != null) {
            System.out.println("Selamat! Anda lanjut ke level berikutnya.");
            playLevel(node.left, user);
        } else {
            System.out.println("Selamat! Anda telah menyelesaikan semua level. Skor akhir Anda: " + user.score);
        }
    }
}
