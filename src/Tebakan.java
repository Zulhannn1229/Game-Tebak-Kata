// Tebakan.java
public class Tebakan {
    static class DataTebakan {
        String jawaban;
        String pertanyaan;
        String petunjuk;

        public DataTebakan(String jawaban, String pertanyaan, String petunjuk) {
            this.jawaban = jawaban;
            this.pertanyaan = pertanyaan;
            this.petunjuk = petunjuk;
        }
    }

    public static DataTebakan[] EasyLevel() {
        return new DataTebakan[] {
            new DataTebakan("usia", "Siapakah yang selalu berada di depan tetapi tidak bisa kamu kejar", "Aku bertambah setiap tahun"),
            new DataTebakan("jarum", "Apa yang memiliki mata tetapi tidak bisa melihat", "Aku sering digunakan dalam menjahit"),
            new DataTebakan("pintu", "Berada di dalam dan di luar, namun aku tidak pernah bergerak", "Aku bisa terbuka dan tertutup"),
            new DataTebakan("kunci", "Aku bisa membuka tetapi tidak punya tangan, aku apa?", "Aku sering dipasangkan dengan gembok"),
            new DataTebakan("waktu", "Selalu bergerak maju tapi tidak pernah kembali, apakah aku?", "Aku tidak terlihat tetapi selalu ada"),
            new DataTebakan("bayangan", "Aku mengikutimu ke mana pun kamu pergi, tetapi aku tidak bisa disentuh", "Aku muncul ketika ada cahaya"),
            new DataTebakan("pulpen", "Aku bisa menulis tetapi tidak memiliki otak", "Aku sering digunakan untuk mencatat"),
            new DataTebakan("teka-teki", "Aku membuatmu berpikir tetapi tidak bisa berbicara", "Aku sering ada di buku atau permainan"),
            new DataTebakan("gigi", "Aku berada di dalam mulut tetapi tidak bisa berbicara", "Aku digunakan untuk mengunyah makanan"),
            new DataTebakan("sepatu", "Aku selalu berjalan tetapi tidak punya kaki", "Aku dipakai di kaki"),
            new DataTebakan("angin", "Aku bisa dirasakan tetapi tidak bisa dilihat", "Aku bergerak di udara")
        };
    }

    public static DataTebakan[] MediumLevel() {
        return new DataTebakan[] {
            new DataTebakan("piramid", "Bangunan segitiga kuno di Mesir", "Aku terletak di Giza"),
            new DataTebakan("mimpi", "Berjalan tanpa kaki, terbang tanpa sayap, dan merasa tanpa tangan", "Aku hanya ada ketika tidur"),
            new DataTebakan("jembatan", "Aku bisa menghubungkan dua tempat tetapi tidak bisa bergerak", "Aku sering ditemukan di atas sungai"),
            new DataTebakan("komputer", "Aku bisa memproses informasi tetapi tidak punya otak", "Aku sering digunakan untuk bekerja atau bermain"),
            new DataTebakan("cermin", "Aku bisa memantulkan gambar tetapi tidak punya pikiran", "Aku transparan dan rapuh"),
            new DataTebakan("api", "Aku bisa menghangatkan tetapi juga bisa membakar", "Aku berwarna merah dan oranye")
        };
    }

    public static DataTebakan[] HardLevel() {
        return new DataTebakan[] {
            new DataTebakan("matahari", "Aku menerangi dunia tetapi tidak bisa disentuh", "Aku adalah bintang terdekat ke Bumi"),
            new DataTebakan("langit", "Aku berada di atas kepala tetapi tidak bisa disentuh", "Aku berwarna biru di siang hari"),
            new DataTebakan("bulan", "Aku muncul di malam hari tetapi tidak bersinar sendiri", "Aku mengelilingi planet kita"),
            new DataTebakan("bintang", "Aku bersinar di malam hari tetapi tidak bisa dijangkau", "Aku jauh di luar angkasa"),
            new DataTebakan("awan", "Aku bisa membawa hujan tetapi tidak bisa ditangkap", "Aku terbuat dari butiran air"),
            new DataTebakan("hujan", "Aku jatuh dari langit tetapi tidak terluka", "Aku basah dan bisa membasahi bumi"),
            new DataTebakan("salju", "Aku putih dan dingin tetapi bisa mencair", "Aku turun di musim dingin"),
            new DataTebakan("laut", "Aku besar dan biru tetapi tidak bisa diminum", "Aku rumah bagi banyak makhluk laut"),
            new DataTebakan("ikan", "Aku hidup di air tetapi tidak bisa bernapas di udara", "Aku sering ditangkap oleh nelayan"),
            new DataTebakan("pohon", "Aku berdiri tegak tetapi tidak bisa berjalan", "Aku memiliki batang, ranting, dan daun"),
            new DataTebakan("bunga", "Aku indah tetapi tidak bisa berbicara", "Aku sering diberi sebagai hadiah")
        };
    }
}
