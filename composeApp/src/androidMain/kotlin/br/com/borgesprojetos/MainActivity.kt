package br.com.borgesprojetos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.borgesprojetos.androidCompose.MainScreen
import ui.loginScreen

//import java.lang.reflect.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //App()
            MainScreen()
            //loginScreen()

        }
    }
}


@Preview
@Composable
fun AppAndroidPreview() {
//    App()
    loginScreen()
}

