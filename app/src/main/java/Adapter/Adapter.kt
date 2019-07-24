package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import Model.Fooditem
import com.example.foods.R

import java.util.ArrayList

class Adapter(context: Context, foodlist: ArrayList<Fooditem>) : ArrayAdapter<Fooditem>(context, 0, foodlist) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)

        }

        val imagefoodView = convertView!!.findViewById<ImageView>(R.id.image_view_food)
        val textViewname = convertView.findViewById<TextView>(R.id.text_view_name)

        val currentItem = getItem(position)

        imagefoodView.setImageResource(currentItem!!.imagefoodname)
        textViewname.text = currentItem.foodname

        return convertView
    }

}