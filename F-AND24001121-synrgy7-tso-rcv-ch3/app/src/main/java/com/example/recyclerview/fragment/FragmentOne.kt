package com.example.recyclerview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recyclerview.MainActivity
import com.example.recyclerview.adapter.FragmentAdapter
import com.example.recyclerview.ModelAlphabet
import com.example.recyclerview.R

@Suppress("DEPRECATION")
class FragmentOne : Fragment() {
    private var status : Boolean = false;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.setTitle("Words")
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataList = arrayListOf<ModelAlphabet>()

        dataList.add(ModelAlphabet("A", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("B", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("C", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("D", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("E", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("F", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("G", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("H", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("I", arrayListOf("angsa", "anggur")))
        dataList.add(ModelAlphabet("J", arrayListOf("angsa", "anggur")))

        val adapter = FragmentAdapter(dataList, object : FragmentAdapter.onClick {
            override fun clicker(data: ModelAlphabet) {
                val bundle = Bundle()
                bundle.putParcelable("data", data)
                findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo, bundle)
            }
        })

        val button = view.findViewById<ImageButton>(R.id.btn)
        button.setOnClickListener {
            status = !status
        }
        var rv = view.findViewById<RecyclerView>(R.id.recycler_view);
        rv.layoutManager = LinearLayoutManager(requireActivity())
        if (status){
            rv.layoutManager = GridLayoutManager(requireActivity(),2)
        }else{
            rv.layoutManager = LinearLayoutManager(requireActivity())
        }
        rv.adapter = adapter
    }

}