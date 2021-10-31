package data

import com.example.sportshop.R
import model.Manufacturer
import model.Product

object DataSource {
    val manufacturer1 = Manufacturer("Adidas")
    val manufacturer2 = Manufacturer("Reebok")
    val manufacturer3 = Manufacturer("Puma")
    val description : String = "Подробное описание"
    val products = listOf(Product("Кепка зеленая",description,R.drawable.ic_hat3,"Кепки",2000,manufacturer2),
        Product("Кепка белая",description, R.drawable.ic_hat1,"Кепки",2000,manufacturer2),
        Product("Кепка черная",description,R.drawable.ic_hat2,"Кепки",2000,manufacturer1),
        Product("Толстовка синяя",description,R.drawable.ic_sweatshirt1,"Толстовки",5000,manufacturer2),
        Product("Толстовка белая",description,R.drawable.ic_sweatshirt3,"Толстовки",5000,manufacturer3),
        Product("Толстовка черная",description,R.drawable.ic_sweatshirt2,"Толстовки",5000,manufacturer1),
        Product("Футболка синяя",description,R.drawable.ic_t_shirt1,"Футболки",3000,manufacturer3),
        Product("Футболка белая",description,R.drawable.ic_t_shirt3,"Футболки",3000,manufacturer2),
        Product("Футболка черная",description,R.drawable.ic_t_shirt2,"Футболки",3000,manufacturer2))
}