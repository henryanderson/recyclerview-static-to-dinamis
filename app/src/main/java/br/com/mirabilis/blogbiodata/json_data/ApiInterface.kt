package br.com.mirabilis.blogbiodata.json_data

import br.com.mirabilis.blogbiodata.ModelBiodata
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("biodata.php")  //end point
    fun getMhs() : Call<List<ModelBiodata>>

}