package com.yelemang.longmeidemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerRecyclerViewAdapter : RecyclerView.Adapter<ViewPagerRecyclerViewAdapter.DefaultViewHolder>() {

    class DefaultViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_default,parent,false)
        return DefaultViewHolder(view)
    }

    override fun onBindViewHolder(holder: DefaultViewHolder, position: Int) {
         holder.itemView.setOnClickListener {
             Toast.makeText(holder.itemView.context,position.toString(),Toast.LENGTH_SHORT).show()
         }
    }

    override fun getItemCount(): Int {
         return 100
    }
}