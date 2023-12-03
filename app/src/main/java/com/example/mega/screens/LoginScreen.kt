@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mega.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.mega.DataStoreManager
import com.example.mega.UserInfo
import com.example.mega.baseUrl
import com.example.mega.components.CompanyShareModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONException

@Composable
fun LoginScreen(dataStoreManager: DataStoreManager) {
    val context = LocalContext.current

    val corutine = rememberCoroutineScope()

    var userInfo = remember {
        mutableStateOf(UserInfo(false, "", ""))
    }

    var login = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = true) {
        dataStoreManager.getAuthInfo().collect { info ->
            userInfo.value = info
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = login.value,
                onValueChange = { value -> login.value = value },
                label = { Text(text = "Логин") }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { value -> password.value = value },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(text = "Пароль") }
            )
            Button(onClick = {
                signIn(context,
                    login.value,
                    password.value,
                    { id, login, _ ->
                        corutine.launch {
                            val newInfo = UserInfo(true, login, id.toString())
                            userInfo.value = newInfo
                            dataStoreManager.saveAuthInfo(
                               newInfo
                            )
                        }
                    },
                    {
                        login.value = ""
                        password.value = ""
                    })
            }) {
                Text(text = "Войти", fontSize = 20.sp)
            }
        }
    }
}

fun signIn(
    context: Context,
    login: String,
    password: String,
    onSuccess: (id: Int, login: String, password: String) -> Job,
    onError: () -> Unit
) {
    val url = "$baseUrl/users?login=$login&password=$password"
    var queue = Volley.newRequestQueue(context)

    val jsonArrayRequest = JsonArrayRequest(
        Request.Method.GET,
        url,
        null,
        { response ->
            if (response.length() > 0) {
                try {
                    val responseObj = response.getJSONObject(0)

                    val userId: Int = responseObj.getInt("id")
                    val login: String = responseObj.getString("login")
                    val password: String = responseObj.getString("password")

                    onSuccess(userId, login, password)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            } else {
                onError()
            }
        },
        { error ->

        }
    )
    queue.add(jsonArrayRequest)
}