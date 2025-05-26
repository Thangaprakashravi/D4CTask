package com.example.taskd4c

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskd4c.ui.theme.century
import com.example.taskd4c.ui.theme.tangerine

@Composable
fun ShopUi() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.DarkGray)
            .padding(top = 15.dp)
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun TopBar(currentPage: Int = 0) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        //shop and back arrow
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically)
            {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White, modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "Shop",
                    fontSize = 24.sp, fontFamily = tangerine,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }

            // Icon and badge to show the top
            Row {
                Icon(Icons.Default.Search, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.width(12.dp))
                BadgedBox(
                    badge = {
                        Badge(
                            modifier = Modifier.align(Alignment.BottomEnd).offset(y = 10.dp),
                            containerColor = Color(0xFFB5F74E), contentColor = Color.White, content = {
                                Text("5")
                            }
                        )
                    }
                ) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.White, modifier = Modifier.clickable {  })
                }

                Spacer(modifier = Modifier.width(12.dp))
                BadgedBox(
                    badge = {
                        Badge(
                            modifier = Modifier.align(Alignment.BottomEnd).offset(y = 10.dp),
                            containerColor = Color(0xFFB5F74E), contentColor = Color.White, content = {
                                Text("3")
                            }
                        )
                    }
                ) {
                    Icon(Icons.Default.ShoppingCart, contentDescription = null, tint = Color.White, modifier = Modifier.clickable {  })
                }

            }
        }

        //Banner the black_card
        Box(
            modifier = Modifier
                .fillMaxWidth().width(100.dp)
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner_card),
                contentDescription = null, contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )
            Column(modifier = Modifier.align(Alignment.TopStart).padding(start = 50.dp, top = 30.dp)) {
                Text("GET 20% OFF", fontSize = 30.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(2.dp))
                Text("Get 20% off", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(30.dp))
                    Text("12-16 October", color = Color.Black, fontSize = 14.sp, modifier = Modifier.clip(
                        RoundedCornerShape(10.dp)
                    ).background(Color(0xFFB5F74E)))

            }
            Image(
                painter = painterResource(id = R.drawable.whatsapp_image_2025_05_26_at_12_36_50_57f9906c),
                contentDescription = "Profile",

                modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 70.dp, end = 60.dp).size(50.dp)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(end = 150.dp)
                    .clip(RoundedCornerShape(50))
                    .padding(horizontal = 5.dp, vertical = 4.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    repeat(3) { index ->
                        Box(
                            modifier = Modifier
                                .width(28.dp)
                                .height(10.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(
                                    if (index == currentPage) Color.Green else Color.Black
                                )
                        )
                    }
                }
            }
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categories",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium, fontFamily = century,
                modifier = Modifier.padding( top = 16.dp)
            )

            Text("See all",color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal, fontFamily = century,
                modifier = Modifier.padding( top = 16.dp).clickable {  }
            )

        }


        LazyRow(modifier = Modifier.padding(10.dp)) {
            items(Categories) { category ->
                Column(
                    modifier = Modifier
                        .width(100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape).clickable {  }
                            .background(Color.Black),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = category.imageRes),
                            contentDescription = category.name,
                            modifier = Modifier.size(70.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = category.name,
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "New products",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium, fontFamily = century,

            )

            Text("See all",color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal, fontFamily = century,
                modifier = Modifier.clickable {  }
            )

        }

        ProductListView() //ShopProductCards

    }
}

// Horizontal image to show
data class Category(val name: String, val imageRes: Int)
val Categories = listOf(
    Category("Cleaners",R.drawable.product_image),
    Category("glow",R.drawable.categorysample),
    Category("afterglow",R.drawable.product_image),
    Category("Moisturisers",R.drawable.categorysample),
    Category("Suncream",R.drawable.product_image)
)

