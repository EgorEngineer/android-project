package io.mmaltsev.vkeducation.domain.applist

import io.mmaltsev.vkeducation.domain.appdetails.Category

data class AppListItem(
    val id: String,
    val name: String,
    val developer: String,
    val iconUrl: String,
    val description: String,
    val category: Category,
)