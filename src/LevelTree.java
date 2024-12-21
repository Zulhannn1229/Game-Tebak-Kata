// LevelTree.java
import java.util.Scanner;

class LevelTree {
    private TebakanQueue tebakanQueue;
    private PetunjukStack petunjukStack;
    private String currentLevel;
    private static final int TOTAL_ATTEMPTS = 15;
    private static final int ATTEMPTS_PER_QUESTION = 3;
    private static final int MAX_HINTS = 10; // 2 hint per soal

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

        while (!petunjukStack.isEmpty()) {
            petunjukStack.pop();
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
        int remainingAttempts = TOTAL_ATTEMPTS;
        int remainingHints = MAX_HINTS;

        Scanner scanner = new Scanner(System.in);

        while (!tebakanQueue.isEmpty() && remainingAttempts > 0) {
            Tebakan.DataTebakan currentTebakan = tebakanQueue.dequeue();
            boolean questionAnswered = false;
            int questionAttempts = ATTEMPTS_PER_QUESTION;
            int questionHints = 1; // Setiap soal hanya punya 1 hint

            System.out.println("Pertanyaan: " + currentTebakan.pertanyaan);

            // Opsi hint hanya sekali di awal
            if (remainingHints > 0 && questionHints > 0) {
                System.out.println("\nIngin melihat petunjuk? (y/n) [Sisa hint global: " + remainingHints + "]");
                String hintChoice = scanner.nextLine().trim().toLowerCase();
                if (hintChoice.equals("y")) {
                    String hint = petunjukStack.pop();
                    System.out.println("Petunjuk: " + hint);
                    remainingHints--;
                    questionHints--;
                }
            }

            // Proses menjawab
            while (questionAttempts > 0 && remainingAttempts > 0) {
                System.out.print("\nJawaban Anda (Kesempatan " + questionAttempts + ", Total: " + remainingAttempts + "): ");
                String userAnswer = scanner.nextLine().trim().toLowerCase();

                if (userAnswer.equals(currentTebakan.jawaban)) {
                    System.out.println("\u2714 Benar!");
                    user.score += 10;
                    answeredCorrectly++;
                    questionAnswered = true;
                    break;
                } else {
                    System.out.println("\u274C Salah!");
                    questionAttempts--;
                    remainingAttempts--;
                }
            }

            if (!questionAnswered) {
                System.out.println("\nJawaban yang benar: " + currentTebakan.jawaban);
            }

            System.out.println("\n----------------------------------------------------------------------------------\n");

            // Hentikan permainan jika kesempatan habis
            if (remainingAttempts <= 0) {
                break;
            }
        }

        // Evaluasi hasil permainan
        if (remainingAttempts > 0 && answeredCorrectly > 0) {
            System.out.println("\u2728 Selamat! Anda menjawab " + answeredCorrectly + " dari " + totalQuestions + " pertanyaan.");

            // Lanjut ke level berikutnya
            if (currentLevel.equals("Easy") && answeredCorrectly == totalQuestions) {
                initializeLevels("Medium");
                System.out.println("\n\u2728 Anda lanjut ke level Medium!");
                Helper.pressEnterKeyToContinue();
                startGame(user);
            } else if (currentLevel.equals("Medium") && answeredCorrectly == totalQuestions) {
                initializeLevels("Hard");
                System.out.println("\n\u2728 Anda lanjut ke level Hard!");
                Helper.pressEnterKeyToContinue();
                startGame(user);
            } else {
                System.out.println("\n❌ Anda belum bisa melanjutkan level.");
            }
        } else {
            System.out.println("\u2620 Game over. Kesempatan habis.");
        }

        System.out.println("Skor Anda: " + user.score);
        Helper.pressEnterKeyToContinue();
        Helper.clearScreen();
    }
}
