// LevelTree.java
import java.util.Scanner;

class LevelTree {
    private TebakanQueue tebakanQueue;
    private PetunjukStack petunjukStack;
    private String currentLevel;

    public LevelTree() {
        tebakanQueue = new TebakanQueue();
        petunjukStack = new PetunjukStack();
        initializeLevels("Easy");
    }

    private void initializeLevels(String level) {
        currentLevel = level;
        Tebakan.DataTebakan[] questions;

        switch (level) {
            case "Easy":
                questions = Tebakan.EasyLevel();
                break;
            case "Medium":
                questions = Tebakan.MediumLevel();
                break;
            case "Hard":
                questions = Tebakan.HardLevel();
                break;
            default:
                return;
        }

        // Reset queue dan stack
        while (!tebakanQueue.isEmpty()) {
            tebakanQueue.dequeue();
        }

        // Isi queue dan stack dengan pertanyaan level saat ini
        for (Tebakan.DataTebakan tebakan : questions) {
            tebakanQueue.enqueue(tebakan);
            petunjukStack.push(tebakan.petunjuk);
        }
    }

    public void startGame(User user) {
        Helper.clearScreen();
        System.out.println("---------------------");
        System.out.println("     " + currentLevel + " Level    ");
        System.out.println("---------------------\n");

        int totalQuestions = tebakanQueue.getSize();
        int answeredCorrectly = 0;
        int attempts = 5;

        Scanner scanner = new Scanner(System.in);

        while (!tebakanQueue.isEmpty() && attempts > 0) {
            Tebakan.DataTebakan currentTebakan = tebakanQueue.dequeue();
            boolean questionAnswered = false;

            System.out.println("Pertanyaan: " + currentTebakan.pertanyaan);

            // Opsi petunjuk
            System.out.println("\nLihat petunjuk? (y/n)");
            String hintChoice = scanner.nextLine().trim().toLowerCase();
            if (hintChoice.equals("y") && !petunjukStack.isEmpty()) {
                String hint = petunjukStack.pop();
                System.out.println("Petunjuk: " + hint);
            }

            // Proses menjawab
            for (int i = 3; i > 0; i--) {
                System.out.print("\nJawaban Anda (Kesempatan " + i + "): ");
                String userAnswer = scanner.nextLine().trim().toLowerCase();

                if (userAnswer.equals(currentTebakan.jawaban)) {
                    System.out.println("\u2714 Benar!");
                    user.score += 10;
                    answeredCorrectly++;
                    questionAnswered = true;
                    break;
                } else {
                    System.out.println("\u274C Salah!");
                }
            }

            if (!questionAnswered) {
                System.out.println("\nJawaban yang benar: " + currentTebakan.jawaban);
                attempts--;
            }

            System.out.println("\n----------------------------------------------------------------------------------\n");
        }

        // Evaluasi hasil permainan
        if (attempts > 0) {
            System.out.println("\u2728 Selamat! Anda menjawab " + answeredCorrectly + " dari " + totalQuestions + " pertanyaan.");

            // Lanjut ke level berikutnya
            if (currentLevel.equals("Easy")) {
                initializeLevels("Medium");
                System.out.println("\n\u2728 Anda lanjut ke level Medium!");
                Helper.pressEnterKeyToContinue();
                startGame(user);
            } else if (currentLevel.equals("Medium")) {
                initializeLevels("Hard");
                System.out.println("\n\u2728 Anda lanjut ke level Hard!");
                Helper.pressEnterKeyToContinue();
                startGame(user);
            } else {
                System.out.println("\n\u2728 Selamat! Anda telah menyelesaikan semua level.");
            }
        } else {
            System.out.println("\u2620 Game over. Kesempatan habis.");
        }

        System.out.println("Skor Anda: " + user.score);
        Helper.pressEnterKeyToContinue();
        Helper.clearScreen();
    }
}
