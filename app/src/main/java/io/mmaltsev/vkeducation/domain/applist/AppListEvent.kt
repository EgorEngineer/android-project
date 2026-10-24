package io.mmaltsev.vkeducation.presentation.applist

sealed interface AppListEvent {
    data object UnderDevelopment : AppListEvent
}
