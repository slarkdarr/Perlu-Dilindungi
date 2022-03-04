package com.example.perludilindungi.ui.fragments

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perludilindungi.R
import com.example.perludilindungi.data.api.RetrofitBuilder
import com.example.perludilindungi.data.model.City
import com.example.perludilindungi.data.model.Fakses
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.data.model.Province
import com.example.perludilindungi.databinding.FragmentDaftarFaksesBinding
import com.example.perludilindungi.ui.adapter.DaftarFaksesAdapter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Math.pow
import kotlin.math.sqrt

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

    private var data: List<FaksesResult>? = null
    private var daftarFaksesAdapter: DaftarFaksesAdapter? = null

    private val LOCATION_PERMISSION_REQ_CODE = 1000;
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    
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
        // Init binding
        _binding = FragmentDaftarFaksesBinding.inflate(layoutInflater)

        // Get Current Location
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context!!)
        getCurrentLocation()

        // Setup Spinner
        setupProvinceSpinner()
        binding.buttonSearchFakses.setOnClickListener{
            if (chosenProvince !=null && chosenCity != null){
                setupDaftarFakses(chosenProvince!!, chosenCity!!)
            }
        }

        // Setup Recyclerview Adapter
        binding.rvFakses.layoutManager = LinearLayoutManager(activity)
        Log.d("TAG","INSERT DATA::: $data")
        binding.rvFakses.adapter = data?.let {
            DaftarFaksesAdapter(it,DaftarFaksesAdapter.OnClickListener{
                item -> goToDetailFaksesFragment(item)
            })
        }

        // Return view
        return binding.root
    }
    private fun setupDaftarFakses(province: String, city: String){

        RetrofitBuilder().getRetrofit()
            .getFakses(province,city)
            .enqueue(object: Callback<Fakses>{
                override fun onResponse(
                    call: Call<Fakses>,
                    response: Response<Fakses>) {
                    Log.d("TAG","Response Hitted!!!!")
                    data = response.body()!!.results
                    binding.rvFakses.adapter =
                        DaftarFaksesAdapter(
                            filterFakses(response.body()!!.results),
                            DaftarFaksesAdapter.OnClickListener{
                            item -> goToDetailFaksesFragment(item)
                    })
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
                    binding.spinnerCity.adapter = ArrayAdapter(context!!,android.R.layout.simple_spinner_item,
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
                    binding.spinnerProvince.adapter = ArrayAdapter(context!!,android.R.layout.simple_spinner_item,
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
    private fun goToDetailFaksesFragment(faksesResult:FaksesResult){

        parentFragmentManager.commit {
            replace(R.id.fragment_container,DetailFaksesFragment())
        }

        parentFragmentManager.setFragmentResult("requestFakses", bundleOf("responseFakses" to faksesResult))

    }
    private fun getCurrentLocation() {
        // checking location permission
        if (ActivityCompat.checkSelfPermission(context!!,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // request permission
            ActivityCompat.requestPermissions(activity!!,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQ_CODE);

            return
        }

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                // getting the last known or current location
                latitude = location.latitude
                longitude = location.longitude
            }
            .addOnFailureListener {
                Toast.makeText(context!!, "Failed on getting current location",
                    Toast.LENGTH_SHORT).show()
            }
    }
    private fun filterFakses(listFakses: List<FaksesResult>): List<FaksesResult>{
        var sortedList = listFakses.sortedBy { item -> sqrt(pow((item.latitude.toDouble() - latitude), 2.0)+pow((item.longitude.toDouble()  - longitude), 2.0))  }
        sortedList.forEach {item ->
            Log.d("TAG","SORTED LIST VALUE:: ${sqrt(pow((item.latitude.toDouble() - latitude), 2.0)+pow((item.longitude.toDouble()  - longitude), 2.0))}")
        }
        sortedList.subList(0,5).forEach {item ->
            Log.d("TAG","SORTED SUBLIST VALUE:: ${sqrt(pow((item.latitude.toDouble() - latitude), 2.0)+pow((item.longitude.toDouble()  - longitude), 2.0))}")
        }
        return sortedList.subList(0,5)
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