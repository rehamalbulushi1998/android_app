package com.example.finalproject.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.MainActivity2
import com.example.finalproject.Quote
import com.example.finalproject.QuotesResponse
import com.example.finalproject.R
import kotlinx.android.synthetic.main.list_quotes.view.*
import kotlinx.coroutines.InternalCoroutinesApi



class QuotesListAdapter(
    private val quotes: List<Quote>
) : RecyclerView.Adapter<QuotesListAdapter.QuoteViewHolder>(){

    class QuoteViewHolder(view : View) : RecyclerView.ViewHolder(view){

        fun bindQuote(quote: Quote){
            itemView.qoutecontent.text = quote.content
            itemView.qouteauthor.text = quote.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_quotes, parent, false)
        )
    }

    override fun getItemCount(): Int = quotes.size

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bindQuote(quotes.get(position))
    }
}