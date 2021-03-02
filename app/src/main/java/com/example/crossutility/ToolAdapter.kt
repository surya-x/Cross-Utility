package com.example.crossutility;

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView;
import com.example.crossutility.model.card

/**
 * Adapter for the [RecyclerView1] in [MainActivity].
 */

class ToolAdapter(
    private val context: Context,
    private val cardList: List<card>,
    private val isLinearLayoutManager: Boolean
) :
    RecyclerView.Adapter<ToolAdapter.ToolViewHolder>() {

    class ToolViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card = view.findViewById<CardView>(R.id.card)
        val titleView = view.findViewById<TextView>(R.id.title)
        val descView = view.findViewById<TextView>(R.id.description)
        val iconView = view.findViewById<ImageView>(R.id.card_icon)
    }

//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
//    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolViewHolder {
        if (isLinearLayoutManager) {
            val layout = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_view_linear, parent, false)
            return ToolViewHolder(layout)
        }
        else{
            val layout = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_view_grid, parent, false)
            return ToolViewHolder(layout)
        }
    }

    override fun onBindViewHolder(holder: ToolViewHolder, position: Int) {
        holder.titleView.text = context.resources.getString(cardList.get(position).titleResourceID)
        if (isLinearLayoutManager)
            holder.descView.text = context.resources.getString(cardList.get(position).descResourceID)
        holder.iconView.setImageResource(
            cardList
                .get(position)
                .iconResourceID
        )
    }

}