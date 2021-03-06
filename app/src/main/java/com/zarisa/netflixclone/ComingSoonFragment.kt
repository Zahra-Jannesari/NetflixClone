package com.zarisa.netflixclone

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zarisa.netflixclone.databinding.FragmentComingSoonBinding

class ComingSoonFragment : Fragment() {
    lateinit var binding: FragmentComingSoonBinding
    private var sharedPrefInfo: SharedPreferences? = null
    private var registerState:Boolean?=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(false)
        binding= FragmentComingSoonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Coming soon"
        sharedPrefInfo = this.activity?.getSharedPreferences("Information", Context.MODE_PRIVATE)
        registerState=sharedPrefInfo?.getBoolean(isRegistered,false)
        onClicks()
    }

    private fun onClicks() {
        binding.btnShare1.setOnClickListener{shareData(binding.textViewCs1.text.toString(),binding.describeCs1.text.toString())}
        binding.btnShare2.setOnClickListener{shareData(binding.textViewCs2.text.toString(),binding.describeCs2.text.toString())}
        binding.btnShare3.setOnClickListener{shareData(binding.textViewCs3.text.toString(),binding.describeCs3.text.toString())}
    }
    private fun shareData(subject: String,body: String){
        if (registerState==false){
            Toast.makeText(activity,"You should register first from profile page!", Toast.LENGTH_SHORT).show()
        }else {
            var myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "text/plain"
//        myIntent.putExtra(Intent.EXTRA_SUBJECT,subject)
//        myIntent.putExtra(Intent.EXTRA_TEXT,body)
            var shareText = "$subject\n$body"
            myIntent.putExtra(Intent.EXTRA_TEXT, shareText)
            startActivity(Intent.createChooser(myIntent, "Share the movie with:"))
        }
    }
}