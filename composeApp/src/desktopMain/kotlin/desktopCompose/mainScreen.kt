package desktopCompose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bpsuite.composeapp.generated.resources.Res
import bpsuite.composeapp.generated.resources.logo_borges160x160
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.vectorResource
import theme.applyTheme

@Composable
fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }


private data class AppFeature(
    val name: String,
    val icon: ImageVector,
    val content: @Composable () -> Unit
)


private var appFeatures = arrayListOf(
    AppFeature("Cadastro", Icons.Default.Face) {},
    AppFeature("Consulta", Icons.AutoMirrored.Filled.List) {},
    AppFeature("Proximos Vencimentos", Icons.Outlined.DateRange, content = {})
)


@OptIn(ExperimentalResourceApi::class)
@Composable
fun mainScreen() {

    var showSidebar by remember { mutableStateOf(false) }

    var surfaceScaleX by remember { mutableStateOf(1f) }
//    var surfaceScaleY by remember { mutableStateOf(1f) }

    val sidebarWidth = (150f * surfaceScaleX).dp
    val sidebarOffset by animateFloatAsState(
        targetValue = if (showSidebar) 0f else -sidebarWidth.value,
        animationSpec = tween(durationMillis = 500)
    )




    applyTheme(forceDarkTheme = true) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
            //.scale(scaleX = surfaceScaleX, scaleY = surfaceScaleY)
            //.aspectRatio(ratio = 0.56f)

        ) {

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background),
                //.scale(0.5f)

            ) {

                surfaceScaleX = maxWidth.value / 1920f
                println(surfaceScaleX)
//                surfaceScaleY = maxHeight.value/1027f
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background)
                    //.scale(0.5f)
                ) {
                    Icon(
                        imageVector = vectorResource(Res.drawable.logo_borges160x160),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxSize(0.5f)
                            .alpha(0.2f)
                    )
                    Box(//shadow
                        modifier = Modifier
                            .offset(
                                x = (sidebarOffset + if (sidebarOffset == (-sidebarWidth.value)) (-5f * surfaceScaleX) else (5f * surfaceScaleX)).dp,
                                y = 5.dp
                            )
                            .fillMaxHeight()
                            .width(sidebarWidth)
                            .background(
                                color = MaterialTheme.colorScheme.scrim,
                                shape = RoundedCornerShape(
                                    topEnd = (15f * surfaceScaleX).dp,
                                    bottomEnd = (15f * surfaceScaleX).dp
                                )
                            )
                    )
                    Box(
                        modifier = Modifier
                            .offset(sidebarOffset.dp)
                            .fillMaxHeight()
                            .width(sidebarWidth)
                            .background(
                                color = MaterialTheme.colorScheme.surfaceBright,
                                shape = RoundedCornerShape(
                                    topEnd = (15f * surfaceScaleX).dp,
                                    bottomEnd = (15f * surfaceScaleX).dp
                                )
                            )

//                        .shadow(elevation = 6.dp,
//                                shape = RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp),
//                                clip = false,
//                                spotColor = MaterialTheme.colorScheme.scrim)
                    ) {
                        val iconHover = remember { MutableInteractionSource() }
                        val isHover by iconHover.collectIsHoveredAsState()
                        IconButton(
                            onClick = { showSidebar = !showSidebar },
                            modifier = Modifier
                                .offset(x = 80.dp)
                                .align(Alignment.CenterEnd),

                            ) {
                            Icon(
                                imageVector = if (showSidebar) Icons.AutoMirrored.Filled.ArrowBack else Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.inverseSurface,
                                modifier = Modifier
                                    .size(40.dp)
                                    .hoverable(iconHover)
                                    .alpha(if (isHover) 1f else 0.05f)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            for (feature in appFeatures) {
                                appIcon(surfaceScaleX, feature)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun appIcon(scaleFactor: Float, appFeature: AppFeature) {
    Box(
        modifier = Modifier

            .size((150f * scaleFactor).dp)
            .padding((20f * scaleFactor).dp)
            //.aspectRatio(ratio = 0.56f)
            .clickable(
                onClick = { appFeature.content }
            )
    ) {
        Box(//Shadow
            modifier = Modifier
                .fillMaxSize()
                .offset(x = (5f * scaleFactor).dp, y = (5f * scaleFactor).dp)
                .background(
                    color = MaterialTheme.colorScheme.scrim,
                    shape = MaterialTheme.shapes.small
                )

        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = MaterialTheme.shapes.small
                ),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxSize()

            ) {
                Icon(
                    imageVector = appFeature.icon, contentDescription = null, modifier = Modifier
                        .fillMaxSize(0.5f)
                )
                Text(text = appFeature.name, textAlign = TextAlign.Center, style = MaterialTheme.typography.bodySmall, fontSize = (15f * scaleFactor).sp)
            }
        }
    }
}

