package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010272

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010272.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ View bằng findViewById đúng yêu cầu đề bài
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // 1. Kiểm tra dữ liệu trống
            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.text = "Email and Password cannot be blank!"
            }
            // 2. Kiểm tra định dạng email hoặc mật khẩu dưới 6 ký tự
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || password.length < 6) {
                tvStatus.text = "Invalid email format or Password < 6 characters!"
            }
            // 3. Dữ liệu hoàn toàn hợp lệ
            else {
                tvStatus.text = "Validation Successful!"
            }
        }
    }
}