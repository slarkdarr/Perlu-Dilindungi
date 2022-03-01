package com.example.perludilindungi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.example.perludilindungi.databinding.ActivityMainBinding
import com.example.perludilindungi.ui.fragments.NewsListFragment

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
//    private val bookmarkFragment = BookmarkFragment()
//    private val daftarFaksesFragment = DaftarFaksesFragment()
    private val newsListFragment = NewsListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(newsListFragment)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.navigation_news_list -> replaceFragment(newsListFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }

}