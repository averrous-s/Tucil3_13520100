# Tugas Kecil III - Strategi Algoritma
Program adalah penyelesaian dari 15-Puzzle dengan algoritma Branch and Bound. Bahasa yang digunakan adalah java.
## Hal dasar yang perlu dimiliki
Untuk dapat mengompilasi dan menjalankan program diperlukan `jdk-17` dengan `java-8` 
## Cara mengompilasi
1. Pastikan berada di direktori teratas
2. Jika file `sources.txt` tidak ada, lakukan pemetaan file java dengan
    - pada windows, `dir /s /B *.java > sources.txt` pada cmd
    - pada linux/macOS, `find -name "*.java" > sources.txt` pada terminal
3. Lakukan proses kompilasi dengan `javac -d bin @sources.txt` pada cmd/terminal
4. File binary berbentuk *.class akan tersimpan pada folder bin
## Cara menjalankan program
1. Masuk ke direktori `bin`
2. Jalankan `java Program`
3. Masukkan puzzle, untuk merepresentasikan ubin kosong, masukkan ` ` (spasi) atau `?` (tanda tanya). Setiap elemen dipisah satu spasi.
4. Jika dapat diselesaikan, akan muncul `Solving...` pada terminal, dan penyelesaian bisa memakan waktu yang lama.
## Pembuat
| Nama      | NIM |
| ----------- | ----------- |
| Averrous Saloom      | 13520100       |