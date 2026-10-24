package io.mmaltsev.vkeducation.presentation.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.data.applist.SampleAppListData
import io.mmaltsev.vkeducation.domain.applist.AppListItem
import io.mmaltsev.vkeducation.presentation.applist.AppListItemCard
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@Composable
fun ShowcaseBlock(
    pages: List<List<AppListItem>>,
    onAppClick: (AppListItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.app_details_showcase),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        HorizontalPager(
            state = rememberPagerState { pages.size },
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 12.dp,
            modifier = Modifier.fillMaxWidth(),
        ) { pageIndex ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                pages[pageIndex].forEach { app ->
                    AppListItemCard(
                        app = app,
                        onClick = { onAppClick(app) },
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        ShowcaseBlock(
            pages = SampleAppListData.showcasePages,
            onAppClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
