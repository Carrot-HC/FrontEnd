package com.softsquared.template.kotlin.src.main.home

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.category.CategoryActivity
import com.softsquared.template.kotlin.src.main.home.models.HomeResponse
import com.softsquared.template.kotlin.src.main.home.models.HomeService2
import com.softsquared.template.kotlin.src.main.home.models.ResultHome
import com.softsquared.template.kotlin.src.main.home.models.ResultProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //HomeService(this).tryGetHome(5)

        binding.homeBtnPlus.setOnClickListener {
            val pop = PopupMenu(context, it, Gravity.END,0,R.style.popup_style_right_end)
            pop.inflate(R.menu.menu_home_popup)

            pop.setOnMenuItemClickListener { item ->

                when (item.itemId) {

                }
                true
            }
            pop.setForceShowIcon(true)
            pop.show()
            true
        }

        binding.homeTopBtnCategory.setOnClickListener {
            val intent = Intent(context, CategoryActivity::class.java)
            startActivity(intent)

        }




        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.sandy1017.shop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val homeService = retrofit.create(HomeService2::class.java)

        homeService.getHome(4, "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4Ijo0LCJpYXQiOjE2NzE3NTM1MjgsImV4cCI6MTY3MzIyNDc1N30.wnSucJ0011DLb32WclUie4d1Y4MXDJJzE9DrIeXYKEA")
            .enqueue(object : Callback<HomeResponse> {
                override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                    Log.d("home", response.body().toString())
                    if (response.isSuccessful) {
                        val body = response.body()
                        body?.let {
                            setAdapter(it.result.productLists as ArrayList<ResultProduct>)

                        }
                    }

                }

                override fun onFailure(call: Call<HomeResponse>, t: Throwable) {

                }
            })
        return binding.root


    }

    private fun setAdapter(homeList : ArrayList<ResultProduct>){
        val mAdapter = HomeAdapter(homeList, this )
        binding.homeListRv.adapter = mAdapter
        binding.homeListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.homeListRv.setHasFixedSize(false)


        mAdapter.setOnItemClickListener(object : HomeAdapter.OnItemClickListener{
            override fun onClick(position: Int) {
                val intent = Intent(activity, HomeListActivity::class.java)
                val temp = homeList[position].productIdx

                Log.d("dddd", temp.toString())
                intent.putExtra("productIdx", temp)
                startActivity(intent)
            }
        })
    }




    /*override fun onGetHomeSuccess(response: HomeResponse) {


    }

    override fun onGetHomeFailure(message: String) {
        //dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    private fun setAdapter(homeList: ArrayList<ResultProduct>){
        val mAdapter = HomeAdapter(homeList, this)
        binding.homeListRv.adapter = mAdapter
        binding.homeListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.homeListRv.setHasFixedSize(false)
    }*/




}