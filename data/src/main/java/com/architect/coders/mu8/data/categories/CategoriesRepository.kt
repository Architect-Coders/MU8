package com.architect.coders.mu8.data.categories

import com.architect.codes.mu8.utils.CHARACTERS
import com.architect.codes.mu8.utils.COMICS
import com.architect.codes.mu8.utils.EVENTS
import com.architect.codes.mu8.categories.Category

class CategoriesRepository {

    val categories: List<Category> = listOf(
        Category(CHARACTERS, "https://revistapantallas.files.wordpress.com/2014/03/marvel-heroes.jpg"),
        Category(COMICS, "https://cdn.pixabay.com/photo/2016/03/06/04/14/comics-1239698_960_720.jpg"),
        Category(
            EVENTS,
            "https://resize.blogsys.jp/4879b25a2b57bd143d6f0fff14c46e9f95659cd4/trim2/11x19_97p_1200x838/https://livedoor.blogimg.jp/" +
                    "retro_footballshirts/imgs/8/8/8872be05.jpg"
        )
    )
}
