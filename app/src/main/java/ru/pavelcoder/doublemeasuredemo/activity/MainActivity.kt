package ru.pavelcoder.doublemeasuredemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import ru.pavelcoder.doublemeasuredemo.MeasurePassCounter
import ru.pavelcoder.doublemeasuredemo.R
import ru.pavelcoder.doublemeasuredemo.adapter.LayoutTestsAdapter

class MainActivity : AppCompatActivity() {

    private val tests = listOf(
        LayoutTest("Just view (1)", R.layout.test_single_view),
        LayoutTest("Relative layout (2)", R.layout.test_relative),
        LayoutTest("5 Relative layout (32)", R.layout.test_five_relative),
        LayoutTest("Frame layout one child (1)", R.layout.test_frame_layout_single),
        LayoutTest("Frame layout match_parent/match_parent (1)", R.layout.test_frame_layout_mm),
        LayoutTest("Frame layout match_parent/wrap_content (2)", R.layout.test_frame_layout_mw),
        LayoutTest("Linear layout (1)", R.layout.test_linear),
        LayoutTest("Linear layout with WEIGHT (2)", R.layout.test_linear_weight),
        LayoutTest("Constraint (1)", R.layout.test_constraint),
        LayoutTest("Constraint, width=0dp (2)", R.layout.test_constraint_0dp)
    )

    private var measurer: MeasurePassCounter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        amRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        amRecycler.adapter = LayoutTestsAdapter(tests) { test ->
            startActivity(LayoutTestActivity.createIntent(test, this))
        }
    }
}
