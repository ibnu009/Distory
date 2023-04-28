package com.ibnu.distory.base.component

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.ibnu.distory.R

class PasswordEditText : AppCompatEditText {

    private var charLength = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    /// JANGAN DIPAKE !
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        hint = context.getString(R.string.hint_password)
//        context.apply {
//            background = ContextCompat.getDrawable(this, R.drawable.bg_bordered_edit_text)
//        }
//        isSingleLine = true
//        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
//    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //Do Nothing
            }

            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                charLength = s.length
                if (charLength == 0) return
                error =
                    if (charLength < 8) context.getString(R.string.validation_password) else null
            }

            override fun afterTextChanged(edt: Editable?) {
                //Do Nothing
            }
        })
    }
}