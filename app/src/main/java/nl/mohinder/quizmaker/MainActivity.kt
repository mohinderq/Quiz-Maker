package nl.mohinder.quizmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(QuizViewModel::class.java)
        initNavigation()
    }

    private fun initNavigation() {
        val navController : NavController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(
            this, navController, appBarConfiguration)

    }
}
