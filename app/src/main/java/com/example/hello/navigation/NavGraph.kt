package com.example.hello.navigation

sealed class Screen(val route: String) {
    object ProjectList : Screen("projectList")
    object ProjectEditor : Screen("projectEditor/{projectId}") {
        fun createRoute(projectId: Long) = "projectEditor/$projectId"
    }
}
