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

class TestAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class DefaultViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    class ViewPagerHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val viewPager: ViewPager = itemView.findViewById(R.id.view_pager)
        val tabLayout:TabLayout = itemView.findViewById(R.id.tab_layout)
    }

    companion object{
        const val DEFAULT_ITEM_TYPE = 1
        const val VIEW_PAGER_ITEM_TYPE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 5){
            VIEW_PAGER_ITEM_TYPE
        }else{
            DEFAULT_ITEM_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return if(viewType == DEFAULT_ITEM_TYPE){
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_default,parent,false)
           DefaultViewHolder(view)
       }else{
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
           ViewPagerHolder(view)
       }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewPagerHolder){
            val fragmentActivity = holder.itemView.context as FragmentActivity
            holder.viewPager.adapter = ViewPagerAdapter(fragmentActivity)
            holder.tabLayout.setupWithViewPager(holder.viewPager)
        }else{
            holder.itemView.setOnClickListener {
                Toast.makeText(holder.itemView.context,"$position",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
         return 6
    }
}