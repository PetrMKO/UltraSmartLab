package com.example.mega

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mega.ui.theme.PurpleGrey80

@Composable
fun ItemCard(item: ItemRowModel) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = PurpleGrey80, shape = CircleShape),
        shape = RoundedCornerShape(15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .background(Color.Transparent)
            ,
        ) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = "icon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )

            Column(modifier = Modifier.padding(start = 24.dp)) {
                Text(text = item.title)
                Text(
                    text = item.content,
                    modifier = Modifier
                        .clickable {
                            isExpanded = !isExpanded
                        },
                    maxLines = if(isExpanded) 12 else 1
                )
            }
        }
    }
}