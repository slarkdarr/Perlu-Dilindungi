package com.example.perludilindungi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.perludilindungi.databinding.ActivityMainBinding
import com.example.perludilindungi.ui.fragments.BookmarkFragment
import com.example.perludilindungi.ui.fragments.CheckInFragment
import com.example.perludilindungi.ui.fragments.DaftarFaksesFragment
import com.example.perludilindungi.ui.fragments.NewsListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val bookmarkFragment = BookmarkFragment()
    private val daftarFaksesFragment = DaftarFaksesFragment()
    private val newsListFragment = NewsListFragment()
    private val checkInFragment = CheckInFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(newsListFragment)

        binding.buttonA.setOnClickListener {
            replaceFragment(checkInFragment)
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.navigation_news_list -> replaceFragment(newsListFragment)
                R.id.navigation_daftar_fakses -> replaceFragment(daftarFaksesFragment)
                R.id.navigation_bookmark -> replaceFragment(bookmarkFragment)
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
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
}