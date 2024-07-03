package aandrosov.funcatfacts.app.ui.components

import aandrosov.funcatfacts.app.R
import aandrosov.funcatfacts.app.ui.theme.AppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactsTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier
            .shadow(16.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer,
                shape = RoundedCornerShape(
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp
                )
            ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = modifier.size(32.dp),
                    painter = painterResource(id = R.mipmap.cat_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = stringResource(id = R.string.app_name)
                )
            }
        },
        colors = TopAppBarDefaults
            .topAppBarColors()
            .copy(containerColor = Color.Transparent),
    )
}

@Preview
@Composable
private fun AppBarPreview() {
    AppTheme {
        FactsTopAppBar()
    }
}