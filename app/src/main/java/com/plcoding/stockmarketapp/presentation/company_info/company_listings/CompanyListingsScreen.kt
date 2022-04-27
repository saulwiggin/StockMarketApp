package com.plcoding.stockmarketapp.domain.model.repository

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.room.util.TableInfo
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.plcoding.stockmarketapp.presentation.company_info.company_listings.CompanyListingEvent
import com.plcoding.stockmarketapp.presentation.company_info.company_listings.CompanyListingsViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.lang.reflect.Modifier

@Composable
@Destination(start = true)
fun CompanyListingsScreen(
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier,
    viewModel: CompanyListingsViewModel = hiltViewModel()
) {
    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = viewModel.state.isRefreshing
    )
    val state = viewModel.state
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(CompanyListingEvent.OnSearchQueryChange(it))
            })
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    viewModel.onEvent(CompanyListingEvent.Refresh)
                }
        ) {
                LazyColumn(
                    modifier = modifier.fillMaxWidth()
                ) {
                    items(state.companies.size){ i ->
                        val company = state.companies[i]
                        CompanyItem(
                            company = company,
                            modifier = modifier
                                .fillMaxWidth()
                                .clickable {
                                    // TODO: Navigate to detail screen
                                }
                                .padding(16.dp)
                        )
                        if(i < state.companies.size) {
                            Divider(modifier = modifier.padding(
                               horizontal = 16.dp
                           ))
                    }
                }
            }
    }
}

}
