package com.kefelon.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw java.lang.IllegalArgumentException("Route $route is not recognized.")
        }
    }
}


