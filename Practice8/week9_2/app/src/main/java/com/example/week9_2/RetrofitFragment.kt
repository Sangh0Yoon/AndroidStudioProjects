package com.example.week9_2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week9_2.model.PageListModel
import com.example.week9_2.recycler.MyAdapter
import com.example.week9_2.databinding.FragmentRetrofitBinding
import com.example.week9_2.model.ItemModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRetrofitBinding.inflate(inflater, container, false)
        var datas = mutableListOf<ItemModel>()
        //............................
        val call: Call<PageListModel> = MyApplication.networkService.getList(
            MyApplication.QUERY,
            MyApplication.API_KEY,
            1,
            10
        )
        call?.enqueue(object : Callback<PageListModel> {
            override fun onResponse(
                call: Call<PageListModel>,
                response: Response<PageListModel>
            ) {
                if (response.isSuccessful()) {
                    /* Recycler View 관련 처리 */
                    var list = response.body()!!.articles
                    for (i in 0 until list!!.size) {
                        datas.add(list[i])
                    }
                    binding.retrofitRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                    binding.retrofitRecyclerView.adapter = MyAdapter(requireContext(),datas)
                    binding.retrofitRecyclerView.addItemDecoration(DividerItemDecoration(
                        requireContext(), LinearLayoutManager.VERTICAL))
                }
            }

            override fun onFailure(
                call: Call<PageListModel?>,
                t: Throwable
            ) {
            }
        })
        return binding.root
    }


}