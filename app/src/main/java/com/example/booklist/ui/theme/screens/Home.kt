package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.booklist.R
import com.example.booklist.model.HomeShortcuts
import com.example.booklist.ui.theme.navigation.NavigationGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTabRow(paddingValues: PaddingValues) {

    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    val startDestination = HomeShortcuts.LIST_BOOKS
    var selectedDestination: Int by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
//            .verticalScroll(scrollState)
    ) {
        PrimaryTabRow(
            selectedTabIndex = selectedDestination,
            modifier = Modifier.padding(),
            indicator = {
                TabRowDefaults.PrimaryIndicator(
                    Modifier.tabIndicatorOffset(selectedDestination),
                    color = colorResource(R.color.purple_200),
                    height = 2.dp,
                    width = 100.dp
                )
            }
        ) {
            HomeShortcuts.entries.forEachIndexed { index, homeShortcuts ->
                Tab(
                    selectedDestination == index,
                    onClick = {
                        navController.navigate(homeShortcuts.route)
                        selectedDestination = index
                    },
                    selectedContentColor = Color.Gray,
                    unselectedContentColor = Color.LightGray,
                    text = { Text(stringResource(homeShortcuts.label.toInt())) })
            }
        }
        NavigationGraph(navController, startDestination)
    }
}