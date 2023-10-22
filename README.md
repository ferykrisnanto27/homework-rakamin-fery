# homework-rakamin-fery
Tugas Homework 6 Bootcamp SQA Rakamin Academy

Berikut ini adalah file pengerjaan homework pembuatan automated testing untuk website saucedemo.com
File dapat dilihat pada folder cucumber, yang dikelompokkan ke tiga folder berdasarkan kegunaannya, yaitu features (mendefinisikan proses BDD dengan bahasa gherkin), stepDef (menuliskan kode automated testing berdasarkan langkah BDD) serta runner (untuk menjalankan proses otomatisasi testing).

Ada 4 fitur yang saya cek pada kode berikut ini :
1. Fitur Login
   a. Positive case >> memasukkan data username dan password yang sesuai
   b. Negative case >> memasukkan data username atau password yang tidak sesuai
2. Fitur Menambahkan Barang ke Keranjang (klik button "add to cart")
3. Fitur Halaman Keranjang (klik button "cart icon" untuk redirect ke halaman keranjang)
4. Fitur Klik Checkout dari halaman keranjang
   a. Positive case >> checkout dengan keadaan ada item di keranjang
   b. Negative case >> checkout dengan keadaan tidak ada item di keranjang

CATATAN : Dalam eksekusi automated testing ini, untuk negative test "klik checkout" menghasilkan hasil yang gagal, karena dari web saucedemo.com sendiri tidak menyediakan respons negative untuk kasus ini. Sehingga negative test untuk kasus ini tidak bisa diuji.
