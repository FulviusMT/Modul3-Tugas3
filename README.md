# Program Rental PC

Program sederhana untuk mengelola rental PC. Program ini memungkinkan pengguna untuk melihat daftar PC, menyewa, dan mengembalikan PC melalui antarmuka konsol.

## Fitur

- **Lihat Daftar PC**: Menampilkan semua PC beserta statusnya (tersedia atau disewa).
- **Sewa PC**: Menyewa PC tertentu berdasarkan ID.
- **Kembalikan PC**: Mengembalikan PC yang sudah disewa.
- **Keluar**: Keluar dari program.

## Struktur Kelas

1. **PC**: Representasi PC dengan ID dan status sewa.
    - `getStatus()`: Menampilkan status PC (tersedia/disewa).
2. **SistemRental**: Mengelola daftar PC dan menyediakan fungsi sewa dan kembalikan.
3. **RentalPC**: Program utama yang menampilkan menu dan menerima input pengguna.

## Cara Menjalankan

1. Kompilasi program:
   ```bash
   java RentalPC
