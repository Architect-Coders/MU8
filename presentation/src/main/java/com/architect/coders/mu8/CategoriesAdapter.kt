package com.architect.coders.mu8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.architect.codes.mu8.model.Category

class CategoriesAdapter(
    private val listener: (Category) -> Unit,
    private val listCategories: List<Category>
):RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_list_marvel, parent, false))
    }
    
    override fun getItemCount(): Int = listCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listCategories[position]
        holder.showData(category)
        holder.itemView.setOnClickListener { listener(category) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryTitle by lazy { itemView.findViewById<TextView>(R.id.category_title) }
        private val categoryImage by lazy { itemView.findViewById<ImageView>(R.id.category_image)}

        fun showData(category: Category) {
            categoryTitle.text = category.title
            categoryImage.loadUrl(category.image, R.drawable.logo_marvel, R.drawable.error_image)
        }
    }
}