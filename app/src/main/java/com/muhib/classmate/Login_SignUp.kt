package com.muhib.classmate

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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


@Preview(showBackground = true)
@Composable
fun LogInSignUp(modifier: Modifier = Modifier) {
    var signUp by remember { mutableIntStateOf(0) }
    val color = if (isSystemInDarkTheme()) { backgroundDark } else { backgroundLight }

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
                    TextFieldDesigner(text = "Username", modifier = Modifier.padding(top = 48.dp), keyboardType = KeyboardType.Text)
                    TextFieldDesigner(text = "Password", modifier = Modifier.padding(top = 16.dp), keyboardType = KeyboardType.Password, fieldType = "password")
                    /* TODO: Complete Lambda Function */
                    ButtonDesigner(text = "Log In", backgroundColor = red, textColor = Color.White, Modifier.padding(top = 32.dp)
                    ) {}
                    TextCustomization(text = "Forgot Password?", Modifier.padding(top = 8.dp))
                    TextCustomization(text = "New in ClassMate", Modifier.padding(top = 32.dp, bottom = 8.dp))
                    /* TODO: Complete Lambda Function */
                    ButtonDesigner(text = "Sign Up",
                        backgroundColor = color,
                        textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) { signUp = 1 }
                }  else if(signUp === 1) {
                    Spacer(modifier = Modifier.padding(top = 48.dp))
                    /* TODO: Complete Lambda Function */
                    ButtonDesigner(text = "Teacher", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) {signUp = 2}
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    /* TODO: Complete Lambda Function */
                    ButtonDesigner(text = "CR(Class Representative)", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) {signUp = 2}
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    /* TODO: Complete Lambda Function */
                    ButtonDesigner(text = "Student", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) { signUp = 2 }
//                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    TextCustomization(text = "Already have an account?", Modifier.padding(top = 32.dp, bottom = 8.dp))
                    /* TODO: Complete Lambda Function */
                    ButtonDesigner(text = "Log In", backgroundColor = red, textColor = Color.White, modifier = Modifier
                    ) { signUp = 0 }
                } else {
                    TextFieldDesigner(text = "Department", modifier = Modifier.padding(top = 48.dp), keyboardType = KeyboardType.Text)
                    TextFieldDesigner(text = "First Name", modifier = Modifier.padding(top = 16.dp), keyboardType = KeyboardType.Text)
                    TextFieldDesigner(text = "Last Name", modifier = Modifier.padding(top = 16.dp), keyboardType = KeyboardType.Text)
                    TextFieldDesigner(text = "Username", modifier = Modifier.padding(top = 16.dp), keyboardType = KeyboardType.Text)
                    TextFieldDesigner(text = "Password", modifier = Modifier.padding(top = 16.dp),  keyboardType = KeyboardType.Password, fieldType = "password")
                    TextFieldDesigner(text = "Confirm Password", modifier = Modifier.padding(top = 16.dp),  keyboardType = KeyboardType.Password, fieldType = "password")
                    /* TODO: Complete Lambda Function */
                    ButtonDesigner(text = "Sign Up", backgroundColor = red, textColor = Color.White, modifier = Modifier.padding(top = 32.dp)
                    ) {}
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    /* TODO: Complete Lambda Function */
                    ButtonDesigner(text = "Go Back", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
                    ) { signUp = 1 }
                }
            }
    }
}

