package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MasterDetailActivity : AppCompatActivity(),MovieListFragment.OnMasterDetailListener {

    private var tablet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_detail)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mobileScreen, MovieListFragment()).commit()
        }

        if (findViewById<FrameLayout>(R.id.tabScreen) != null) {
            tablet = true
            val goToTitle = findViewById<Button>(R.id.go_to_title)

            goToTitle.setOnClickListener{
                val intent = Intent(this,MainActivity::class.java )
                startActivity(intent)
            }
        }
        else{
            val smallToTitle = findViewById<Button>(R.id.smallscreen_to_title)
            smallToTitle.setOnClickListener{
                val intent = Intent(this,MainActivity::class.java )
                startActivity(intent)
            }
        }

    }

    override fun onSelect(position: Int) {
        val fragment = MovieFragment(position)
        if (tablet) {
                supportFragmentManager.beginTransaction().replace(R.id.tabScreen, fragment).commit()
            } else {
                supportFragmentManager.beginTransaction().replace(R.id.mobileScreen, fragment, "Detail").addToBackStack("DetailFrag").commit()
                val smallToTitle = findViewById<Button>(R.id.smallscreen_to_title)

                smallToTitle.setOnClickListener {
                    if (supportFragmentManager.findFragmentByTag("Detail") != null &&
                        supportFragmentManager.findFragmentByTag("Detail")!!.isVisible){
                        supportFragmentManager.beginTransaction().replace(R.id.mobileScreen, MovieListFragment()).commit()
                    }
                    else{
                        val intent = Intent(this,MainActivity::class.java )
                        startActivity(intent)
                    }
                }

            }
    }
}