package com.kefelon.movieapp.navigation.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.kefelon.movieapp.model.Movie
import com.kefelon.movieapp.model.getMovies
import com.kefelon.movieapp.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val movie: Movie? = getMovies().find {
        it.id == movieId
    }

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            movie?.let {
                MovieRow(movie = it, onItemClick = {

                })
            }

            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Text(text = "Movie Images")
            HorizontalImageGallery(movie)
        }
    }
}

@Composable
private fun HorizontalImageGallery(movie: Movie?) {
    LazyRow(content = {
        movie?.let { movie ->
            items(items = movie.images, itemContent = {
                Card(
                    modifier = Modifier
                        .padding(5.dp)
                        .height(100.dp)
                        .padding(top = 10.dp),
                    elevation = 5.dp,
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                ) {
                    AsyncImage(
                        modifier = Modifier,
                        model = it,
                        contentDescription = "Movie Image"
                    )
                }
            })
        }
    })
}

@Preview
@Composable
fun PreviewDetailsScreen() {
    DetailsScreen(navController = NavController(LocalContext.current), movieId = getMovies()[0].id)
}