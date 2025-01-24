package com.bodakesatish.composewithpaging.ui.schemes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.composewithpaging.databinding.ListRowCustomerBinding
import com.bodakesatish.composewithpaging.domain.model.Scheme

class SchemeAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<Scheme> = emptyList()
    var onSchemeSelected: ((Scheme) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ListRowCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SchemeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is SchemeViewHolder -> {
                holder.bind(itemList[position], position)
            }

        }
    }

    fun setData(data: List<Scheme>) {
        itemList = data
        notifyItemRangeChanged(0, data.size)
    }

    fun setOnClickListener(onBatchSelected: ((Scheme)) -> Unit) {
        this.onSchemeSelected = onBatchSelected
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class SchemeViewHolder(val binding: ListRowCustomerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Scheme, position: Int) {

            binding.tvNumber.text = "${position + 1}."
            binding.tvSchemeCode.text = "${data.schemeCode}"
            binding.tvSchemeName.text = "${data.schemeName}"

            binding.root.setOnClickListener {
                onSchemeSelected?.invoke(data)
            }
        }

    }
}