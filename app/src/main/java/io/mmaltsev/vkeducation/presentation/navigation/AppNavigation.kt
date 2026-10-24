package io.mmaltsev.vkeducation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.mmaltsev.vkeducation.presentation.appdetails.AppDetailsScreen
import io.mmaltsev.vkeducation.presentation.applist.AppListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.APP_LIST,
    ) {
        composable(Routes.APP_LIST) {
            AppListScreen(
                onAppClick = { appId ->
                    navController.navigate(Routes.appDetails(appId))
                },
            )
        }

        composable(
            route = Routes.APP_DETAILS,
            arguments = listOf(
                navArgument(Routes.ARG_APP_ID) { type = NavType.StringType },
            ),
        ) {
            AppDetailsScreen(
                onBackClick = { navController.popBackStack() },
                onShowcaseAppClick = {
                    navController.navigate(Routes.APP_LIST) {
                        popUpTo(Routes.APP_LIST) { inclusive = false }
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}

object Routes {
    const val APP_LIST = "app_list"
    const val ARG_APP_ID = "appId"
    const val APP_DETAILS = "app_details/{$ARG_APP_ID}"

    fun appDetails(appId: String): String = "app_details/$appId"
}
