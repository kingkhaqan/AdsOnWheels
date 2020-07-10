package com.example.zeesh.aowprototype

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Path
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_login.*
import android.graphics.BitmapFactory



class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)


        login_login.setOnClickListener {
            val user = email.text.toString().toLowerCase()
            if (user == "admin")
                startActivity(Intent(this, AdminDashboardActivity::class.java))
            else
                startActivity(Intent(this, DashboardActivity::class.java))
        }
        login_signup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

//        login_iv_logo.setImageBitmap(GetBitmapClippedCircle(R.drawable.login))
    }

    fun GetBitmapClippedCircle(rsrc: Int): Bitmap {

        val bitmap = BitmapFactory.decodeResource(resources, rsrc)


        val width = bitmap.width
        val height = bitmap.height
        val outputBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        val path = Path()
        path.addCircle(
                (width / 2).toFloat(), (height / 2).toFloat(), Math.min(width, height / 2).toFloat(), Path.Direction.CCW)

        val canvas = Canvas(outputBitmap)
        canvas.clipPath(path)
        canvas.drawBitmap(outputBitmap, 0f, 0f, null)
        return outputBitmap
    }

}

