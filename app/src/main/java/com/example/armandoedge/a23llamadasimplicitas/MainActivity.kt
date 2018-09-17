package com.example.armandoedge.a23llamadasimplicitas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.EditText



class MainActivity : AppCompatActivity() {


    // EditText view for the website URI
    private var mWebsiteEditText: EditText? = null
    // EditText view for the location URI
    private var mLocationEditText: EditText? = null
    // EditText view for the share text
    private var mShareTextEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_editext)
        mShareTextEditText = findViewById(R.id.share_edittext)
    }

    fun openWebsite(view: View) {

        val url = mWebsiteEditText!!.text.toString()


        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)


        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun openLocation(view: View) {

        val loc = mLocationEditText!!.text.toString()


        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun shareText(view: View) {

        val txt = mShareTextEditText!!.text.toString()

        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser()
    }




}
