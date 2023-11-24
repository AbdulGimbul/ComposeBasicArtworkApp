package com.abdl.myartwork

import MainScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abdl.myartwork.ui.theme.MyArtworkTheme

@Composable
fun ArtworkApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var slide by remember {
            mutableStateOf(0)
        }

        var imageId = 0
        var titleId = 0

        when (slide) {
            0 -> {
                imageId = R.drawable.image1
                titleId = R.string.title1
            }

            1 -> {
                imageId = R.drawable.image2
                titleId = R.string.title2

            }

            2 -> {
                imageId = R.drawable.image3
                titleId = R.string.title3
            }

            3 -> {
                imageId = R.drawable.image4
                titleId = R.string.title4
            }
        }

        MainScreen(imageId = imageId, titleId = titleId,
            onPrevious = {
                slide--
                if (slide < 0) {
                    slide = 3
                }
            }, onNext = {
                slide++
                if (slide > 3) {
                    slide = 0
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkAppPreview() {
    MyArtworkTheme {
        ArtworkApp()
    }
}