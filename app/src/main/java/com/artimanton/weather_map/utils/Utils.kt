package com.artimanton.weather_map.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Utils {
    companion object {
    @JvmStatic @BindingAdapter(value = ["imageUrl", "errorImage"], requireAll = false)
    fun loadImage(view: ImageView, url: String?, errorImage: Drawable?) {
        if (url == null) {
            view.setImageDrawable(errorImage);
        } else {
            Glide.with(view.context)
                .load(url)
                .error(errorImage)
                .into(view)}
        }
    }
}