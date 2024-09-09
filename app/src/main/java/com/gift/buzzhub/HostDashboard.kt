package com.gift.buzzhub


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gift.buzzhub.databinding.ActivityHostDashboardBinding

class HostDashboard : AppCompatActivity() {

    lateinit var binding: ActivityHostDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHostDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.hDashboardMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentManager: FragmentManager = supportFragmentManager
        val ft:FragmentTransaction = fragmentManager.beginTransaction()
        val eventsFragment = FirstFragment()




        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstFragment(),"Events")
        adapter.addFragment(SecondFragment(),"Analytics")
        adapter.addFragment(ThirdFragment(),"Financials")

        binding.viewPager.adapter = adapter
        binding.tbLayout.setupWithViewPager(binding.viewPager)

        val hostId = intent.getStringExtra("hostId")
        val hostEvents = intent.getStringExtra("hostEvents")
        val hostName = intent.getStringExtra("hostName")

        val eventsBundle = Bundle()
        eventsBundle.putString("hostId",hostId)
        eventsBundle.putString("hostEvents",hostEvents)
        eventsBundle.putString("hostName",hostName)
        eventsFragment.arguments = eventsBundle
    }
}