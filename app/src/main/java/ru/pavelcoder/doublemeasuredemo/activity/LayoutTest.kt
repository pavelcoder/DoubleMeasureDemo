package ru.pavelcoder.doublemeasuredemo.activity

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import ru.pavelcoder.doublemeasuredemo.R
import java.io.Serializable

data class LayoutTest(
    val description: String,
    @LayoutRes val layoutId: Int,
    @IdRes val testViewId: Int = R.id.testView
): Serializable