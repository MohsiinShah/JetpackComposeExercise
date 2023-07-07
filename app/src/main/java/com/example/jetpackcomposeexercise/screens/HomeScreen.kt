package com.example.jetpackcomposeexercise.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.jetpackcomposeexercise.R
import com.example.jetpackcomposeexercise.navigation.AppScreens
import com.example.jetpackcomposeexercise.navigation.Navigation
import com.example.jetpackcomposeexercise.ui.theme.best

@OptIn(ExperimentalUnitApi::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(topBar = {
        TopAppBar(
            Modifier.fillMaxHeight(0.12625f),
            backgroundColor = Color.White,
            elevation = 0.dp
        ) {
            Row {

                Text(
                    text = stringResource(R.string.smart_switch),
                    Modifier.padding(start = 20.dp),
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontFamily = best,
                    fontSize = TextUnit(20f, TextUnitType.Sp),
                    color = Color.Black
                )

                Spacer(Modifier.weight(1f))// height and background only for demonstration

                Image(painterResource(id =  R.drawable.dots), contentDescription = "dots",
                modifier = Modifier.padding(end = 16.dp).clickable {
                    navController.navigate(route = AppScreens.SettingScreen.name)
                })
            }
        }
    }) {
        Column(
            modifier = Modifier
                .padding(it),
        content = {
            MainContent()
        })
    }
}

@Composable
fun MainContent(){

    Surface {
        Column {
            Surface(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.085f), color = Color.LightGray) {
            }
        }

        ConstraintLayout(
            Modifier.fillMaxSize()) {

            val (sendBtn, receiveBtn, bottomIcon) = createRefs()

            Image(painterResource(id = R.drawable.send), contentDescription = "send",
                modifier = Modifier.constrainAs(sendBtn){
                    bottom.linkTo(receiveBtn.top)
                    centerHorizontallyTo(parent)
                })


            Image(painterResource(id = R.drawable.receive), contentDescription = "receive",
                modifier = Modifier.constrainAs(receiveBtn){
                    centerHorizontallyTo(parent)
                    centerHorizontallyTo(parent)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })


            Image(painterResource(id = R.drawable.bottom_icon), contentDescription = "receive",
                modifier = Modifier
                    .padding(bottom = 20.dp).constrainAs(bottomIcon){
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        }
    }

}


