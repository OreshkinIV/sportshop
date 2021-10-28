package data

import com.example.sportshop.R
import model.Manufacturer
import model.Product

object DataSource {
    val manufacturer1 = Manufacturer("Adidas")
    val manufacturer2 = Manufacturer("Reebok")
    val manufacturer3 = Manufacturer("Puma")
    val description : String = "Подробное описание"
    val products = listOf(Product("Кепка зеленая",1,"Кепки",2000,manufacturer2, R.drawable.ic_hat3,
        description),
        Product("Кепка белая",2,"Кепки",2000,manufacturer2,R.drawable.ic_hat1,description),
        Product("Кепка черная",3,"Кепки",2000,manufacturer1,R.drawable.ic_hat2,description),
        Product("Толстовка синяя",4,"Толстовки",5000,manufacturer2,R.drawable.ic_sweatshirt1,description),
        Product("Толстовка белая",5,"Толстовки",5000,manufacturer3,R.drawable.ic_sweatshirt3,description),
        Product("Толстовка черная",6,"Толстовки",5000,manufacturer1,R.drawable.ic_sweatshirt2,description),
        Product("Футболка синяя",7,"Футболки",3000,manufacturer3,R.drawable.ic_t_shirt1,description),
        Product("Футболка белая",8,"Футболки",3000,manufacturer2,R.drawable.ic_t_shirt3,"description"),
        Product("Футболка черная",9,"Футболки",3000,manufacturer2,R.drawable.ic_t_shirt2,description))
}