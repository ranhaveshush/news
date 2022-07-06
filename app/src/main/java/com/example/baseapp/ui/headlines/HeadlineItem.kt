package com.example.baseapp.ui.headlines

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.baseapp.R
import com.example.baseapp.ui.headlines.state.HeadlineUiState
import com.example.baseapp.ui.preivew.SampleData
import com.example.baseapp.ui.theme.AppTheme

@Composable
fun HeadlineItem(
    uiState: HeadlineUiState,
    onHeadlineClick: (HeadlineUiState) -> Unit,
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onHeadlineClick(uiState)
                }
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(uiState.urlToImage)
                    .fallback(R.drawable.ic_launcher_foreground)
                    .build(),
                contentDescription = stringResource(id = R.string.content_description_headline_thumbnail),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = uiState.title,
                style = AppTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.padding.small),
            )
        }
    }
}

@Preview("Light Theme", group = "Headline Item")
@Preview("Dark Theme", group = "Headline Item", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHeadlineItem() {
    AppTheme {
        HeadlineItem(uiState = SampleData.headline, onHeadlineClick = {})
    }
}