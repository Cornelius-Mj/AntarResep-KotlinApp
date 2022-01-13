package com.example.uniquelux.home_fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.uniquelux.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.abs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.banner_1))
        sliderItems.add(SliderItem(R.drawable.banner_2))
        sliderItems.add(SliderItem(R.drawable.banner_3))

        val v:View = inflater.inflate(R.layout.fragment_home, container, false)
        val viewPager2 = v.findViewById<ViewPager2>(R.id.homefrag_promo_slide)
        val sliderHandler = Handler()
        val sliderRunnable = Runnable {
            viewPager2.currentItem = viewPager2.currentItem + 1
        }

        viewPager2.adapter = SliderAdapter(sliderItems, viewPager2)
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer{page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.25f
        }
        val WalletBtn = v.findViewById<Button>(R.id.homefrag_wallet_btn)
        WalletBtn.setOnClickListener{
            val IntentWallet = Intent(this.getContext(), WalletPage::class.java)
            startActivity(IntentWallet)
        }
        val SearchBtn = v.findViewById<SearchView>(R.id.homefrag_searchbox)
        SearchBtn.setOnClickListener {
            val IntentSearch = Intent(this.getContext(), SearchPage::class.java)
            startActivity(IntentSearch)
        }
        val NotificationBtn = v.findViewById<ImageView>(R.id.homefrag_notification)
        NotificationBtn.setOnClickListener {
            val IntentNotification = Intent(this.getContext(), NotificationPage::class.java)
            startActivity(IntentNotification)
        }
        val CategoriesBtn = v.findViewById<Button>(R.id.homefrag_categoriesBtn)
        CategoriesBtn.setOnClickListener {
            val IntentCategories = Intent(this.getContext(), CategoryPage::class.java)
            startActivity(IntentCategories)
        }

        viewPager2.setPageTransformer(compositePageTransformer)
        //WelcomeTextColor()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })

        return v;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    private fun WelcomeTextColor() {
        val spannableString = SpannableString("Find Unique cuisine\n here in Uniquelux ")

        val gColor = ForegroundColorSpan(Color.GREEN)
        spannableString.setSpan(gColor, 27, 39, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        homefrag_welcome_text.text = spannableString
    }
}












