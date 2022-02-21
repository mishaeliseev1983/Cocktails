package com.melyseev.cocktails.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.melyseev.cocktails.util.DEFAULT_DRINK_IMAGE
import com.melyseev.cocktails.util.loadPicture

@Composable
fun LoadingResult(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(modifier = Modifier.align(Alignment.Center)){
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Loading ...",
                style = TextStyle(fontSize = 55.sp)
            )

            val image = loadPicture(drawable = DEFAULT_DRINK_IMAGE).value

            image?.let {
                Image(
                    bitmap = image.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(255.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

    }
}