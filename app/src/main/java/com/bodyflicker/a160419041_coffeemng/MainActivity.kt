package com.bodyflicker.a160419041_coffeemng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var coffeePrice = 20000
        var coffeeType = "Cappuccino"
        var coffeeSyrup = ""
        var coffeeExtra = ""

        fun UpdateTextViewPrice() {
            textViewPrice.text = "Rp. ${coffeePrice}"
        }

        Global.queue++
        UpdateTextViewPrice()

        // Hide syrup flavour control
        textViewSyrupFlavour.visibility = View.INVISIBLE
        radioGroupSyrup.visibility = View.INVISIBLE

        // populate spinner and use custom layout spinner with adapter
        val adapter = ArrayAdapter(this, R.layout.coffeespinner_layout, Global.coffee_types)
        adapter.setDropDownViewResource(R.layout.coffeespinner_item_layout)
        spinnerCoffeeType.adapter = adapter

        checkBoxSyrup.setOnClickListener {
            // toggle show / hide syrup flavour control
            if (radioGroupSyrup.visibility == View.VISIBLE) {
                textViewSyrupFlavour.visibility = View.INVISIBLE
                radioGroupSyrup.visibility = View.INVISIBLE
                radioGroupSyrup.clearCheck()
            } else {
                textViewSyrupFlavour.visibility = View.VISIBLE
                radioGroupSyrup.visibility = View.VISIBLE
                radioGroupSyrup.clearCheck()
            }

            // toggle price
            if(checkBoxSyrup.isChecked) coffeePrice+=5000
            else coffeePrice -= 5000
            UpdateTextViewPrice()
        }

        checkBoxMilk.setOnClickListener{
            if(checkBoxMilk.isChecked) coffeePrice+=5000
            else coffeePrice -= 5000
            UpdateTextViewPrice()
        }

        checkBoxCoffee.setOnClickListener{
            if(checkBoxCoffee.isChecked) coffeePrice+=5000
            else coffeePrice -= 5000
            UpdateTextViewPrice()
        }

        buttonConfirm.setOnClickListener {
            coffeeType = spinnerCoffeeType.selectedItem.toString()
            if(checkBoxSyrup.isChecked) {
                coffeeSyrup = (radioGroupSyrup.children.find { (it as RadioButton).isChecked } as RadioButton).text.toString()
                coffeeExtra += checkBoxCoffee.text.toString() + "\n"
            }
            if(checkBoxCoffee.isChecked) coffeeExtra += checkBoxSyrup.text.toString() + "\n"
            if(checkBoxMilk.isChecked) coffeeExtra += checkBoxMilk.text.toString() + "\n"

            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra(Global.COFFEE_TYPE, coffeeType)
            intent.putExtra(Global.QUEUE, Global.queue)
            intent.putExtra(Global.COFFEE_SYRUP, coffeeSyrup)
            intent.putExtra(Global.COFFEE_PRICE, coffeePrice)
            intent.putExtra(Global.COFFEE_EXTRA, coffeeExtra)
            startActivity(intent)
        }
    }
}