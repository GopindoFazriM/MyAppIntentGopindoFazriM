package com.example.myintentappgopindo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // share data with page
        val btnMoveWithDataActivity: Button =
            findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        // move activity
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithObject:Button =
            findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            // move activity
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            // share data with page
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity,
                    MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME
                    , "Gopindo Fazri Muliana")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE
                    , 22)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Gopindo Fazri Muliana",
                    22,
                    "1710031802039@stmik-amik-riau.ac.id",
                    "Pekanbaru"
                )
                val moveWithObjectIntent = Intent(
                    this@MainActivity,
                    MoveWithObjectActivity::class.java
                )
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON
                    , person)
                startActivity(moveWithObjectIntent)
            }
        }
    }
}