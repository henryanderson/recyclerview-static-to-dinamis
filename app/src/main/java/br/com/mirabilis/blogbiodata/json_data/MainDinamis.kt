package br.com.mirabilis.blogbiodata.json_data

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mirabilis.blogbiodata.ModelBiodata
import br.com.mirabilis.blogbiodata.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainDinamis : AppCompatActivity() {

    private val TAG: String = MainDinamis::class.java.canonicalName!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface: ApiInterface = ApiKlien.ambilKlien().create(ApiInterface::class.java)

        recycler_view.layoutManager = LinearLayoutManager(this@MainDinamis)

        load(apiInterface)
    }


    fun load(apiInterface: ApiInterface) {

        val call : Call<List<ModelBiodata>> = apiInterface.getMhs()

        call.enqueue(object : Callback<List<ModelBiodata>> {
            override fun onResponse(call: Call<List<ModelBiodata>>?, response: Response<List<ModelBiodata>>?) {

                val data = response?.body() as ArrayList<ModelBiodata>
                recycler_view.adapter = AdapterDinamis(data)

                Log.d("$TAG", "result true ${response!!.body()}")

            }

            override fun onFailure(call: Call<List<ModelBiodata>>, t: Throwable) {
                Log.d("$TAG", "result false " + t)
            }

        })
    }


}