package com.example.emaillistview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emails = listOf(
            EmailModel("Edurila.com", "$19 Only (First 10 spots)", "Are you looking to Learn Web", "12:34 AM", "#0000FF"),
            EmailModel("Chris Abad", "Help make Campaign Monitor better", "Let us know your thoughts", "11:22 PM", "#00AAFF"),
            EmailModel("Tuto.com", "8h de formation gratuite et les nouvea", "Photoshop, SEO, Blender, CSS, ...", "11:04 PM", "#00AAFF"),
            EmailModel("support", "Societe Ovh: suive de vos services - hp", "SAS OVH - http://www.ovh.com 2 rue ", "10:26 AM", "#00BBCC"),
            EmailModel("Matt from Ionic", "The New Ionic Creator Is Here!", "Announcing the all-new Creator", "10:00 AM", "#00DDFF"),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(emails)

    }
}