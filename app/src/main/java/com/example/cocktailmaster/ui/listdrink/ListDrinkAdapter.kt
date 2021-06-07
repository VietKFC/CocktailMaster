package com.example.cocktailmaster.ui.listdrink

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmaster.data.model.Drink
import com.example.cocktailmaster.databinding.ItemDrinkDetailBinding
import com.example.cocktailmaster.utils.loadImageByUrl

class ListDrinkAdapter(
    private val clickItem: (Int) -> Unit
) : RecyclerView.Adapter<ListDrinkAdapter.ViewHolder>() {

    private val drinks = mutableListOf<Drink>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDrinkDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root, binding , clickItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(drinks[position])
    }

    override fun getItemCount() = drinks.size

    fun setDrinks(drinks: List<Drink>) {
        this.drinks.apply {
            clear()
            addAll(drinks)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(
        itemView: View,
        private val binding: ItemDrinkDetailBinding,
        private val clickItem: (Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private var id: Int = 0

        init {
            itemView.setOnClickListener{
                clickItem(id)
            }
        }

        fun bindView(drink: Drink) {
            id = drink.id
            binding.imageDrink.loadImageByUrl(drink.thumb)
            binding.textDrink.text = drink.name
        }
    }
}
