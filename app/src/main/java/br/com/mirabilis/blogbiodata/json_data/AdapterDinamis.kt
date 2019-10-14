package br.com.mirabilis.blogbiodata.json_data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.mirabilis.blogbiodata.ModelBiodata
import br.com.mirabilis.blogbiodata.R

//kita ganti ke list
class AdapterDinamis(private val list: ArrayList<ModelBiodata>?) :
    RecyclerView.Adapter<AdapterDinamis.BioHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BioHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_biodata, parent, false)
        return BioHolder(view)
    }

    override fun onBindViewHolder(holder: BioHolder, position: Int) {
        holder.txtNama.setText(list!![position].nama)
        holder.txtHobi.setText(list!![position].hobi)
        holder.txtNoHp.setText(list!![position].nohp)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class BioHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNama: TextView
        val txtHobi: TextView
        val txtNoHp: TextView

        init {
            txtNama = itemView.findViewById(R.id.txt_nama)
            txtHobi = itemView.findViewById(R.id.txt_hobi)
            txtNoHp = itemView.findViewById(R.id.txt_nohp)
        }
    }
}
