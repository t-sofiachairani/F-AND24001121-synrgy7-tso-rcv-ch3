package com.example.recyclerview.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.ModelAlphabet
import com.example.recyclerview.R
import com.example.recyclerview.adapter.FragmentTwoAdapter


@Suppress("DEPRECATION")
class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val content = arguments?.getParcelable<ModelAlphabet>("data")
        val header = "Words That Start With "
        (activity as AppCompatActivity).supportActionBar?.setTitle(header + content?.huruf)
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val content = arguments?.getParcelable<ModelAlphabet>("data")
        val adapter = FragmentTwoAdapter(content?.dataContent!!,object : FragmentTwoAdapter.onClick{
            override fun click(data: String) {
                val url = "https://www.google.com/search?q="+data
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        })
        val rv = view.findViewById<RecyclerView>(R.id.rv_2)
        rv.layoutManager = LinearLayoutManager(requireActivity())
        rv.adapter = adapter
    }

}