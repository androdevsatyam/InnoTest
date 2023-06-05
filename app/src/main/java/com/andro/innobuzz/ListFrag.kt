package com.andro.innobuzz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.innobuzz.databinding.FragmentListBinding
import com.andro.innobuzz.adapter.ListAdapter
import com.andro.innobuzz.api.Connect
import com.andro.innobuzz.db.MyDatabase
import com.andro.innobuzz.db.UserData
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFrag : Fragment() {
    val TAG = "ListFrag"

    lateinit var listFragBinding: FragmentListBinding
    lateinit var mydb: MyDatabase
    lateinit var adapter: ListAdapter
    lateinit var list:List<UserData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listFragBinding = FragmentListBinding.inflate(inflater, container, false)

        mydb = MyDatabase.getDatabases(requireContext())
        listFragBinding.list.layoutManager = LinearLayoutManager(requireContext())
        listFragBinding.list.setHasFixedSize(true)

        getData()
        return listFragBinding.root
    }

    private fun getData() {
        Connect().getInstance().getData().enqueue(object : Callback<List<UserData>> {
            override fun onResponse(
                call: Call<List<UserData>>,
                response: Response<List<UserData>>
            ) {
                Log.d(TAG, "onResponse: ")
                if (response.body() != null) {
                        lifecycleScope.launch{
                            list=response.body()!!
                            saveInDB()
                        }
                } else {
                    Global.makeToast(requireContext(), "Data not received")
                }
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }

        })
    }

    fun saveInDB() {
        Log.d(TAG, "saveInDB: ")
        lifecycleScope.launch {
            val data = mydb.userDataDao().getAllUser()
            if (data.size != list.size) {
                showList(list)
            }else {
                mydb.userDataDao().insertAllUsers(list)
                showList(list)
            }
        }
    }

    private fun showList(list: List<UserData>) {
        listFragBinding.list.adapter = ListAdapter(list, requireContext())
    }

    fun showDetail(){

    }
}