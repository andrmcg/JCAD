package com.example.basiclayoutscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiclayoutscodelab.ui.theme.BasicLayoutsCodelabTheme
import com.example.basicscodelab.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO
                }
            }
        }
    }
}

@Composable
fun AlignYourBodyElement(@DrawableRes drawable:Int,@StringRes text:Int,modifier:Modifier = Modifier){
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = drawable), contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier.size(88.dp).clip(
            CircleShape))
        Text(text = stringResource(id = text), style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp))
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    TextField(value = text, onValueChange = { text = it }, leadingIcon = {
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
    }, colors = TextFieldDefaults.colors(
        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        focusedContainerColor = MaterialTheme.colorScheme.surface
    ), placeholder = {
        Text(
            text = stringResource(
                id = R.string.placeholder_search
            )
        )
    },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicLayoutsCodelabTheme {

    }
}

@Preview(showBackground = true, name = "Search Bar")
@Composable
fun SearchBarPreview() {
    BasicLayoutsCodelabTheme {
        SearchBar()
    }
}

@Preview(showBackground = true, name = "Align your body element")
@Composable
fun AlignYourBodyElementPreview() {
    BasicLayoutsCodelabTheme {
        AlignYourBodyElement(text = R.string.ab1_inversions, drawable = R.drawable.ab1_inversions, modifier = Modifier.padding(8.dp))
    }
}

