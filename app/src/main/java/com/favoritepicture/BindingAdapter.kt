package com.favoritepicture

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.favoritepicture.Constants.BASE_URL
import com.favoritepicture.network.PicsumPageData
import com.favoritepicture.ui.home.HomeRecyclerAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<PicsumPageData>?) {
    val adapter = recyclerView.adapter as HomeRecyclerAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUrl2 = "$BASE_URL/id/$imgUrl/450/270"
        val imgUri2 = imgUrl2.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri2)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.eror))
            .into(imgView)
    }
}