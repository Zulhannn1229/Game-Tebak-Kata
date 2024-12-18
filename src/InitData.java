public class InitData {
    static class Tebak {
        String jawaban;
        String pertanyaan;
        String petunjuk;

        public Tebak(String jawaban, String pertanyaan, String petunjuk) {
            this.jawaban = jawaban;
            this.pertanyaan = pertanyaan;
            this.petunjuk = petunjuk;
        }

        @Override
        public String toString() {
            return "Pertanyaan: " + pertanyaan + "\nPetunjuk: " + petunjuk;
        }
    }

    public static Tebak[] initEasy() {
        return new Tebak[] {
            new Tebak("usia", "Siapakah yang selalu berada di depan tetapi tidak bisa kamu kejar?", "Aku bertambah setiap tahun"),
            new Tebak("jarum", "Apa yang memiliki mata tetapi tidak bisa melihat?", "Aku sering digunakan dalam menjahit")
        };
    }

    public static Tebak[] initMedium() {
        return new Tebak[] {
            new Tebak("piramid", "Bangunan segitiga kuno di Mesir", "Aku terletak di Giza"),
            new Tebak("mimpi", "Berjalan tanpa kaki, terbang tanpa sayap, dan merasa tanpa tangan", "Aku hanya ada ketika tidur")
        };
    }

    public static Tebak[] initHard() {
        return new Tebak[] {
            new Tebak("matahari", "Aku menerangi dunia tetapi tidak bisa disentuh", "Aku adalah bintang terdekat ke Bumi"),
            new Tebak("langit", "Aku berada di atas kepala tetapi tidak bisa disentuh", "Aku berwarna biru di siang hari")
        };
    }
}
