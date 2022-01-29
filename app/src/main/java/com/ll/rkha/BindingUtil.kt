package com.ll.rkha

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:long")
fun setLongValue(view : TextView, value : Long) {
    view.setText(value.toString())
}