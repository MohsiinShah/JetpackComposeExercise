package com.example.jetpackcomposeexercise.screens

import android.widget.ToggleButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.jetpackcomposeexercise.R
import com.example.jetpackcomposeexercise.navigation.AppScreens
import com.example.jetpackcomposeexercise.ui.theme.best

@OptIn(ExperimentalUnitApi::class)
@Composable
fun SettingsScreen(navController: NavController) {

    Scaffold(topBar = {
        TopAppBar(
            Modifier.fillMaxHeight(0.12625f),
            backgroundColor = Color.White,
            elevation = 0.dp
        ) {
            Row {
                ConstraintLayout {

                    val (icon, title) = createRefs()

                    Image(
                        painterResource(id = R.drawable.back_icon), contentDescription = "dots",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .constrainAs(icon) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                            .clickable {
                                navController.popBackStack()
                            }, alignment = Alignment.Center
                    )

                    Text(
                        text = stringResource(R.string.move),
                        Modifier
                            .padding(start = 20.dp)
                            .constrainAs(title) {

                                top.linkTo(icon.top)
                                bottom.linkTo(icon.bottom)
                                start.linkTo(icon.end)

                            },
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        fontFamily = best,
                        fontSize = TextUnit(20f, TextUnitType.Sp),
                        color = Color.Black,
                    )
                }

            }
        }
    }) {
        Column(
            modifier = Modifier
                .padding(it),
            content = {
                Settings()
            })
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun Settings() {

    Surface {
        ConstraintLayout(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            val (darkModeIcon, darkModeText, toggle, clPrivacy) = createRefs()

            Image(painterResource(id = R.drawable.dark_mode_icon),
                contentDescription = "dark_mode_icon",
                modifier = Modifier
                    .constrainAs(darkModeIcon) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .padding(start = 17.dp)
            )

            Text(
                text = stringResource(R.string.dark_mode),
                Modifier
                    .padding(start = 20.dp)
                    .constrainAs(darkModeText) {

                        top.linkTo(darkModeIcon.top)
                        bottom.linkTo(darkModeIcon.bottom)
                        start.linkTo(darkModeIcon.end)

                    },
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                fontFamily = best,
                fontSize = TextUnit(14f, TextUnitType.Sp),
                color = Color.Black,
            )

            Image(painterResource(id = R.drawable.toggle), contentDescription = "toggle",
                modifier = Modifier
                    .constrainAs(toggle) {
                        bottom.linkTo(darkModeIcon.bottom)
                        top.linkTo(darkModeIcon.top)
                        end.linkTo(parent.end)
                    }
                    .padding(end = 16.dp)
            )

            Column (Modifier.constrainAs(clPrivacy){
                top.linkTo(darkModeIcon.bottom)
                start.linkTo(darkModeIcon.start)
            }.padding(top = 30.dp)){
                ConstraintLayout(
                    Modifier.fillMaxWidth().wrapContentHeight()
                ) {

                    val (privacyPolicyIcon, privacyPolicyText) = createRefs()

                    Image(painterResource(id = R.drawable.privacy__policy),
                        contentDescription = "privacy-policy",
                        modifier = Modifier
                            .constrainAs(privacyPolicyIcon) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                            .padding(start = 17.dp)
                    )

                    Text(
                        text = stringResource(R.string.privacy_policy),
                        Modifier
                            .padding(start = 20.dp)
                            .constrainAs(privacyPolicyText) {
                                top.linkTo(privacyPolicyIcon.top)
                                bottom.linkTo(privacyPolicyIcon.bottom)
                                start.linkTo(privacyPolicyIcon.end)

                            },
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Normal,
                        fontFamily = best,
                        fontSize = TextUnit(14f, TextUnitType.Sp),
                        color = Color.Black,
                    )
                }
            }
        }


    }

}