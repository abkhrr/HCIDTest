package com.idcoding.hcitest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.idcoding.hcitest.R
import com.idcoding.hcitest.data.model.ItemsModel
import kotlinx.android.synthetic.main.items_grid.view.*
import kotlinx.android.synthetic.main.items_list.view.*

class MainPageAdapter(private val context: Context, private val listItem: List<ItemsModel>, private val clickListener: (ItemsModel) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        val GRID_TYPE = 0
        val LIST_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType === GRID_TYPE) {
            return GridViewHolder(inflater, parent)
        } else if (viewType === LIST_TYPE) {
            return ListViewHolder(inflater, parent)
        }
        return ListViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: ItemsModel = listItem[position]
        if(holder.itemViewType == GRID_TYPE){
            val gridViewHolder = holder as GridViewHolder
            gridViewHolder.bind(item, context, clickListener)
        }else {
            val listViewHolder = holder as ListViewHolder
            listViewHolder.bind(item, context, clickListener)
        }
    }

    override fun getItemCount(): Int = listItem.size

    override fun getItemViewType(position: Int): Int {
        return if(listItem[position].productImage != null){
            GRID_TYPE
        }else {
            LIST_TYPE
        }
    }

    class GridViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.items_grid, parent, false)) {

        fun bind(item: ItemsModel, context: Context, clickListener: (ItemsModel) -> Unit) {
            Glide.with(context)
                .load(item.productImage)
                .apply(RequestOptions().placeholder(android.R.drawable.ic_menu_gallery))
                .into(itemView.product_image)
            itemView.product_name.text = item.productName!!.split(" ")[1]
            itemView.layout_product.setOnClickListener {
                clickListener(item)
            }
        }
    }

    class ListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.items_list, parent, false)) {

        fun bind(item: ItemsModel, context: Context, clickListener: (ItemsModel) -> Unit) {
            Glide.with(context)
                .load(item.articleImage)
                .apply(RequestOptions().placeholder(R.drawable.no_image_to_show_))
                .into(itemView.article_image)
            itemView.article_title.text = item.articleTitle
            itemView.layout_article.setOnClickListener {
                clickListener(item)
            }

        }
    }
}