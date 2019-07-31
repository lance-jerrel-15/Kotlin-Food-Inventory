package com.example.foods

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.util.Log
import android.view.View
import Adapter.Adapter
import Model.Fooditem
import Adapter.RecyclerAdapter
import Adapter.RecyclerAdapter.Companion.mImagenames
import Model.Foods

import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.widget.Toolbar
import java.util.*


class MainActivity<T> : AppCompatActivity() {

    var FoodList: ArrayList<Fooditem>? = null
    var mAdapter: Adapter? = null
    var clickedfoodName: String? = null
    var RAAdapter: RecyclerAdapter? = null

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.getItemId() == R.id.item_delete) {
            RecyclerAdapter.updateAdapter(selection_list)
            count = 0
            initRecyclerView()
        }else{
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_action_mode,menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate started,")
        val toolbar = findViewById<View>(R.id.toolbar)
        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        categoryList()

        val spinnerfoods = findViewById<Spinner>(R.id.spinner_foods)
        mAdapter = FoodList?.let { Adapter(this, it) }
        spinnerfoods.adapter = mAdapter
        spinnerfoods.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val clickedItem = parent.getItemAtPosition(position) as Fooditem
                clickedfoodName = clickedItem.foodname
                Toast.makeText(this@MainActivity, clickedfoodName!! + " Selected", Toast.LENGTH_SHORT).show()
                when (clickedfoodName) {
                    "Junk Foods" -> {
                        junkfoodslist()
                        initRecyclerView()
                    }
                    "Vegetables" -> {
                        vegetableslist()
                        initRecyclerView()
                    }
                    "Fruits" -> {
                        fruitslist()
                        initRecyclerView()
                    }
                    else -> {
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        val Addbutton = findViewById<Button>(R.id.addbutton)
        Addbutton.setOnClickListener {
            if (clickedfoodName === "Junk Foods") {
                foods!!.add(Foods(R.drawable.chocolate, "Chocolate"))
                initRecyclerView()
                Toast.makeText(this@MainActivity, "Updated! Chocolate Added", Toast.LENGTH_SHORT).show()
                count = 0

            } else if (clickedfoodName === "Vegetables") {
                foods!!.add(Foods(R.drawable.okra, "Okra"))
                initRecyclerView()
                Toast.makeText(this@MainActivity, "Updated! Okra Added", Toast.LENGTH_SHORT).show()
                count = 0

            } else if (clickedfoodName === "Fruits") {
                foods!!.add(Foods(R.drawable.pineapple, "PineApple"))
                initRecyclerView()
                Toast.makeText(this@MainActivity, "Updated! PineApple Added", Toast.LENGTH_SHORT).show()
                count = 0
            } else {
            }
        }
    }

        private fun categoryList() {
            FoodList = ArrayList()
            FoodList!!.add(Fooditem("Vegetables", R.drawable.vegetables))
            FoodList!!.add(Fooditem("Fruits", R.drawable.fruits))
            FoodList!!.add(Fooditem("Junk Foods", R.drawable.junkfood))
        }

        fun initRecyclerView() {
            Log.d(TAG, "initRecyclerView: init recyclerview.")
            val recycler_views = findViewById<RecyclerView>(R.id.recycle_view)
            //val adapter = RecyclerAdapter(this, mImagenames, mImage)
            RAAdapter = foods?.let {RecyclerAdapter(this, it) }
            recycler_views.adapter = RAAdapter
            recycler_views.layoutManager = LinearLayoutManager(this)
        }

        private fun junkfoodslist() {
            foods = ArrayList()
            foods!!.add(Foods(R.drawable.burger,"Burger"))
            foods!!.add(Foods(R.drawable.pizza,"Pizza"))
            foods!!.add(Foods(R.drawable.fries,"Fries"))
            foods!!.add(Foods(R.drawable.snacks,"snacks"))
        }

        private fun vegetableslist() {
            foods = ArrayList()
            foods!!.add(Foods(R.drawable.carrot,"Carrot"))
            foods!!.add(Foods(R.drawable.cabbage,"Cabbage"))
            foods!!.add(Foods(R.drawable.potatoes,"Potatoes"))
            foods!!.add(Foods(R.drawable.eggplant,"Eggplant"))
        }

        private fun fruitslist() {
            foods = ArrayList()
            foods!!.add(Foods(R.drawable.orange,"Orange"))
            foods!!.add(Foods(R.drawable.grapes,"Grapes"))
            foods!!.add(Foods(R.drawable.apple,"Apple"))
            foods!!.add(Foods(R.drawable.banana,"Banana"))
        }

        companion object {

            var foods: ArrayList<Foods>? = null
            var selection_list = ArrayList<Foods>()
            var count = 0
            private val TAG = "MainActivity"

        }
}





