package com.byd.firstcode.kotlin.eleven

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_permission.*
import org.jetbrains.anko.toast

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
      if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
          ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),1)
      }else{
          call()
      }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            1->{
                if(grantResults.isNotEmpty()&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    call()
                }else{
                    toast("deny")
                }
            }
        }

    }

    private fun call(){

    }



}