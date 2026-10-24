package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.data.applist.SampleAppListData
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@Composable
fun AppListScreen(
    onAppClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { AppListToolbar() },
        modifier = modifier,
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            items(
                items = SampleAppListData.apps,
                key = { it.id },
            ) { app ->
                AppListItemRow(
                    app = app,
                    onClick = { onAppClick(app.id) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        AppListScreen(onAppClick = {})
    }
}
