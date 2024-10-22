package com.app.mobileware.serviceapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.mobileware.serviceapp.R
import com.app.mobileware.serviceapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity(), AndroidScopeComponent {

    override val scope: Scope by activityScope()

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private var guidesAdapter: CategoriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        setUpAdapters()
        viewModel.getCategories()
        collectFlows()
    }

    private fun collectFlows() {
        with(lifecycleScope) {
            with(viewModel) {
                launch { showLoading.collect { showLoadingCollected(it) } }
                launch { success.collect { successDownloadFileCollected(it) } }
                launch { showError.collect { showErrorCollected(it) } }
            }
        }
    }


    private fun showLoadingCollected(show: Boolean) {

    }

    private fun successDownloadFileCollected(any: List<String>) {
        println("anylist -> $any")
       guidesAdapter?.submitList(any)
    }

    private fun showErrorCollected(typeError: String) {
        binding.root.showSnack(typeError)
    }

    private fun setUpAdapters() {
        guidesAdapter = CategoriesAdapter()
        binding.categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = guidesAdapter
        }
    }

}


fun View.showSnack(message: String, duration: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(this, message, duration).show()
}
