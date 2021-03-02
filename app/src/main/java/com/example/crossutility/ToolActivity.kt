package com.example.crossutility;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crossutility.data.datasource
import com.example.crossutility.databinding.ToolRecyclerViewBinding
import com.example.crossutility.model.card

class ToolActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ToolRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardList: List<card> = datasource().loadCards()

        recyclerView = findViewById(R.id.recycler_view_start)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ToolAdapter(this, cardList)

    }
}
