package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Pin
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun registerScreen(padding: PaddingValues) {
    val fieldsPaddings = 16.dp
    val ButtonsPadding = 8.dp
    Surface(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()

    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            var MaxWidght = maxWidth

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                //Spacer(Modifier.height(12.dp))

                Text(
                    text = "Cadastro",
                    modifier = Modifier.padding(all = fieldsPaddings),
                    style = MaterialTheme.typography.headlineMedium,
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(all = fieldsPaddings)
                        .fillMaxWidth(0.9f),
                    label = { Text("Name") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.AccountBox,
                            contentDescription = null
                        )
                    }
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(all = fieldsPaddings)
                        .fillMaxWidth(0.9f),
                    label = { Text("CPF/CNPJ") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Pin,
                            contentDescription = null
                        )
                    }
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(all = fieldsPaddings)
                        .fillMaxWidth(0.9f),
                    label = { Text("Telefone") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Call,
                            contentDescription = null
                        )
                    }
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(all = fieldsPaddings)
                        .fillMaxWidth(0.9f),
                    label = { Text("Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = null
                        )
                    }
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .size(56.dp)
                ) {
                    //limpar
                    FilledTonalButton(
                        onClick = {},
                        modifier = Modifier
                            .size(width = (MaxWidght.value * 0.4f).dp, 40.dp)
                            .padding(start = ButtonsPadding, end = ButtonsPadding),
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer,
                            contentColor = MaterialTheme.colorScheme.onErrorContainer,
                            disabledContainerColor = MaterialTheme.colorScheme.error,
                            disabledContentColor = MaterialTheme.colorScheme.onError
                        )

                    ) {
                        Text("Limpar")
                    }
                    ElevatedButton(
                        onClick = {}, modifier = Modifier
                            .size(width = (MaxWidght.value * 0.4f).dp, 40.dp)
                            .padding(start = ButtonsPadding, end = ButtonsPadding),
                        colors = ButtonColors(
                            containerColor = Color(0xFF90ee90),
                            contentColor = Color(0xFF6f116f),
                            disabledContainerColor = Color(0xFF99e599),
                            disabledContentColor = Color(0xFF661a66)
                        )

                    ) {
                        Text("Cadastrar")
                    }

                }


            }
        }
    }
}