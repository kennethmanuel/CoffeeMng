package com.bodyflicker.a160419041_coffeemng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_confirm.*
import kotlinx.android.synthetic.main.activity_main.*

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        val coffee = intent.getStringExtra(Global.COFFEE_TYPE)
        val queue = intent.getIntExtra(Global.QUEUE, 0)
        val price = intent.getIntExtra(Global.COFFEE_PRICE, 0)
        val extra = intent.getStringExtra(Global.COFFEE_EXTRA)

        textViewQueue.text = queue.toString()
        textViewCofeeExtra.text = extra.toString()
        textViewCofee.text = coffee.toString()
        textViewConfirmPrice.text = "Rp. ${price}"
        Toast.makeText(this, price.toString(), Toast.LENGTH_SHORT).show()

        buttonOrderAnother.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}