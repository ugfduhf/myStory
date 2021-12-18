package com.example.week06day01

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random as RandomRandom

class CustemAdapter(val storiesList: ArrayList<story>, val context: Context) :
    RecyclerView.Adapter<CustemAdapter.DataHolderCustom>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolderCustom {
        val dataHolderCreateView = DataHolderCustom(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_layout, parent, false
            )
        )
        return dataHolderCreateView
    }

    override fun onBindViewHolder(holder: DataHolderCustom, position: Int) {
        val story = storiesList[position]
        holder.storyTitle.text = story.title
        holder.storySubTitle.text = story.subTitle
        holder.storyLetter.text = story.title.first().toString()

        generateColors(holder, position)

        holder.itemView.setOnClickListener{
            val i = Intent(context,StoryDetailsActivity::class.java)
            i.putExtra("title",story.title)
            i.putExtra("description",story.description)
            context.startActivity(i)
        }
    }

    private fun generateColors(holder: DataHolderCustom, position: Int) {

        val r = Random()
        val red = r.nextInt(255 + position)
        val green = r.nextInt(255-position+1)
        val blue = r.nextInt(255+position+1)
        holder.cardViewLetter.setCardBackgroundColor(Color.rgb(red, green, blue))

    }

    override fun getItemCount(): Int {
        return storiesList.count()
        //or  return storiesList.size
    }


    class DataHolderCustom(item: View) : RecyclerView.ViewHolder(item) {
        val storyTitle: TextView = item.findViewById(R.id.tvTitle)
        val storySubTitle: TextView = item.findViewById(R.id.tvSubTitle)
        val storyLetter: TextView = item.findViewById(R.id.tvStoryLetter)
        val cardViewLetter: CardView = item.findViewById(R.id.circle)
    }
}