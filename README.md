# Soal Latihan Studi Kasus Java

## 1. **ArrayList** – Manajemen Data Mahasiswa
Buat program untuk mengelola data mahasiswa dengan **ArrayList**.
- Setiap mahasiswa memiliki `NIM`, `Nama`, dan `IPK`.
- Program harus memiliki menu:
    - Tambah mahasiswa
    - Hapus mahasiswa berdasarkan `NIM`
    - Tampilkan seluruh data mahasiswa
    - Cari mahasiswa berdasarkan NIM
Gunakan **ArrayList** untuk menyimpan objek mahasiswa.

---

## 2. **HashSet** – Daftar Nama Unik
Buat program yang menerima input nama peserta seminar.
- Nama disimpan dalam **HashSet** agar tidak ada data duplikat.
- Menu:
    - Tambah peserta
    - Hapus peserta
    - Tampilkan seluruh peserta
Coba masukkan nama ganda untuk membuktikan bahwa **HashSet** hanya menyimpan data unik.

---

## 3. **HashMap** – Sistem Login Sederhana
Buat program login sederhana dengan **HashMap**.
- Key: `username`, Value: `password`.
- Program harus:
    - Menambahkan akun baru
    - Login dengan **username** dan **password**
    - Menampilkan semua akun (untuk admin)
- Jika login berhasil, tampilkan pesan selamat datang.
- Jika gagal, tampilkan pesan error.

---

## 4. **LinkedList** – Antrian Tiket Bioskop
Buat program simulasi **antrian pembelian tiket bioskop** dengan **LinkedList**.
- Fitur:
    Tambah orang ke dalam antrian
    Layani orang pertama dalam antrian
    Lihat daftar antrian saat ini
- Gunakan **LinkedList** sebagai queue (`offer()`, `poll()`).

---

## 5. **Socket & ServerSocket** – Chat Sederhana
Buat aplikasi **chat sederhana** dengan **Socket** dan **ServerSocket**.
- **Server** berjalan di port tertentu dan menunggu koneksi.
- **Client** bisa terhubung ke server dan mengirim pesan.
- Saat **client** mengirim pesan, server menampilkannya di console.
- Server dapat mengirim balasan ke **client**.

**Bonus:**

Kembangkan **agar bisa banyak client** terhubung ke satu server menggunakan **multi-threading**.

---

## Operasi Dasar Struktur Data Java

## 1. ArrayList
| Operasi         | Deskripsi                      | Contoh Kode           |
|-----------------|--------------------------------|-----------------------|
| `add(E e)`      | Tambah elemen ke akhir list    | `list.add("Andi");`   |
| `get(int i)`    | Ambil elemen berdasarkan index | `list.get(0);`        |
| `set(int i, E)` | Ubah elemen pada index tertentu| `list.set(1,"Budi");` |
| `remove(int i)` | Hapus elemen pada index        | `list.remove(0);`     |
| `size()`        | Hitung jumlah elemen           | `list.size();`        |
| `contains(o)`   | Cek apakah elemen ada          | `list.contains("A");` |

---

## 2. HashSet
| Operasi        | Deskripsi                   | Contoh Kode             |
|----------------|-----------------------------|-------------------------|
| `add(E e)`     | Tambah elemen (unik)        | `set.add("Andi");`      |
| `remove(o)`    | Hapus elemen                | `set.remove("Andi");`   |
| `contains(o)`  | Cek apakah elemen ada       | `set.contains("Budi");` |
| `size()`       | Hitung jumlah elemen        | `set.size();`           |

---

## 3. HashMap
| Operasi             | Deskripsi                             | Contoh Kode                      |
|----------------------|---------------------------------------|---------------------------------|
| `put(K,V)`           | Tambah/ubah pasangan key-value        | `map.put("user1","123");`       |
| `get(key)`           | Ambil value berdasarkan key           | `map.get("user1");`             |
| `remove(key)`        | Hapus pasangan key-value              | `map.remove("user1");`          |
| `containsKey(k)`     | Cek apakah key ada                    | `map.containsKey("user1");`     |
| `containsValue(v)`   | Cek apakah value ada                  | `map.containsValue("123");`     |
| `keySet()`           | Ambil semua key                      | `map.keySet();`                  |
| `values()`           | Ambil semua value                    | `map.values();`                  |

---

## 4. LinkedList
| Operasi              | Deskripsi                            | Contoh Kode                |
|-----------------------|--------------------------------------|---------------------------|
| `add(E e)`            | Tambah elemen di akhir               | `queue.add("Andi");`      |
| `addFirst(e)`         | Tambah elemen di depan               | `queue.addFirst("A");`    |
| `addLast(e)`          | Tambah elemen di belakang            | `queue.addLast("B");`     |
| `remove()`            | Hapus elemen pertama                 | `queue.remove();`         |
| `removeFirst()`       | Hapus elemen pertama                 | `queue.removeFirst();`    |
| `removeLast()`        | Hapus elemen terakhir                | `queue.removeLast();`     |
| `getFirst()`          | Ambil elemen pertama                 | `queue.getFirst();`       |
| `getLast()`           | Ambil elemen terakhir                | `queue.getLast();`        |
| `offer(e)`            | Tambah elemen (mode queue)           | `queue.offer("C");`       |
| `poll()`              | Ambil & hapus elemen pertama (queue) | `queue.poll();`           |

---
