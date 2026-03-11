package valenzuela.isabel.pokecompose_valenzuelaisabel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import valenzuela.isabel.pokecompose_valenzuelaisabel.R

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    // variables
    var username by remember {
        mutableStateOf("") // Para no tener que usar el .value
    }

    var password by remember {
        mutableStateOf("")
    }

    // Flags para error
    var errorUsuario by remember {
        mutableStateOf(false)
    }
    var errorPassword by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(R.drawable.pokeball),
            contentDescription = "Ícono de Pokeball",
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp)
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text = "Inicio de sesión",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = FontFamily.Serif
            )
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        ) // Espacio con altura

        // Campo de username
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                errorUsuario = false},
            label = { // placeholder
                Text(text = "Nombre de usuario")
            },
            isError = errorUsuario,
            supportingText = {
                if (errorUsuario) {
                    Text("El usuario no puede estar vacío")
                }
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        // Campo de contraseña
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorPassword = false},
            isError = errorPassword,
            supportingText = {
                if (errorPassword) {
                    Text("La contraseña no puede estar vacía")
                }
            },
            label = { // placeholder
                Text(text = "Contraseña")
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // Botón para iniciar sesión
        Button(
            onClick = {
                errorUsuario = username.isBlank()
                errorPassword = password.isBlank()

                if (!errorUsuario && !errorPassword) {
                    onLoginSuccess()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFBE7EA8)
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Iniciar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {}
    )
}
