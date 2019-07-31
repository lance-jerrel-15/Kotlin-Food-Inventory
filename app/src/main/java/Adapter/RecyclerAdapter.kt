package Adapter


import Model.Foods
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foods.R
import android.widget.*
import com.example.foods.MainActivity.Companion.count
import com.example.foods.MainActivity.Companion.foods
import com.example.foods.MainActivity.Companion.selection_list
import de.hdodenhof.circleimageview.CircleImageView


open class RecyclerAdapter(val mContext: Context, imageNames: ArrayList<Foods>) : RecyclerView.Adapter<ViewHolder>() {

    init {
        mImagenames = imageNames
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Called.")

        holder.imageNameCheckbox.setText(mImagenames.get(position).getmImagename())
        holder.image.setImageResource(mImagenames[position].getmImage())


        val foodposition = foods!!.get(position)

        holder.recycler_layout.setOnClickListener { it: View? ->
            Log.d(TAG, "onclick:click on:" + mImagenames[position])
            Toast.makeText(mContext, mImagenames.get(position).getmImagename() + " Selected", Toast.LENGTH_SHORT).show()
            //val clickfoodName = mImagenames[position]
        }

        holder.imageNameCheckbox.setOnCheckedChangeListener() { buttonView, isChecked ->
            Log.d(TAG, "onclick:click on:" + mImagenames[position])

            //val foodposition = foods!!.get(position)

                if(buttonView.isChecked()) {
                    selection_list.add(foodposition)
                    count = count + 1
                    Toast.makeText(mContext,"" + count + " item Selected ", Toast.LENGTH_SHORT).show()
                    } else {
                    selection_list.remove(foodposition)
                    count = count - 1
                    Toast.makeText(mContext,"" + count + " item Selected ", Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun getItemCount(): Int {
            return mImagenames.size
        }

        companion object {
            var mImagenames = ArrayList<Foods>()
            var Foods: java.util.ArrayList<Foods>? = null
            private val TAG = "RecyclerAdapter"


            fun updateAdapter(list: ArrayList<Foods>) {
                for (Foods in list){
                    mImagenames.remove(Foods)

                }
            }
        }
    }
open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

         var image: CircleImageView
         var imageNameCheckbox: CheckBox
         var recycler_layout: RelativeLayout
         lateinit var MainActivity: Context

        init {
            image = itemView.findViewById(R.id.circleimageview)
            imageNameCheckbox = itemView.findViewById(R.id.checkbox_recycle_nameview)
            recycler_layout = itemView.findViewById(R.id.recycler_layout)
            imageNameCheckbox.setOnClickListener(this)

        }

        override fun onClick(v: View) {

        }
    }


























