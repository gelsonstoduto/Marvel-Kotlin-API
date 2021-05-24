package gstoduto.marvel_kotlin.dialogs

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import gstoduto.marvel_kotlin.R
import kotlinx.android.synthetic.main.dialog_generic_app.*

class AppDialogGeneric(private val tvMensagem: String, private val tvDetalhe: String) :
    DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout =
            inflater.inflate(R.layout.dialog_generic_app, container, false)
        initViews(layout)
        setListeners()
        return layout
    }

    fun setListeners() {
        btFechar.setOnClickListener { v: View -> activity?.finish() }
    }

    private fun initViews(layout: View) {
        tvMensagemGeneric.text = tvMensagem
        tvMensagemDetalhe.text = tvDetalhe
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window
            ?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(requireContext(), R.color.background_dialog)))
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onResume() {
        super.onResume()
        dialog!!.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }

}