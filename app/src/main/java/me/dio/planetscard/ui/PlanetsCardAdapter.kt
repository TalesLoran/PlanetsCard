package me.dio.planetscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.dio.planetscard.data.PlanetsCard
import me.dio.planetscard.databinding.ItemPlanetsCardBinding

class PlanetsCardAdapter :
    ListAdapter<PlanetsCard, PlanetsCardAdapter.ViewHolder>(DiffCallback()) {


    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlanetsCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemPlanetsCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlanetsCard) {
            binding.tvNome.text = item.nome
            binding.tvDistancia.text = item.distancia
            binding.tvAtmosfera.text = item.atmosfera
            binding.tvCaracteristicas.text = item.caracteristica
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }

        }


    }



}
class DiffCallback: DiffUtil.ItemCallback<PlanetsCard>() {
    override fun areItemsTheSame(oldItem: PlanetsCard, newItem: PlanetsCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: PlanetsCard, newItem: PlanetsCard) = oldItem.id == newItem.id
}