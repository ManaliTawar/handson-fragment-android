package com.example.assignment3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.google.gson.Gson

class MovieFragment(private val position: Int) : Fragment() {
    private val movies = """
       [
        {
            "adult": false,
            "backdrop_path": "/gNBCvtYyGPbjPCT1k3MvJuNuXR6.jpg",
            "genre_ids": [
                35,
                18,
                10749
            ],
            "id": 19404,
            "original_language": "hi",
            "original_title": "दिलवाले दुल्हनिया ले जायेंगे",
            "overview": "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
            "popularity": 24.459,
            "poster_path": "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
            "release_date": "1995-10-20",
            "title": "Dilwale Dulhania Le Jayenge",
            "video": false,
            "vote_average": 8.8,
            "vote_count": 3144
        },
        {
            "adult": false,
            "backdrop_path": "/9Xw0I5RV2ZqNLpul6lXKoviYg55.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 278,
            "original_language": "en",
            "original_title": "The Shawshank Redemption",
            "overview": "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
            "popularity": 65.65,
            "poster_path": "/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
            "release_date": "1994-09-23",
            "title": "The Shawshank Redemption",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 19737
        },
        {
            "adult": false,
            "backdrop_path": "/rSPw7tgCH9c6NqICZef4kZjFOQ5.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 238,
            "original_language": "en",
            "original_title": "The Godfather",
            "overview": "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
            "popularity": 53.115,
            "poster_path": "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
            "release_date": "1972-03-14",
            "title": "The Godfather",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 14812
        }
       ]
    """.trimIndent()
    private lateinit var dataList : List<movieStruct>
    private lateinit var posterTable:MutableMap<String, Int>


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataList = Gson().fromJson(movies,Array<movieStruct>::class.java).asList()
        posterTable = mutableMapOf()
        posterTable["Dilwale Dulhania Le Jayenge"] = R.drawable.poster1
        posterTable["The Shawshank Redemption"] = R.drawable.poster7
        posterTable["The Godfather"] = R.drawable.poster2

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_movie, container, false)

        val poster = view.findViewById<ImageView>(R.id.movie_image)
        poster.setImageResource(posterTable[dataList[position].title]!!)

        val movieTitle = view.findViewById<TextView>(R.id.movie_title)
        movieTitle.text = dataList[position].title

        val description = view.findViewById<TextView>(R.id.movie_info)
        description.text = dataList[position].overview

        val rating = view.findViewById<RatingBar>(R.id.ratingBar)
        val votes = dataList[position].vote_average.toFloat() / 2
        rating.rating = votes

        val year = view.findViewById<TextView>(R.id.year)
        year.text = "Release Date : " + dataList[position].release_date


        return view
    }

}