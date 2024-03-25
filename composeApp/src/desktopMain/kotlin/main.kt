
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import desktopCompose.mainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "bpSuite") {
        //App()
        mainScreen()
        //loginScreen()
    }
}
@Composable
@Preview
fun mainPreview(){

}