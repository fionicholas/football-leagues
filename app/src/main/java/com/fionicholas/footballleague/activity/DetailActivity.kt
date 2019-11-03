package com.fionicholas.footballleague.activity

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.fionicholas.footballleague.R
import com.fionicholas.footballleague.model.Football
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class DetailActivity : AppCompatActivity() {

    private lateinit var imageL: ImageView
    private lateinit var nameL: TextView
    private lateinit var descriptionL: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Detail League"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        scrollView {
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
                        textSize = 24f
                        textColor = Color.BLACK
                        typeface = Typeface.DEFAULT_BOLD
                        maxLines = 1
                        gravity = Gravity.CENTER

                    }.lparams {
                        topMargin = dip(12)
                        width = matchParent
                    }

                    textView {
                        textSize = 18f
                        textColor = Color.BLACK
                        typeface = Typeface.DEFAULT_BOLD
                        maxLines = 1
                        text = "Description"


                    }.lparams {
                        topMargin = dip(12)
                        width = matchParent
                    }

                    textView {
                        id = R.id.footbal_description
                        textSize = 16f
                        textColor = Color.BLACK

                    }.lparams {
                        width = matchParent
                    }
                }
            }
        }
        //End Anko Layout
        imageL = findViewById(R.id.football_image)
        nameL = findViewById(R.id.football_name)
        descriptionL = findViewById(R.id.footbal_description)


        val data = intent.extras
        val footbal = data.getParcelable<Football>("DETAIL_FOOTBALL")
        val name = footbal.name
        val description = footbal.description
        val image = footbal.image

        nameL.text = name
        descriptionL.text = description
        Picasso.get().load(image.toString().trim()).into(imageL)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {

            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
