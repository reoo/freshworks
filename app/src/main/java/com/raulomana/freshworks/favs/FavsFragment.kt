package com.raulomana.freshworks.favs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.raulomana.freshworks.R
import com.raulomana.freshworks.db.AppDB
import com.raulomana.freshworks.db.DBRepository
import com.raulomana.freshworks.db.RoomRepository
import com.raulomana.freshworks.di.InjectorUtils
import javax.inject.Inject

class FavsFragment : Fragment() {
    @Inject
    lateinit var repository: DBRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InjectorUtils.getInjector(this).inject(this)

        arguments?.let {
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_favs, container, false)



//        appDB.favoriteDao().getAll().observe(this,  Observer { list ->
//
//
//        })

        return inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository.getFavorites().subscribe({
            Toast.makeText(requireActivity(), "Favs: ${it.size}", Toast.LENGTH_LONG).show()
        }, {
            it.printStackTrace()
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FavsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}