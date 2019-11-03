package com.fionicholas.footballleague.adapter

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.fionicholas.footballleague.R
import com.fionicholas.footballleague.model.Football
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.sdk27.coroutines.onClick

class FootballAdapter(private val result: List<Football>, private val listener: (Football) -> Unit)
    : RecyclerView.Adapter<FootballAdapter.FootballViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FootballViewHolder {
        return FootballViewHolder(FootballItem().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(p0: FootballViewHolder, p1: Int) {
        p0.bindItem(result[p1], listener)
    }

    class FootballItem : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){

                frameLayout {
                cardView {
                    layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT).apply {
                        leftMargin = dip(10)
                        rightMargin = dip(10)
                        topMargin = dip(5)
                        bottomMargin = dip(5)

                    }
                    radius = dip(8).toFloat()
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(4)
                    orientation = LinearLayout.VERTICAL


                    imageView {
                        id = R.id.football_image
                    }.lparams {
                        height = dip(250)
                        width = wrapContent
                    }

                    textView {
                        id = R.id.football_name
                        textSize = 16f
                        typeface = Typeface.DEFAULT_BOLD
                        textColor = Color.BLACK
                        maxLines = 1
                        gravity = Gravity.CENTER

                    }.lparams {
                        width = matchParent
                    }
                }
                }
                }
            }
        }
    }

    class FootballViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val footbalImage: ImageView = view.find(R.id.football_image)
        private val footballName: TextView = view.find(R.id.football_name)

        fun bindItem(football: Football, listener: (Football) -> Unit){
            Picasso.get().load(football.image).into(footbalImage)
            footballName.text = football.name

            footbalImage.onClick {
                listener(football)
            }

        }
    }
}