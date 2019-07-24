package com.example.foods

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import java.util.ArrayList
import Adapter.Adapter
import Model.Fooditem
import Adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var mImagenames = ArrayList<String>()
    var mImage = ArrayList<Int>()

    var FoodList: ArrayList<Fooditem>? = null
    var mAdapter: Adapter? = null
    var clickedfoodName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate started,")

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
                        deletebutton.isEnabled = false
                    }
                    "Vegetables" -> {
                        vegetableslist()
                        initRecyclerView()
                        deletebutton.isEnabled = false
                    }
                    "Fruits" -> {
                        fruitslist()
                        initRecyclerView()
                        deletebutton.isEnabled = false
                    }
                    else -> {
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


        val deletebutton = findViewById<Button>(R.id.deletebutton)
        deletebutton.isEnabled = false
        val Addbutton = findViewById<Button>(R.id.addbutton)
        Addbutton.setOnClickListener {
            if (clickedfoodName === "Junk Foods") {
                mImagenames.add("Chocolate")
                mImage.add(R.drawable.chocolate)
                initRecyclerView()
                Toast.makeText(this@MainActivity, "Updated! Chocolate Added", Toast.LENGTH_SHORT).show()
                deletebutton.isEnabled = true
            } else if (clickedfoodName === "Vegetables") {
                mImagenames.add("Okra")
                mImage.add(R.drawable.okra)
                initRecyclerView()
                Toast.makeText(this@MainActivity, "Updated! Okra Added", Toast.LENGTH_SHORT).show()
                deletebutton.isEnabled = true
            } else if (clickedfoodName === "Fruits") {
                mImagenames.add("PineApple")
                mImage.add(R.drawable.pineapple)
                initRecyclerView()
                Toast.makeText(this@MainActivity, "Updated! PineApple Added", Toast.LENGTH_SHORT).show()
                deletebutton.isEnabled = true
            } else {
            }
        }

        deletebutton.setOnClickListener {
            val junk = mImagenames.contains("Chocolate")
            val vege = mImagenames.contains("Okra")
            val frui = mImagenames.contains("PineApple")

            if (clickedfoodName === "Junk Foods") {
                if (junk) {
                    mImagenames.remove("Chocolate")
                    mImage.remove(5)
                    initRecyclerView()
                    Toast.makeText(this@MainActivity, "Chocolate Deleted", Toast.LENGTH_SHORT).show()
                } else {
                    deletebutton.isEnabled = false
                    Toast.makeText(this@MainActivity, "No Item Deleted", Toast.LENGTH_SHORT).show()
                }
            }

            if (clickedfoodName === "Vegetables") {
                if (vege) {
                    mImagenames.remove("Okra")
                    mImage.remove(5)
                    initRecyclerView()
                    Toast.makeText(this@MainActivity, "Okra Deleted", Toast.LENGTH_SHORT).show()
                } else {
                    deletebutton.isEnabled = false
                    Toast.makeText(this@MainActivity, "No Item Deleted", Toast.LENGTH_SHORT).show()
                }
            }

            if (clickedfoodName === "Fruits") {
                if (frui) {
                    mImagenames.remove("PineApple")
                    mImage.remove(5)
                    initRecyclerView()
                    Toast.makeText(this@MainActivity, "PineApple Deleted", Toast.LENGTH_SHORT).show()
                } else {
                    deletebutton.isEnabled = false
                    Toast.makeText(this@MainActivity, "No Item Deleted", Toast.LENGTH_SHORT).show()
                }
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
        val adapter = RecyclerAdapter(this, mImagenames, mImage)
        recycler_views.adapter = adapter
        recycler_views.layoutManager = LinearLayoutManager(this)
    }

    fun junkfoodslist() {
        mImage = ArrayList()
        mImagenames = ArrayList()

        mImagenames.add("Burger")
        mImage.add(R.drawable.burger)

        mImagenames.add("Pizza")
        mImage.add(R.drawable.pizza)

        mImagenames.add("Fries")
        mImage.add(R.drawable.fries)

        mImagenames.add("Snacks")
        mImage.add(R.drawable.snacks)
    }


    fun vegetableslist() {
        mImage = ArrayList()
        mImagenames = ArrayList()

        mImagenames.add("Carrot")
        mImage.add(R.drawable.carrot)

        mImagenames.add("Cabbage")
        mImage.add(R.drawable.cabbage)

        mImagenames.add("Potatoes")
        mImage.add(R.drawable.potatoes)

        mImagenames.add("Eggplant")
        mImage.add(R.drawable.eggplant)
    }

    fun fruitslist() {
        mImage = ArrayList()
        mImagenames = ArrayList()

        mImagenames.add("Orange")
        mImage.add(R.drawable.orange)

        mImagenames.add("Grapes")
        mImage.add(R.drawable.grapes)

        mImagenames.add("Apple")
        mImage.add(R.drawable.apple)

        mImagenames.add("Banana")
        mImage.add(R.drawable.banana)
    }

    companion object {
        private val TAG = "MainActivity"
    }

}