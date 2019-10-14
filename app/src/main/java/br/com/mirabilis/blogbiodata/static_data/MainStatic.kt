package br.com.mirabilis.blogbiodata.static_data

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mirabilis.blogbiodata.ModelBiodata
import br.com.mirabilis.blogbiodata.R
import kotlinx.android.synthetic.main.activity_main.*

class MainStatic : AppCompatActivity() {

    private var adapter: AdapterStatic? = null
    private var dataArrayList: ArrayList<ModelBiodata>? = null

    private val recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tambahData()

        adapter = AdapterStatic(dataArrayList)

        val layoutManager = LinearLayoutManager(this@MainStatic)
        recycler_view.setLayoutManager(layoutManager)

        recycler_view.setAdapter(adapter)
    }

    fun tambahData() {
        dataArrayList = ArrayList()
        dataArrayList!!.add(ModelBiodata("Jono", "berenang", "0892472424424"))
        dataArrayList!!.add(ModelBiodata("Lono", "makan siomai", "0892472424000"))
        dataArrayList!!.add(ModelBiodata("Budi", "mandi", "08924724244111"))
    }

}
