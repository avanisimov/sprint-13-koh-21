package ru.yandex.practicum.sprint13koh21

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.yandex.practicum.sprint13koh21.databinding.VCatalogItemBinding

data class CatalogItemViewData(
    val item: CatalogItem,
    val count: Int?,
) {
    val id = item.id
}

class CatalogItemViewHolder(
    parent: ViewGroup,
    val binding: VCatalogItemBinding = VCatalogItemBinding.inflate(
        LayoutInflater.from(
            parent.context
        ), parent, false
    )
) : RecyclerView.ViewHolder(
    binding.root
) {

    private fun formatPrice(price: Float): String {
        val tmpPrice = price / 100
        return "%.2f".format(tmpPrice)
    }

    fun bind(viewData: CatalogItemViewData) {
        binding.root

        Glide
            .with(binding.root.context)
            .load(viewData.item.imageUrl)
            .into(binding.image)
        binding.title.text = viewData.item.name
        binding.price.text = "${formatPrice(viewData.item.price.toFloat())}/${viewData.item.unit}"

        if (viewData.count != null) {
            binding.addToCart.visibility = View.GONE
            binding.countContainer.visibility = View.VISIBLE
            binding.count.text = viewData.count.toString()
        }
    }

}