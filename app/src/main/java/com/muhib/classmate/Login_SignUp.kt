package com.muhib.classmate

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muhib.classmate.designs.ButtonDesigner
import com.muhib.classmate.designs.LogoDesigner
import com.muhib.classmate.designs.TextCustomization
import com.muhib.classmate.designs.TextFieldDesigner
import com.muhib.classmate.ui.theme.backgroundDark
import com.muhib.classmate.ui.theme.backgroundLight
import com.muhib.classmate.ui.theme.red


//@Preview(showBackground = true)
@Composable
fun LogInSignUp(context: Context, modifier: Modifier = Modifier) {
    var signUp by remember { mutableIntStateOf(0) }

    val color = if (isSystemInDarkTheme()) { backgroundDark } else { backgroundLight }

    var showDepartment by remember { mutableStateOf("") }
    var showFirstname by remember { mutableStateOf("") }
    var showLastName by remember { mutableStateOf("") }
    var showConfirmPassword by remember { mutableStateOf("") }
    var showUsername by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf("") }

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }



    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = color)
        .padding(top = 24.dp)
        .verticalScroll(rememberScrollState())
    ) {
        LogoDesigner()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = color)
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if(signUp === 0) {
                    TextFieldDesigner(text = "Username", value = showUsername, modifier = Modifier.padding(top = 48.dp), keyboardType = KeyboardType.Text) {username = it; showUsername = username}
                    TextFieldDesigner(text = "Password", value = showPassword, modifier = Modifier.padding(top = 16.dp), keyboardType = KeyboardType.Password, fieldType = "password") {password = it; showPassword = password}
                    ButtonDesigner(text = "Log In", backgroundColor = red, textColor = Color.White, Modifier.padding(top = 32.dp)
                    ) {
                        /* TODO: Complete Lambda Function */
                        if(username.isNotEmpty() && password.isNotEmpty()) {
                            Toast.makeText(context, "Username: $username \tPassword: $password", Toast.LENGTH_SHORT).show()
                        }
                    }
                    TextCustomization(text = "Forgot Password?", Modifier.padding(top = 8.dp))
                    TextCustomization(text = "New in ClassMate", Modifier.padding(top = 32.dp, bottom = 8.dp))
                    ButtonDesigner(text = "Sign Up",
                        backgroundColor = color,
                        textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) { signUp = 1 }
                }  else if(signUp === 1) {
                    Spacer(modifier = Modifier.padding(top = 48.dp))
                    ButtonDesigner(text = "Teacher", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) {signUp = 2}
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    ButtonDesigner(text = "CR(Class Representative)", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) {signUp = 2}
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    ButtonDesigner(text = "Student", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) { signUp = 2 }
                    TextCustomization(text = "Already have an account?", Modifier.padding(top = 32.dp, bottom = 8.dp))
                    ButtonDesigner(text = "Log In", backgroundColor = red, textColor = Color.White, modifier = Modifier
                    ) { signUp = 0 }
                } else {
                    TextFieldDesigner(text = "Department", value = showDepartment, modifier = Modifier.padding(top = 48.dp), keyboardType = KeyboardType.Text) {department = it; showDepartment = it}
                    TextFieldDesigner(text = "First Name", value = showFirstname, modifier = Modifier.padding(top = 16.dp), keyboardType = KeyboardType.Text) {firstname = it; showFirstname = it}
                    TextFieldDesigner(text = "Last Name", value = showLastName, modifier = Modifier.padding(top = 16.dp), keyboardType = KeyboardType.Text) {lastname = it; showLastName = it}
                    TextFieldDesigner(text = "Username", value = showUsername, modifier = Modifier.padding(top = 16.dp), keyboardType = KeyboardType.Text) {username = it; showUsername = it}
                    TextFieldDesigner(text = "Password", value = showPassword, modifier = Modifier.padding(top = 16.dp),  keyboardType = KeyboardType.Password, fieldType = "password") {password = it; showPassword = it}
                    TextFieldDesigner(text = "Confirm Password", value = showConfirmPassword, modifier = Modifier.padding(top = 16.dp),  keyboardType = KeyboardType.Password, fieldType = "password") {confirmPassword = it; showConfirmPassword = it}
                    ButtonDesigner(text = "Sign Up", backgroundColor = red, textColor = Color.White, modifier = Modifier.padding(top = 32.dp)
                    ) {
                    /* TODO: Complete Lambda Function */
                    }
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    ButtonDesigner(text = "Go Back", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) { signUp = 1 }
                }
            }
    }
}

