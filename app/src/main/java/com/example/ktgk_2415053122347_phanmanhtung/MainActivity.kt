package com.example.ktgk_2415053122347_phanmanhtung

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_2415053122347_phanmanhtung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding347: ActivityMainBinding
    private var tenKhoanChi347 =""
    private var soTien347 =0.0
    private var ghiChu347 =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding347 = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        supportActionBar?.title = "Phan Mạnh Tùng - 2415053122347"
        setContentView(binding347.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding347.btnThem347.setOnClickListener {
            with(binding347){
                tenKhoanChi347 = edtTenKhoanChi347.text.trim().toString()
                soTien347 = edtSoTien347.text.toString().toDoubleOrNull()?:-1.0
                ghiChu347 = edtGhiChu347.text.toString().trim()
            }
            if (ktradulieu()== true){
                Toast.makeText(this, "Them du lieu thanh cong", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Vui long kiem tra du lieu", Toast.LENGTH_SHORT).show()
                binding347.edtTenKhoanChi347.isFocusable
            }
        }
        binding347.btnXemChiTiet347.setOnClickListener {
            if (ktradulieu() == false){
                Toast.makeText(this, "Vui long them khaonc hi hop le truoc khi xem chi tiet", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Mo man hinh chi tiet", Toast.LENGTH_SHORT).show()
                var intent= Intent(this, ChiTietChiTieu::class.java).apply {
                    putExtra("TENKHOANCHI",tenKhoanChi347)
                    putExtra("GHICHU",ghiChu347)
                    putExtra("SOTIEN",soTien347)
                }
                startActivity(intent)
            }
        }
    }
    fun ktradulieu(): Boolean{
        if (tenKhoanChi347.isBlank())
        {
            binding347.edtTenKhoanChi347.error = "Vui long nhap ten khoanc hi hop le"
            return false
        }
        else if (soTien347.isInfinite() || soTien347 <= 0)
        {
            binding347.edtSoTien347.error ="Vui long nhap so tien hop le"
            return false
        }
        return true
    }
}