package io.mmaltsev.vkeducation.data.applist

import io.mmaltsev.vkeducation.domain.applist.AppListItem

object SampleAppListData {

    val apps: List<AppListItem> = listOf(
        AppListItem(
            id = "fa2e31b8-1234-4cf7-9914-108a170a1b01",
            name = "QuickNote",
            developer = "NoteWorks",
            iconUrl = "https://fastly.picsum.photos/id/237/200/200.jpg?hmac=zHUGikXUDyLCCmvyww1izLK3R3k8oRYBRiTizZEdyfI",
        ),
        AppListItem(
            id = "82ea6f63-2b2a-43e1-b54c-ec62e6e27229",
            name = "Calmalist",
            developer = "Calm Studio",
            iconUrl = "https://fastly.picsum.photos/id/238/200/200.jpg?hmac=O4Jc6lqHVfaKVzLf8bWssNTbWzQoaRUC0TDXod9xDdM",
        ),
        AppListItem(
            id = "c6f64035-c432-4aad-a550-a1dac2d3b047",
            name = "FitRiver",
            developer = "RiverFit",
            iconUrl = "https://fastly.picsum.photos/id/239/200/200.jpg?hmac=8JqlXUpZ9Xy0H6tMK8sCPQAYU9vUn9Qa8Kg-U9h3sCY",
        ),
        AppListItem(
            id = "d22b7cda-2d36-4ebd-bfa3-be58770fa455",
            name = "TaskLoop",
            developer = "LoopTeam",
            iconUrl = "https://fastly.picsum.photos/id/240/200/200.jpg?hmac=PZiJibMUuv5Zpv9MAcqLaCYJOPt-XNuDh3RPBZiGcoY",
        ),
        AppListItem(
            id = "f830e414-42a9-4fe6-af16-555a85f6f6c2",
            name = "Pixtrix",
            developer = "Pix Labs",
            iconUrl = "https://fastly.picsum.photos/id/241/200/200.jpg?hmac=F-mDYyK1xUiXjlLd5PvE8EQpTwGfFndV7mMaANDtl28",
        ),
        AppListItem(
            id = "ba31ce5d-b214-46e9-bf7c-35e99e70af14",
            name = "TinyChef",
            developer = "TinyKitchen",
            iconUrl = "https://fastly.picsum.photos/id/242/200/200.jpg?hmac=Z3aa8zbEQkEMFgnVh0Pn96vmCZHhJ17qzCrePYksrcY",
        ),
        AppListItem(
            id = "204a939c-39fb-4c9d-bed9-daeeba8a465e",
            name = "GymMate",
            developer = "GymMate Inc",
            iconUrl = "https://fastly.picsum.photos/id/243/200/200.jpg?hmac=fW5ZwzzyTBy2t2MROp988oq12mZnKwN0coFLhZEE87s",
        ),
        AppListItem(
            id = "1ec98719-1d86-4cdc-b99d-11c6c23d981e",
            name = "FlowCard",
            developer = "FlowTeam",
            iconUrl = "https://fastly.picsum.photos/id/244/200/200.jpg?hmac=Q1gdvE6ZPZUX3nXkxvmzuc12eKVZ9XVEmSH3nCJ2OOo",
        ),
        AppListItem(
            id = "d8180b87-56de-4737-b5ca-953d8c15ec80",
            name = "DreamSafe",
            developer = "DreamSoft",
            iconUrl = "https://fastly.picsum.photos/id/2/200/200.jpg?hmac=isSWZUpv7D1D156XcADPOCZlfCG9mmvb8OlXFdvLdK0",
        ),
    )

    val showcasePages: List<List<AppListItem>> = apps.chunked(3)
}
