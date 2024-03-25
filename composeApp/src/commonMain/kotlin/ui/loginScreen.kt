package ui
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import bpsuite.composeapp.generated.resources.Res
import bpsuite.composeapp.generated.resources.logo_borges160x160
import getPlatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.vectorResource
import theme.applyTheme


val Platform = getPlatform()


//@Composable
@OptIn(ExperimentalResourceApi::class)
@Composable
fun loginScreen() {
    applyTheme(forceDarkTheme = true) {
        println(Platform.name)
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {

            BoxWithConstraints(
                Modifier.fillMaxSize()
                    .background(
                        color = MaterialTheme.colorScheme.background
                    )
            ) {
                val scaleFactor = maxHeight.value / 1080f
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background)
                ) {
                    Icon(
                        imageVector = vectorResource(Res.drawable.logo_borges160x160),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight(0.4f)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight(0.8f)
                            .background(
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                shape = MaterialTheme.shapes.medium
                            )
                            .clip(MaterialTheme.shapes.medium)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = MaterialTheme.colorScheme.onSurfaceVariant)
                        )
                        {
                            TextField(
                                modifier = Modifier
                                    .padding(15 .dp)
                                    .size(
                                        width = (300f * scaleFactor).dp,
                                        height = (50f * scaleFactor).dp
                                    ),
                                label = {
                                    Text(
                                        text = "Usuário",
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier
                                            //.align(Alignment.Top)
                                            .scale(scaleFactor)

                                    )
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.AccountCircle,
                                        contentDescription = null
                                    )
                                },
                                value = "",
                                onValueChange = {},
                            )
                            TextField(
                                //Password
                                modifier = Modifier
                                    .padding(15.dp)
                                    .size(
                                        width = (300f * scaleFactor).dp,
                                        height = (50f * scaleFactor).dp
                                    ),
                                label = {
                                    Text(
                                        text = "Senha",
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier
                                            .align(Alignment.CenterHorizontally)
                                            .scale(scaleFactor)
                                    )
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = null
                                    )
                                },
                                value = "",
                                onValueChange = {},
                            )
                            val buttonColors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surfaceBright
                            )
                            TextButton(
                                onClick = {},
                                contentPadding = PaddingValues(0.dp),
                                modifier = Modifier
                                    .background(
                                        color = MaterialTheme.colorScheme.surfaceBright,
                                        shape = MaterialTheme.shapes.small
                                    )
                                    .padding(15.dp)
                                    .size(
                                        width = (150f * scaleFactor).dp,
                                        height = (50f * scaleFactor).dp
                                    ),
                                colors = buttonColors,
                            ) {
                                Text(
                                    text = "Login",
                                    color = MaterialTheme.colorScheme.onSurface,
                                    textAlign = TextAlign.Center,
//                                    modifier = Modifier
//                                        .fillMaxSize()
                                        //.align(Alignment.CenterVertically)


                                )
                            }
//                            Button(
//                                onClick = {},
//                                modifier = Modifier
//                                    .background(
//                                        color = MaterialTheme.colorScheme.surfaceBright,
//                                        shape = MaterialTheme.shapes.small
//                                    )
//                                    .size(
//                                        width = (150f * scaleFactor).dp,
//                                        height = (50f * scaleFactor).dp
//                                    ),
//                                colors = buttonColors,
//                            ) {
//
//                            }
                        }
                    }

                }

            }
        }
    }
}
