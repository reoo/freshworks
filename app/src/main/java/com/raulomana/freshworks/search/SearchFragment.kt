package com.raulomana.freshworks.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.raulomana.api.http.ApiClient
import com.raulomana.freshworks.BuildConfig
import com.raulomana.freshworks.databinding.FragmentSearchBinding
import com.raulomana.freshworks.db.AppDB
import com.raulomana.freshworks.db.DBRepository
import com.raulomana.freshworks.db.RoomRepository
import com.raulomana.freshworks.di.InjectorUtils
import com.raulomana.freshworks.favs.Favorite
import com.raulomana.freshworks.list.GIFAdapter
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var repository: DBRepository
    @Inject
    lateinit var apiClient: ApiClient
    private lateinit var disposable: Disposable
    lateinit var binding: FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InjectorUtils.getInjector(this).inject(this)


        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchViewAnimator.displayedChild = VA_LOADING_STATE
        disposable = apiClient.getTrending(BuildConfig.giphyApiKey).subscribe({ list ->
            binding.searchListResults.apply {
                adapter = GIFAdapter(list) { gif ->
                    repository.addFavorite(gif).subscribe({

                    }, {
                        it.printStackTrace()
                    })
                }
                layoutManager = GridLayoutManager(requireActivity(), COLUMNS)
            }
            binding.searchViewAnimator.displayedChild = VA_CONTENT_STATE
        }, { error ->
            error.printStackTrace()
            binding.searchViewAnimator.displayedChild = VA_EMPTY_STATE
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        if(!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SearchFragment().apply {
                arguments = Bundle().apply {
                }
            }

        private const val VA_CONTENT_STATE = 0
        private const val VA_LOADING_STATE = 1
        private const val VA_EMPTY_STATE = 2

        private const val COLUMNS = 2
    }
}