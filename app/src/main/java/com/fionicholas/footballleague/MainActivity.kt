package com.fionicholas.footballleague

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.fionicholas.footballleague.adapter.FootballAdapter
import com.fionicholas.footballleague.model.Football
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv_football: RecyclerView
    private lateinit var adapter: FootballAdapter
    private var football: MutableList<Football> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(8)

            rv_football = recyclerView {
                id = R.id.recycle
                lparams(width = matchParent,  height = wrapContent)
                layoutManager = GridLayoutManager(applicationContext, 2)
            }
        }

        adapter = FootballAdapter(football){
            startActivity<DetailActivity>(
                "NAME" to it.name,
                "IMAGE" to it.image,
                "DESCRIPTION" to it.description,
                "ID" to it.id
            )
        }
        rv_football.adapter = adapter
        initData()

    }

    private fun initData(){
        val name = resources.getStringArray(R.array.league_name)
        val id = resources.getStringArray(R.array.league_id)
        val image = resources.obtainTypedArray(R.array.league_image)
        val description = resources.getStringArray(R.array.league_description)
        football.clear()
        for (i in name.indices) {
            football.add(Football(name[i], id[i], description[i],
                image.getResourceId(i, 0)))

        }

        //Recycle the typed array
        image.recycle()
    }

    }

