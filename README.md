# Tugas Besar 1 IF3210 Pengembangan Aplikasi pada Platform Khusus
### Anggota Kelompok
1. Moses Ananta (13519076)
2. Nabelanita Utami (13519104)
3. Daffa Ananda Pratama Resyaly (13519107)

### Deskripsi Aplikasi
Aplikasi perlu dilindungi merupakan aplikasi pembantu dalam menghadapi situasi pandemi Covid-19. Aplikasi ini memiliki 4 fitur utama antara lain fitur berita berhubungan dengan Covid-19, fitur pencarian faskes, fitur bookmark, dan fitur scanning untuk keperluan check-in

### Cara Kerja Aplikasi

### Fitur Berita
Untuk menggunakan fitur berita, pengguna cukup menekan "News" pada navigation bar pada bagian bawah aplikasi. Pada halaman awal berita, terdapat berbagai pilihan berita yang dapat dipilih. Pemilihan satu berita akan membawa aplikasi ke halaman baru yang membuka laman web di dalam aplikasi. Pengguna bisa kembali ke halaman awal dengan menekan tombol kembali di sisi kiri atas aplikasi.

### Fitur Faskes
Untuk menggunakan fitur faskes, pengguna harus terlebih dahulu memilih daerah faskes yang ingin dicari. Setelah memilih, pengguna bisa menekan tombol “Search” untuk menampilkan faskes yang ada pada daerah tersebut. Apabila pengguna menekan salah satu faskes yang ditampilkan, aplikasi akan mengarahkan pengguna ke sebuah halaman baru yang berisi informasi faskes tersebut secara lebih detail, termasuk status vaksinasi dari faskes. Pengguna dapat melihat lokasi faskes di aplikasi Google Maps dengan menekan tombol “Google Maps” atau menambahkan faskes ke bookmark dengan menekan tombol “Bookmark”.

### Fitur Bookmark
Bookmark akan menunjukan fakses-fakses yang telah di”bookmark” oleh pengguna. Ketika pengguna menekan salah satu dari fakses itu, pengguna akan diarahkan ke halaman detail fakses di mana tertera informasi fakses dan juga tombol “UnBookmark” untuk menghapus bookmark yang telah dibuat

### Fitur Check-In
Untuk menggunakan fitur Check-in, pengguna harus terlebih dahulu menekan tombol QR di bawah kanan layar. Pengguna kemudian akan diarahkan ke layar check-in untuk dimana terdapat temperatur yang menunjukan temperatur lingkungan pengguna  dan qr code scanner dimana ketika diarahkan ke sebuah QR Code akan memberikan response dari QR code tersebut yaitu berhasil atau gagal


### Library 
Material : untuk pembuatan Bottom Navigation
Retrofit : untuk melakukan REST request dengan API
Lifecycle : untuk pembuatan View Model dan Live Data
Room : untuk menyimpan bookmark ke database sqlite local
Play-service-maps : untuk menggunakan google service maps
Play-service-location: untuk mendapatkan lokasi pengguna saat ini
Code-scanner : untuk pembuatan QR Code Scanner

### Pembagian Kerja
1. Moses Ananta (13519076) -  Fitur Faskes, Fitur Bookmark
2. Nabelanita Utami (13519104) - Fitur Berita
3. Daffa Ananda Pratama Resyaly (13519107) - Fitur Check-In






