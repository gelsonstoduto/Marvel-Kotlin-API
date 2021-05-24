package gstoduto.marvel_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gstoduto.marvel_kotlin.R
import gstoduto.marvel_kotlin.repository.model.Comic
import gstoduto.marvel_kotlin.ui.main.HomeFragment
import kotlinx.android.synthetic.main.lista_my_comics.view.*

class ComicAdapter(l: List<Comic>, c: HomeFragment) :
    RecyclerView.Adapter<ComicAdapter.ViewHolder>() {
    private val mComicList: List<Comic> = l
    private val context: Context? = c.context
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.lista_my_comics, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = mComicList[position]
        val displayMetrics = context!!.resources.displayMetrics
        val height = displayMetrics.heightPixels / 4
        val width = displayMetrics.widthPixels / 2
        Picasso.with(context)
            .load(item.thumbnail?.path + "." + item.thumbnail!!.extension)
            .resize(width, height).centerCrop().into(holder.itemView.fotoComic)
        var sCreators = ""
        for (k in 0 until (item.creators?.items?.size ?: 0)) {
            sCreators += item.creators?.items!![k].name + " (" + item.creators?.items!![k].role + "), "
        }
        if (!sCreators.isEmpty()) {
            sCreators = sCreators.substring(0, sCreators.length - 2)
        }
        var sDates = ""
        for (k in 0..item.dates!!.size - 1) {
            sDates += item.dates!![k].date + " " + context.getString(R.string.type) + item.dates!![k].type + ",  "
        }
        if (!sDates.isEmpty()) {
            sDates = sDates.substring(0, sDates.length - 2)
        }
        var sPrices = ""
        for (k in 0 until item.prices!!.size) {
            sPrices += item.prices!![k].price.toString() + " " + context.getString(R.string.type) + item.prices!![k].type + ",  "
        }
        if (!sPrices.isEmpty()) {
            sPrices = sPrices.substring(0, sPrices.length - 2)
        }

        holder.itemView.txtTitleComic.text = item.title
        holder.itemView.txtCreators.text = context.getString(R.string.label_creators) + sCreators
        holder.itemView.txtDates.text = context.getString(R.string.label_dates) + sDates
        holder.itemView.txtPrices.text = context.getString(R.string.label_prices) + sPrices
        holder.itemView.linearLayoutComics.setOnClickListener {
            val builder =
                AlertDialog.Builder(context)
            builder.setMessage(item.description)
                .setTitle(R.string.description)
            builder.setPositiveButton(
                R.string.fechar
            ) { dialog, id ->
                // User clicked OK button
            }
            val dialog = builder.create()
            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return mComicList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}