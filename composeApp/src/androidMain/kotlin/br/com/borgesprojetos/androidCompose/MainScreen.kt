package br.com.borgesprojetos.androidCompose

//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import moe.tlaster.precompose.PreComposeApp
import theme.applyTheme
import ui.registerScreen

@Composable
private fun test(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    NavigationDrawerItem(
        icon = {
            Icon(
                Icons.Filled.Lock,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        },
        label = {
            Text(
                "Test",
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        selected = false,
        onClick = {
            scope.launch { drawerState.close() }
        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    applyTheme(forceDarkTheme = true) {
        val scope = rememberCoroutineScope()
        var drawerState = rememberDrawerState(DrawerValue.Closed)
        //var updateState by mutableStateOf(false)
        PreComposeApp {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
            ) {
                Log.i("MainScreen", "MainScreen:${drawerState.currentOffset} ")
                ModalNavigationDrawer(
                    gesturesEnabled = true,
                    //modifier = Modifier.zIndex(if(drawerState.currentOffset == -945f)0.1f else 2f),
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet() {
                            Spacer(Modifier.height(12.dp))
                            test(drawerState)
                            test(drawerState)
                            test(drawerState)
                            test(drawerState)
                        }
                    }
                ) {
                    Scaffold(topBar = {
                        CenterAlignedTopAppBar(
                            //modifier = Modifier.zIndex(if(drawerState.currentOffset == -945f)2f else 0.1f),
                            title = {
                                Text(
                                    text = "BpSuite",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    Log.i("MainScreen", "OnClick:Click")
                                    scope.launch { drawerState.open() }
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.AccountCircle,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            },
                        )
                    }
                    ) {
                        Spacer(Modifier.height(64.dp))
                        registerScreen(it)
                    }

                }
            }
        }
    }
}