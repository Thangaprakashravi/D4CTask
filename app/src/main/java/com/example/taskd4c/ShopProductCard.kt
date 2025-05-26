package com.example.taskd4c

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskd4c.ui.theme.neurite
import com.example.taskd4c.ui.theme.tangerine


@Composable
fun ShopProductCard(product: Product) {

    Box(
        modifier = Modifier
            .height(460.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.grey_card_svg),//grey background
            contentDescription = "Card Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // heart icon to show and clickables
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 7.dp).clickable {  }
                .size(40.dp)
                .background(Color.Black, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.purple_heart_svgrepo_com),
                contentDescription = "Favorite",
                modifier = Modifier.size(22.dp).clickable {  },
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .background(Color(0xFFB5F74E), shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = "Best seller",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = "Product",
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.TopCenter)
                .padding(top = 60.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(160.dp)
                .fillMaxWidth()
        ) {
            // Black shape background
            Image(
                painter = painterResource(id = R.drawable.product_title_card),
                contentDescription = "Info Background",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth().padding(10.dp).clip(RoundedCornerShape(20.dp))
            )

            // Text and Cart on top of black shape
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 20.dp, bottom = 20.dp, end = 60.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Left: Product Title
                    Text(
                        text = product.title,
                        color = Color(0xFFB5F74E),
                        fontSize = 16.sp, fontFamily = tangerine,
                        fontWeight = FontWeight.Bold
                    )

                    // Right: Dot + Stock Text
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    color = if (product.inStock) Color(0xFFB5F74E) else Color.Red,
                                    shape = CircleShape
                                )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (product.inStock) "In Stock" else "Out of Stock",
                            color = if (product.inStock) Color(0xFFB5F74E) else Color.Red,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Text(
                    text = product.subtitle,
                    color = Color.White,
                    fontSize = 12.sp
                )
                Text(
                    text = product.highlights,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row {
                    Text(
                        text = product.price,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = product.originalPrice,
                        color = Color.Gray,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "⭐⭐⭐⭐⭐ ${product.reviews}",
                    color = Color.White, fontFamily = neurite,
                    fontSize = 12.sp
                )
            }

            // Cart icon inside the circle
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = 16.dp).clickable {  }
                    .size(45.dp)
                    .border(width = 1.dp, color = Color(0xFFB5F74E), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cart3),
                    contentDescription = "Cart Icon",
                    modifier = Modifier.size(25.dp),
                    colorFilter = ColorFilter.tint(Color(0xFFB5F74E))
                )
            }
        }
    }
}
@Composable
fun ProductListView() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        productList.forEach { product ->
            ShopProductCard(product)
        }
    }
}


//The class to assign the value and easy to access
data class Product(
    val title: String,
    val subtitle: String,
    val highlights: String,
    val price: String,
    val originalPrice: String,
    val reviews: String,
    val imageRes: Int,
    val inStock: Boolean
)
val productList = listOf(
    Product("clencera", "French clay and algae-powered cleanser", "Skin Tightness • Dry & Dehydrated Skin", "Rs. 355.20", "Rs. 444.00", "249 reviews", R.drawable.product_image,true),
    Product("glow", "Vitamin C brightening serum", "Glowing • Oily & Normal Skin", "Rs. 399.00", "Rs. 499.00", "189 reviews", R.drawable.categorysample,true),
    Product("afterglow", "Hyaluronic acid water gel", "Moisture Boost • All Skin Types", "Rs. 299.00", "Rs. 350.00", "312 reviews", R.drawable.product_image,false),

)
