package com.example.bookflip

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.link.DefaultLinkHandler
import com.github.barteksc.pdfviewer.util.FitPolicy

class PdfActivity : AppCompatActivity() {

    lateinit var pdfview :PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

        pdfview=findViewById(R.id.pdfView)
        pdfview.fromAsset("Habits.pdf").load();

    }
}