package com.example.perludilindungi.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perludilindungi.data.api.RetrofitBuilder
import com.example.perludilindungi.data.model.News
import com.example.perludilindungi.data.model.NewsResult
import com.example.perludilindungi.databinding.FragmentNewsListBinding
import com.example.perludilindungi.databinding.NewsListItemsBinding
import com.example.perludilindungi.ui.adapter.NewsAdapter
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
class NewsListFragment : Fragment() {
    private var _binding : FragmentNewsListBinding? =null
    private val binding get() = _binding!!

    private var data: NewsResult? = null
    private var newsAdapter: NewsAdapter? = null

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
        _binding = FragmentNewsListBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        RetrofitBuilder().getRetrofit()
            .getNews()
            .enqueue(object: Callback<NewsResult>{
                override fun onResponse(
                    call: Call<NewsResult>,
                    response: Response<NewsResult>) {
                    Log.d("TAG","Response Hitted!!!!")
                    data = response.body()
                    binding.tvNewsList.adapter = NewsAdapter(response.body()!!)
                    Log.d("TAG","Response::: ${data?.results}")

//                    binding.rvFakses.layoutManager = LinearLayoutManager(activity)
//                    binding.rvFakses.adapter = DaftarFaksesAdapter(response.body())


                }

                override fun onFailure(
                    call: Call<NewsResult>,
                    t: Throwable) {

                    Log.e("tag","Errrorrr!!! ${t.localizedMessage}")
                }

            })

        binding.tvNewsList.layoutManager = LinearLayoutManager(activity)
        Log.d("TAG","INSERT DATA::: $data")
        binding.tvNewsList.adapter = NewsAdapter(data)
        return binding.root
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
            NewsListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
