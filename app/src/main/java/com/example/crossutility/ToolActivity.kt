package com.example.crossutility;

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    private var isLinearLayoutManager = true
    private val cardList: List<card> = datasource().loadCards()

    fun chooseLayout(){
        if (isLinearLayoutManager)
            recyclerView.layoutManager = LinearLayoutManager(this)
        else
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = ToolAdapter(this, cardList)
    }

    fun setIcon(item: MenuItem?){
        if (item == null)
            return

        if (isLinearLayoutManager)
            item.setIcon(R.drawable.ic_baseline_grid_view_24)
        else
            item.setIcon(R.drawable.ic_baseline_view_list_24)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val actionButton = menu?.findItem(R.id.action_button)
        setIcon(actionButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_button -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ToolRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerViewStart
        chooseLayout()
    }
}
