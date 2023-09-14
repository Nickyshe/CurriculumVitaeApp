package com.example.cv_app.screen


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cv_app.model.CvDetails
import com.example.cv_app.model.UserProfileViewModel

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCv(navController: NavHostController, viewModel: UserProfileViewModel) {
    var newFullName by remember { mutableStateOf("Etugbo Judith OgheneUjiro") }
    var newSlackUsername by remember { mutableStateOf("Ju_dy") }
    var newGitHandle by remember { mutableStateOf("Nickyshe") }
    var newBio by remember { mutableStateOf("I'm a Software Developer and Technical Writer") }
    val context = LocalContext.current
    var isButtonEnabled by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF0F5)),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = "Edit Curriculum Vitae",
            modifier = Modifier.padding(top = 10.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(60.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = newFullName,
                onValueChange = { newFullName = it },
                label = {
                    Text(
                        "FullName",
                        style = TextStyle(
                            color = Color(0xFF2A3940)
                        )
                    )
                },
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .width(600.dp),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color(0xFF2A3940),
                    focusedBorderColor = Color(0xFF2A3940),
                )


            )

            Spacer(modifier = Modifier.height(35.dp))
            OutlinedTextField(
                value = newSlackUsername,
                onValueChange = { newSlackUsername = it },
                label = {
                    Text(
                        "SlackUserName",
                        style = TextStyle(
                            color = Color(0xFF2A3940)
                        )
                    )
                },
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .width(600.dp),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color(0xFF2A3940),
                    focusedBorderColor = Color(0xFF2A3940)
                )
            )

            Spacer(modifier = Modifier.height(35.dp))
            OutlinedTextField(
                value = newGitHandle,
                onValueChange = { newGitHandle = it },
                label = {
                    Text(
                        "GitHubHandle",
                        style = TextStyle(
                            color = Color(0xFF2A3940)
                        )
                    )
                },
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .width(600.dp),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color(0xFF2A3940),
                    focusedBorderColor = Color(0xFF2A3940)
                )
            )

            Spacer(modifier = Modifier.height(35.dp))
            OutlinedTextField(
                value = newBio,
                onValueChange = { newBio = it },
                label = {
                    Text(
                        "Bio",
                        style = TextStyle(
                            color = Color(0xFF2A3940)
                        )
                    )
                },
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .width(600.dp),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                maxLines = 1,

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color(0xFF2A3940),
                    focusedBorderColor = Color(0xFF2A3940)
                )
            )

        }

        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                isButtonEnabled = newFullName.isNotEmpty()
                        && newSlackUsername.isNotEmpty()
                        && newGitHandle.isNotEmpty()
                        && newBio.isNotEmpty()
                if (isButtonEnabled) {
                    val updatedCvDetails =
                        CvDetails(newFullName, newSlackUsername, newGitHandle, newBio)
                    viewModel.updateCv(updatedCvDetails)// Create a CvDetails object with the updated name
                    navController.popBackStack()
                } else {
                    Toast.makeText(context, "textfield cannot be empty", Toast.LENGTH_SHORT).show()

                }


            },

            colors = ButtonDefaults.buttonColors(Color(0xFF2A3940)),
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 15.dp, end = 15.dp)
        ) {
            Text(
                text = "Update", style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

    }

}



