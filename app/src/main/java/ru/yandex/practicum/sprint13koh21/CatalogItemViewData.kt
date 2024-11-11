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

    private fun formatPrice(price: Float): String = "%.2f".format(price)

    fun bind(viewData: CatalogItemViewData) {
        binding.root

        Glide
            .with(binding.root.context)
            .load(viewData.item.imageUrl)
            .into(binding.image)
        binding.title.text = viewData.item.name
        binding.price.text = "${formatPrice(viewData.item.price.toFloat() / 100)}/${viewData.item.unit}"

        if (viewData.count != null) {
            if (viewData.count > 0) {
                binding.addToCart.visibility = View.GONE
                binding.countContainer.visibility = View.VISIBLE
                binding.count.text = viewData.count.toString()
            } else {
                binding.addToCart.visibility = View.VISIBLE
                binding.countContainer.visibility = View.GONE
                binding.count.text = "0"
            }

        }
    }

}