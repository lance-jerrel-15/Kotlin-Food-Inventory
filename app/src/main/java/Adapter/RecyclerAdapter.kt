package Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView

import com.example.foods.R

import java.util.ArrayList

import android.content.ContentValues.TAG
import de.hdodenhof.circleimageview.CircleImageView

open class RecyclerAdapter(val mContext: Context, imageNames: ArrayList<String>, image: ArrayList<Int>) : RecyclerView.Adapter<ViewHolder>() {


    private var mImageNames = ArrayList<String>()
    private var mImage = ArrayList<Int>()

    init {
        mImageNames = imageNames
        mImage = image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Called.")

        holder.imageName.text = mImageNames[position]
        holder.image.setImageResource(mImage[position])

        holder.recycler_layout.setOnClickListener {
            Log.d(TAG, "onclick:click on:" + mImageNames[position])
            Toast.makeText(mContext, mImageNames[position] + " Selected", Toast.LENGTH_SHORT).show()
            val clickedfoodName = mImageNames[position]


        }
    }

    /*
     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         Log.d(TAG, "onBindViewHolder: Called.")

        holder.imageName.text = mImageNames[position]
        holder.image.setImageResource(mImage[position])

        holder.recycler_layout.setOnClickListener {
            Log.d(TAG, "onclick:click on:" + mImageNames[position])
            Toast.makeText(mContext, mImageNames[position] + " Selected", Toast.LENGTH_SHORT).show()
            val clickedfoodName = mImageNames[position]


            }
        }*/

        override fun getItemCount(): Int {
        return mImageNames.size
        }

        companion object {
        private val TAG = "RecyclerAdapter"
        }



    }

     open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        internal var image: CircleImageView
        internal var imageName: TextView
        internal var recycler_layout: RelativeLayout

        init {
            image = itemView.findViewById(R.id.circleimageview)
            imageName = itemView.findViewById(R.id.recycle_nameview)
            recycler_layout = itemView.findViewById(R.id.recycler_layout)
        }
    }







