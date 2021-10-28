package adapter

import com.example.sportshop.activity.ProductsVH
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportshop.R
import model.Product

typealias OnProductClickListener = (Product) -> Unit

class ProductAdapter(
    private val products: List<Product>,
    private val listener: OnProductClickListener
) : RecyclerView.Adapter<ProductsVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsVH(
            layoutInflater.inflate(R.layout.item_product, parent, false),
            listener
        )
    }
    override fun onBindViewHolder(holder: ProductsVH, position: Int) =
        holder.bind(products[position])

    override fun getItemCount(): Int = products.size
}