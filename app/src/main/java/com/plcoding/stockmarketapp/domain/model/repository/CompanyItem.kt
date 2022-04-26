package com.plcoding.stockmarketapp.domain.model.repository

import android.text.Layout
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.reflect.Modifier

@Composable
fun CompanyItem (
    company: CompanyListing,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Layout.Alignment.CenterVertically
    ){
        Text(
            text = company.name,
            fontweight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifer.width(4.dp))
        Text(
            text = company.exchange,
            fontWeight = fontWeight.Light,
            color = MaterialTheme.colors.onBackground
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "(${company.symbol})",
        fontStyle = FontStyle.Italic,
        color =
    )
}