package com.example.apitest

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setText")
fun setText(textView: TextView, string: String) {
    textView.text = string
}

@BindingAdapter("setTextFromInt")
fun setTextFromInt(textView: TextView, int: Int) {
    textView.text = "$int"
}

@BindingAdapter("setImage")
fun setImage(view: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(view)
}

//@BindingAdapter("setImage")
//fun setImage(view: ImageView, @DrawableRes avatar: Int) {
//    view.setBackgroundResource(avatar)
//}




