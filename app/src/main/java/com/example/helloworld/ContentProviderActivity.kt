package com.example.helloworld

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CursorAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class ContentProviderActivity : BasePermissionAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        getReadSMSPermission(requestPermissionAction)

        val uriSms: Uri = Uri.parse("content://sms/inbox")
        val dataCursor: Cursor = getContentResolver()                   //contentresolver will bring up the db & table into mem
            .query(uriSms, null, null, null, null)!! //selection -- rows, projectioin --columns
        //select * from inbox
        var from = arrayOf("body")
        var to = intArrayOf(android.R.id.text1)
        var adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_1,
            dataCursor ,from,to)

        var cpListView: ListView = findViewById(R.id.cpListview)
        cpListView.adapter = adapter


    }

    val requestPermissionAction =  object :
        RequestPermissionAction {
        override fun permissionGranted() {
        }

        override fun permissionDenied() {
        }
    }

}