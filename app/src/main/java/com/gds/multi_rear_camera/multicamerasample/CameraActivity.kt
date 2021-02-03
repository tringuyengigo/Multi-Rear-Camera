package com.gds.multi_rear_camera.multicamerasample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gds.multi_rear_camera.R

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, CameraFragment.newInstance())
            .commit()
    }

}
