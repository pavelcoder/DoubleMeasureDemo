package ru.pavelcoder.doublemeasuredemo.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ru.pavelcoder.doublemeasuredemo.R
import ru.pavelcoder.doublemeasuredemo.view.CallType
import ru.pavelcoder.doublemeasuredemo.view.TestView
import ru.pavelcoder.doublemeasuredemo.view.ViewLogger

class LayoutTestActivity : Activity(), ViewTreeObserver.OnGlobalLayoutListener {
    companion object {
        private const val PAYLOAD = "PAYLOAD"
        fun createIntent(params: LayoutTest, context: Context): Intent {
            return Intent(context, LayoutTestActivity::class.java).apply {
                putExtra(PAYLOAD, params)
            }
        }
    }

    private val params by lazy {
        intent?.getSerializableExtra(PAYLOAD) as LayoutTest
    }

    private val testView by lazy {
        findViewById<TestView>(params.testViewId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(params.layoutId)
        testView.viewTreeObserver.addOnGlobalLayoutListener(this)
    }

    private var measureCountBetweenLayout = 0

    override fun onGlobalLayout() {
        testView.viewTreeObserver.removeOnGlobalLayoutListener(this)
        testView.logger = object : ViewLogger {
            override fun log(type: CallType) {
                Log.d("TestView", "LayoutTestActivity@${hashCode()}: ${type.name}")
                when(type) {
                    CallType.MEASURE -> {
                        measureCountBetweenLayout++
                    }
                    CallType.LAYOUT -> {
                        showSnackbar(measureCountBetweenLayout)
                        measureCountBetweenLayout = 0
                    }
                    CallType.DRAW -> {

                    }
                }
            }
        }
        testView.requestLayout()
    }

    private fun showSnackbar(count: Int) {
        val contextView = findViewById<ViewGroup>(android.R.id.content)
        Snackbar.make(contextView, "Measure called $count times", Snackbar.LENGTH_INDEFINITE).show()
    }
}