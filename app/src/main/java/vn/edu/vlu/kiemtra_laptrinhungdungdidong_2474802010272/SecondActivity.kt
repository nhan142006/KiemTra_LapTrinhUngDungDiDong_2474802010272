package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010272

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 1. Ánh xạ View bằng findViewById đúng yêu cầu đề bài
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val lvSubjects = findViewById<ListView>(R.id.lvSubjects)

        // 2. Nhận dữ liệu Email được truyền qua Intent từ MainActivity (Câu 2)
        val email = intent.getStringExtra("USER_EMAIL")
        if (email != null) {
            tvUserEmail.text = "Email: $email"
        }

        // 3. Xử lý sự kiện click nút Log Out: gọi finish() để đóng màn hình và quay về Login (Câu 2)
        btnLogout.setOnClickListener {
            finish()
        }

        // 4. Khởi tạo mảng dữ liệu gồm ít nhất 05 môn học/kỹ năng (Câu 3)
        val subjects = arrayOf(
            "Kotlin Programming",
            "XML Layout Design",
            "Git/GitHub Management",
            "Intent Processing",
            "Android Architecture"
        )

        // 5. Gắn ArrayAdapter sử dụng layout hệ thống đơn giản (Câu 3)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // 6. Bắt sự kiện click vào từng item trong ListView để hiện Toast (Câu 3)
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            val selectedSubject = subjects[position]
            Toast.makeText(this, selectedSubject, Toast.LENGTH_SHORT).show()
        }
    }
}