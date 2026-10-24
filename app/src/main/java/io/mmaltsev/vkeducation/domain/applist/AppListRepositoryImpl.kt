package io.mmaltsev.vkeducation.data.applist

import io.mmaltsev.vkeducation.domain.applist.AppListRepository
import io.mmaltsev.vkeducation.domain.applist.AppListItem
import javax.inject.Inject

class AppListRepositoryImpl @Inject constructor() : AppListRepository {

    override suspend fun getApps(): List<AppListItem> = SampleAppListData.apps
}
