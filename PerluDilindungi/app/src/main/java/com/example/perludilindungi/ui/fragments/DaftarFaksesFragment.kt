package com.example.perludilindungi.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perludilindungi.R
import com.example.perludilindungi.data.api.RetrofitBuilder
import com.example.perludilindungi.data.model.City
import com.example.perludilindungi.data.model.Fakses
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.data.model.Province
import com.example.perludilindungi.databinding.FragmentDaftarFaksesBinding
import com.example.perludilindungi.ui.adapter.DaftarFaksesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DaftarFaksesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DaftarFaksesFragment : Fragment() {
    private var _binding : FragmentDaftarFaksesBinding? =null
    private val binding get() = _binding!!

    private var chosenProvince : String? = null
    private var chosenCity : String? = null

    private var data: Fakses? = null
    private var daftarFaksesAdapter: DaftarFaksesAdapter? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDaftarFaksesBinding.inflate(layoutInflater)
        setupProvinceSpinner()
        binding.buttonSearchFakses.setOnClickListener{
            if (chosenProvince !=null && chosenCity != null){
                setupDaftarFakses(chosenProvince!!, chosenCity!!)
            }
        }

        binding.rvFakses.layoutManager = LinearLayoutManager(activity)
        Log.d("TAG","INSERT DATA::: $data")
        binding.rvFakses.adapter = DaftarFaksesAdapter(data)
        return binding.root
    }
    private fun setupDaftarFakses(province: String, city: String){
        // Inflate the layout for this fragment
        RetrofitBuilder().getRetrofit()
            .getFakses(province,city)
            .enqueue(object: Callback<Fakses>{
                override fun onResponse(
                    call: Call<Fakses>,
                    response: Response<Fakses>) {
                    Log.d("TAG","Response Hitted!!!!")
                    data = response.body()
                    binding.rvFakses.adapter = DaftarFaksesAdapter(response.body()!!)
                    Log.d("TAG","Response::: ${data?.results}")
                }

                override fun onFailure(
                    call: Call<Fakses>,
                    t: Throwable) {

                    Log.e("tag","Errrorrr!!! ${t.localizedMessage}")
                }

            })
    }
    private fun setupCitySpinner(province: String){
        var cityArray : Array<String>? = null
        RetrofitBuilder().getRetrofit()
            .getCity(province)
            .enqueue(object: Callback<City>{
                override fun onFailure(call: Call<City>, t: Throwable) {
                    Log.e("tag","Errrorrr!!! ${t.localizedMessage}")
                }

                override fun onResponse(call: Call<City>, response: Response<City>) {
                    cityArray =  response.body()!!.results.map { it.key }.toTypedArray()
                    binding.spinnerCity.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,
                        cityArray!!
                    )

                }
            })
        binding.spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent:  AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ){
                chosenCity = cityArray!![position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // TODO("Not yet implemented")
            }
        }
    }

    private fun setupProvinceSpinner(){
        var provinceArray : Array<String>? = null
        RetrofitBuilder().getRetrofit()
            .getProvince()
            .enqueue(object: Callback<Province>{
                override fun onFailure(call: Call<Province>, t: Throwable) {
                    Log.e("tag","Errrorrr!!! ${t.localizedMessage}")
                }

                override fun onResponse(call: Call<Province>, response: Response<Province>) {
                    provinceArray =  response.body()!!.results.map { it.key }.toTypedArray()
                    binding.spinnerProvince.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,
                        provinceArray!!
                    )

                }
            })
        binding.spinnerProvince.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent:  AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ){
                setupCitySpinner(provinceArray!![position])
                chosenProvince = provinceArray!![position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // TODO("Not yet implemented")
            }
        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DaftarFaksesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DaftarFaksesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}