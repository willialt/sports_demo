package com.lucas.sportsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.sportsdemo.ui.theme.LeaguePage
import com.lucas.sportsdemo.ui.theme.SportsDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sportsViewModel = ViewModelProvider(this)[SportsViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            SportsDemoTheme {
                LeaguePage(sportsViewModel)
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    SportsDemoTheme {
//        LeaguePage()
//    }
//}