package com.example.dailyobject.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

data class Product(val title: String)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_submit.setOnClickListener {
            list_recycler_view.apply {
                val layoutManager = GridLayoutManager(this@MainActivity, 2)
                list_recycler_view.layoutManager = layoutManager
                adapter = ListAdapter(generateData())
            }
        }
    }

    private fun generateData(): ArrayList<Product> {
        var result = ArrayList<Product>()
        var position = 0
        if (et_number.text.toString() == "") {
            position = 10
        } else {
            position = Integer.parseInt(et_number.text.toString())
        }

        for (i in 0..position - 1) {
            var user: Product = Product("Product $i")
            result.add(user)
        }
        return result
    }

}
