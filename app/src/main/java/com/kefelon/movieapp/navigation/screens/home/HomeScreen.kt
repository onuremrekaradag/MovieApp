package com.kefelon.movieapp.navigation.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kefelon.movieapp.model.Movie
import com.kefelon.movieapp.model.getMovies
import com.kefelon.movieapp.navigation.MovieScreens
import com.kefelon.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Magenta,
            elevation = 5.dp
        ) {
            Text(text = "Movies")
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(12.dp)
        ) {
            MainContent(navController = navController)
        }

    }

}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {

    LazyColumn(content = {
        items(items = movieList) {
            MovieRow(movie = it, onItemClick = { movie ->

                navController.navigate(route = MovieScreens.DetailsScreen.name + "/${movie.id}")
                Log.e("movie", movie.id)

            })
        }
    })
}


