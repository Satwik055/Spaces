package com.satwik.spaces.core.navigation.objects

sealed class TabScreen(val route:String){
    object MeetingRoom: TabScreen(route = "meetingroom_tab_screen")
    object Workspace: TabScreen(route = "workspace_tab_screen")
    object Lounge: TabScreen(route = "lounge_tab_screen")
    object Coffeeshop: TabScreen(route = "coffeeshop_tab_screen")
}
