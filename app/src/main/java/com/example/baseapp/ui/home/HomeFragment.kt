package com.example.baseapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseapp.R
import com.example.baseapp.ui.home.animes.AnimesAdapter
import com.example.baseapp.ui.home.animes.AnimesViewModel
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: AnimesViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.moviesLiveData.observe(viewLifecycleOwner, Observer { animes ->
            animes.let { anime ->
                with(home_animes_recyclerview){
                    layoutManager = LinearLayoutManager(context)
                    adapter = AnimesAdapter(anime.data)
                }
            }
        })

        viewModel.getAnimes()
    }
}
