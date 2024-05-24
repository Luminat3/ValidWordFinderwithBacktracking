package com.luminoir.validwordfinderwithbacktracking

const val DETAIL_ARGUMENT_KEY = "id"
sealed class Screen(val route: String)
{
    object main: Screen(route = "main_activity")
    object profile: Screen(route = "profile_activity")


}
