package com.example.perludilindungi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perludilindungi.R
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.databinding.FragmentBookmarkBinding
import com.example.perludilindungi.databinding.FragmentDaftarFaksesBinding
import com.example.perludilindungi.ui.adapter.BookmarkAdapter
import com.example.perludilindungi.ui.viewmodel.BookmarkViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookmarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookmarkFragment : Fragment() {
    private var _binding : FragmentBookmarkBinding? =null
    private val binding get() = _binding!!
    private lateinit var  bookmarkAdapter: BookmarkAdapter
    private  lateinit var bookmarkViewModel: BookmarkViewModel

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
        _binding = FragmentBookmarkBinding.inflate(layoutInflater)

        bookmarkAdapter = BookmarkAdapter(
            BookmarkAdapter.OnClickListener{
                item -> goToDetailFaksesFragment(item)
        })
        bookmarkViewModel = ViewModelProvider(this)[BookmarkViewModel::class.java]
        // Inflate the layout for this fragment
        binding.rvBookmark.apply {
            layoutManager= LinearLayoutManager(activity)
            adapter = bookmarkAdapter
        }
        bookmarkViewModel.bookmarks.observe(this,{
            bookmarkAdapter.setData(it)
        })
        bookmarkViewModel.getBookmark(context!!)

        return binding.root
    }

    private fun goToDetailFaksesFragment(faksesResult: FaksesResult){

        parentFragmentManager.commit {
            replace(R.id.fragment_container,DetailFaksesFragment())
        }

        parentFragmentManager.setFragmentResult("requestFakses", bundleOf("responseFakses" to faksesResult))

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookmarkFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookmarkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}