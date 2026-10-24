package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.data.applist.SampleAppListData
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@Composable
fun AppListScreen(
    onAppClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppListViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val underDevelopmentMessage = stringResource(R.string.under_development)

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                AppListEvent.UnderDevelopment ->
                    snackbarHostState.showSnackbar(underDevelopmentMessage)
            }
        }
    }

    AppListContent(
        state = state,
        snackbarHostState = snackbarHostState,
        onToolbarClick = viewModel::onToolbarClick,
        onAppClick = onAppClick,
        onRetryClick = viewModel::loadApps,
        modifier = modifier,
    )
}

@Composable
private fun AppListContent(
    state: AppListState,
    snackbarHostState: SnackbarHostState,
    onToolbarClick: () -> Unit,
    onAppClick: (String) -> Unit,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { AppListToolbar(onClick = onToolbarClick) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = modifier,
    ) { contentPadding ->
        when (state) {
            is AppListState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }

            is AppListState.Error -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(R.string.app_details_error),
                        style = MaterialTheme.typography.headlineMedium,
                    )
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = onRetryClick) {
                        Text(text = stringResource(R.string.app_details_error_refresh))
                    }
                }
            }

            is AppListState.Content -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                    contentPadding = PaddingValues(vertical = 8.dp),
                ) {
                    items(
                        items = state.apps,
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
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        AppListContent(
            state = AppListState.Content(SampleAppListData.apps),
            snackbarHostState = remember { SnackbarHostState() },
            onToolbarClick = {},
            onAppClick = {},
            onRetryClick = {},
        )
    }
}
