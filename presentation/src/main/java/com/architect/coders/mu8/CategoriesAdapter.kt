package com.architect.coders.mu8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.architect.codes.mu8.model.Category
import kotlinx.android.synthetic.main.card_list_marvel.view.*

class CategoriesAdapter(private val listener: (Category) -> Unit): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var listCategories: List<Category> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_marvel, parent, false)
        return ViewHolder(view)
    }

    fun updateCategories(listCategories: List<Category>) {
        this.listCategories = listCategories
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listCategories[position]
        holder.showData(category)
        holder.itemView.setOnClickListener { listener(category) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun showData(category: Category) {
            itemView.category_title.text = category.title
            itemView.imageMarvel.loadUrl(category.image, R.drawable.logo_marvel, R.drawable.error_image)
        }

    }
}