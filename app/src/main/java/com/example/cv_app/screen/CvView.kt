package com.example.cv_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.cv_app.R
import com.example.cv_app.model.UserProfileViewModel

@Composable
fun CvView(navController: NavController, viewModel: UserProfileViewModel) {
    val stateFlow by viewModel.stateFlow.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier

            .background(Color(0xFFFFF0F5))
            .fillMaxSize()
            .verticalScroll(state = scrollState),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Curriculum Vitae",
            modifier = Modifier.padding(top = 10.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(30.dp))


        Text(
            stateFlow.fullname,
            fontSize = 27.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,

            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            maxLines = 2

        )

        //card
        Spacer(modifier = Modifier.height(70.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 40.dp),
            modifier = Modifier
                .height(90.dp)
                .padding(start = 13.dp, end = 13.dp)


        ) {


            Row(
                modifier = Modifier
                    .padding(start = 14.dp, top = 16.dp, bottom = 8.dp)
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(painter = painterResource(id = R.drawable.slack), contentDescription =null )
                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    stateFlow.slackUsername,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,

                    )
                )



            }
        }

        Spacer(modifier = Modifier.height(25.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 40.dp),
            modifier = Modifier
                .height(90.dp)
                .padding(start = 13.dp, end = 13.dp)

        ) {

            Row(
                modifier = Modifier
                    .padding(start = 14.dp, top = 16.dp, bottom = 8.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically

            ) {

                Icon(painter = painterResource(id = R.drawable.github), contentDescription =null )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    stateFlow.gitHubHandle,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,

                    )
                )

            }


        }
        Spacer(modifier = Modifier.height(25.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 40.dp),
            modifier = Modifier
                .height(90.dp)
                .padding(start = 13.dp, end = 13.dp)

        ) {

            Row(
                modifier = Modifier
                    .padding(start = 14.dp, top = 16.dp, bottom = 8.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically

            ) {

                Icon(painter = painterResource(id = R.drawable.bio), contentDescription =null )
                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    stateFlow.bio,
                    maxLines = 3,
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )


            }


        }


//button

        Spacer(modifier = Modifier.height(70.dp))
        Button(
            onClick = {
                navController.navigate("editcv")
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF2A3940)),
            modifier = Modifier
                .height(45.dp)
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)

        ) {
            Text(
                text = "Edit Cv",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }

}
