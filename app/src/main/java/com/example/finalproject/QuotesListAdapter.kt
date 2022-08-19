package com.example.finalproject.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import com.example.finalproject.QuotesResponse
import com.example.finalproject.R
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle.parent

class QuotesListAdapter(val context:Context, val list: List<QuotesResponse>)
    : RecyclerView.Adapter<QoutesViewHolder> () {
    @OptIn(InternalCoroutinesApi::class)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QoutesViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_quotes, parent, false)
        return QoutesViewHolder(layout)

    }

    override fun onBindViewHolder(holder: QoutesViewHolder, position: Int) {
        holder.qoute.text = list.get(position).content
        holder.qouteauthor.text = list.get(position).author

    }

    override fun getItemCount(): Int {
        return list.size
    }


}



class QoutesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var qouteauthor: TextView = itemView.findViewById(R.id.qouteauthor)
    var qoute: TextView = itemView.findViewById(R.id.qoute)

}


