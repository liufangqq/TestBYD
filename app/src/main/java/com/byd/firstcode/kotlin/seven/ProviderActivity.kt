package com.byd.firstcode.kotlin.seven

import android.Manifest
import android.content.Intent
import android.content.UriMatcher
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.contentValuesOf
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_provider.*
import org.jetbrains.anko.toast

class ProviderActivity : AppCompatActivity() {

    private val contactsList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    private fun readContacts() {

        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )?.apply {
            Log.d("test311", "value:${moveToNext()}");
            while (moveToNext()) {
                val displayName =
                    getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val number =
                    getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                Log.d("test30", "$displayName$number");
                contactsList.add("$displayName\n$number")
            }
            adapter.notifyDataSetChanged()
            // close()
        }
        Log.d("test31", "value:$cursor");
    }


    val uriMatcher by later {
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
//        matcher.addURI()
        matcher
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provider)
val p = MyClass().p1

        contentResolver.query(Uri.parse("content://"),null,null,
        null,null)?.build {
            while (moveToNext()){

            }
        }

//        val myClass = MyClass<Int>()
//        val result = myClass.method(123)
//        toast("$result")

        val myClass = MyClass1()
        val result = myClass.method(2)
        toast("$result")

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
        contactsView.adapter = adapter
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 1)
        } else {
            readContacts()
        }

        makeCall.setOnClickListener {
//            val intent  = Intent(Intent.ACTION_CALL)
//            intent.setData(Uri.parse("tel:10086"))
//            startActivity(intent)
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
            } else {
                call()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // call()
                    readContacts()
                } else {
                    toast("deny")
                }
            }
        }
    }

    private fun call() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.setData(Uri.parse("tel:10086"))
        startActivity(intent)
    }

}