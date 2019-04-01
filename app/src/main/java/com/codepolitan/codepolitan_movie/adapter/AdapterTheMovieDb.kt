package com.codepolitan.codepolitan_movie.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.codepolitan.codepolitan_movie.BuildConfig
import com.codepolitan.codepolitan_movie.R
import com.codepolitan.codepolitan_movie.model.Result
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by yudisetiawan on 11/4/17.
 */
class AdapterTheMovieDb(private val context: Context, private var resultTheMovieDb: ArrayList<Result>) : RecyclerView.Adapter<AdapterTheMovieDb.ViewHolderTheMovieDb>() {
    override fun onBindViewHolder(holder: ViewHolderTheMovieDb, position: Int) {
        val resultItem = resultTheMovieDb[position]
        Glide
                .with(context)
                .load(BuildConfig.BASE_URL_IMAGE + resultItem.posterPath)
                .into(holder?.itemView?.image_view_poster_item_movie)
        holder
                ?.itemView
                ?.text_view_title_movie_item_movie
                ?.text = resultItem.originalTitle
        holder
                ?.itemView
                ?.text_view_vote_average_item_movie
                ?.text = resultItem.voteAverage.toString()
        holder
                ?.itemView
                ?.text_view_release_date_value_item_movie
                ?.text = resultItem.releaseDate
        holder
                ?.itemView
                ?.text_view_overview_value_item_movie
                ?.text = resultItem.overview
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolderTheMovieDb =
        ViewHolderTheMovieDb(LayoutInflater
                .from(p0?.context)
                .inflate(R.layout.item_movie, p0, false)
        )


    private val TAG = javaClass.simpleName



    override fun getItemCount(): Int = resultTheMovieDb.size

    fun refreshAdapter(resultTheMovieDb: List<Result>) {
        this.resultTheMovieDb.addAll(resultTheMovieDb)
        notifyItemRangeChanged(0, this.resultTheMovieDb.size)
    }

    inner class ViewHolderTheMovieDb(itemView: View?) : RecyclerView.ViewHolder(itemView!!)

}