package com.learn.distonary.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.learn.distonary.R
import com.learn.distonary.model.DataModel

class MainAdapter(
    private var onListItemClickListener: OnClickItemListener,
    private var date: List<DataModel>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    fun setData(data: List<DataModel>) {
        this.date = date
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(dataModel: DataModel) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                itemView.findViewById<AppCompatTextView>(R.id.translate_text).text = dataModel.text
                itemView.findViewById<AppCompatTextView>(R.id.meaning_text).text =
                    dataModel.meanings?.get(0)?.translation?.translation
                itemView.setOnClickListener {
                    openNewWindow(dataModel)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(date[position])
    }

    override fun getItemCount(): Int {
        return date.size
    }

    private fun openNewWindow(listItemData: DataModel) {
        onListItemClickListener.onItemClick(listItemData)
    }

    interface OnClickItemListener {
        fun onItemClick(data: DataModel)
    }

}