package com.architect.coders.mu8.data.local.categories

import com.architect.codes.mu8.model.Category

class CategoriesRepository {

    val categories: List<Category> = listOf(
        Category("Characters", "https://revistapantallas.files.wordpress.com/2014/03/marvel-heroes.jpg"),
        Category("Comics", "https://cdn.pixabay.com/photo/2016/03/06/04/14/comics-1239698_960_720.jpg"),
        Category("Events", "https://cdn.pixabay.com/photo/2017/07/19/17/26/gabriel-2519793_960_720.jpg")
    )
}