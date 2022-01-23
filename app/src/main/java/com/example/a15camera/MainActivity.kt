package com.example.a15camera
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1
    lateinit var  imageRecyclerView: RecyclerView
    val image = mutableListOf<Bitmap>()
    val adapter = Adapter(image)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageRecyclerView = findViewById(R.id.imageRecycleView)
        val layoutManager = LinearLayoutManager(this)

        imageRecyclerView.layoutManager = layoutManager
        imageRecyclerView.adapter = adapter

        findViewById<Button>(R.id.button).setOnClickListener {
            try {
                startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this,"Camera is not availabe!",Toast.LENGTH_LONG ).show()
            }}
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1&&resultCode== RESULT_OK)
        {
            val bitmap = data!!.extras!!.get("data") as Bitmap
            image.add(bitmap)
            adapter.notifyItemInserted(image.size - 1)
        }
    }
}
