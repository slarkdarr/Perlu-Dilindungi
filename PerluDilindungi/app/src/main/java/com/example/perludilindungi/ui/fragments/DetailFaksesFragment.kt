package com.example.perludilindungi.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.example.perludilindungi.R
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.databinding.FragmentDetailFaksesBinding
import com.example.perludilindungi.ui.viewmodel.DetailFaksesViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFaksesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFaksesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentDetailFaksesBinding ? = null
    private val binding get() = _binding!!
    private lateinit var viewModel:DetailFaksesViewModel
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
        // Inflate the layout for this fragment
        _binding = FragmentDetailFaksesBinding.inflate(inflater, container,false)
        parentFragmentManager.setFragmentResultListener("requestFakses",this,
            FragmentResultListener{ responseFakses,bundle ->
                var result = bundle.getParcelable<FaksesResult>("responseFakses")
                if (result != null) {
                    binding.tvDetailFaksesName.text = result.nama
                    binding.tvDetailFaksesAddress.text = result.alamat
                    binding.tvDetailFaksesCode.text = result.kode
                    binding.tvDetailFaksesStatus.text = result.status
                    binding.tvDetailFaksesTelp.text = result.telp
                    binding.tvDetailFaksesType.text = result.jenisFaskes

                    viewModel = ViewModelProvider(this)[DetailFaksesViewModel::class.java]
                    binding.buttonBookmark.setOnClickListener{
                        viewModel.addBookmark(context!!,result!!){
                            Toast.makeText(context,"Fakses Added To Bookmark", Toast.LENGTH_SHORT).show()

                        }
                    }

                    binding.buttonGoogleMap.setOnClickListener{
                        // Display a label at the location of Google's Sydney office
                        val gmmIntentUri =
                            // Uri.parse("geo:0,0?q=${result!!.latitude},${result!!.longitude}(${result!!.nama})")
                            Uri.parse("geo:${result!!.latitude},${result!!.longitude}?q=${Uri.encode(result!!.nama)}")
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps")
                        startActivity(mapIntent)
                    }
                }
            })

        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFaksesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFaksesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}