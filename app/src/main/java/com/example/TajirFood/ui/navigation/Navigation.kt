package com.example.TajirFood.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.TajirFood.ui.cart.Cart
import com.example.TajirFood.ui.detail.FoodDetail
import com.example.TajirFood.ui.home.Feed
import com.example.TajirFood.ui.onboarding.OnBoardingScreen

const val DetailRoute = "DetailScreen"
const val OnBoardingRoute = "OnBoarding"

enum class Tabs(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    Feed("Home", Icons.Outlined.Home, "home/feed"),
    Cart("Cart", Icons.Outlined.ShoppingCart, "home/cart")
}

@Composable
fun FoodiaNavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Tabs.Feed.route) {
            Feed(onFoodClick = { navController.navigate("$DetailRoute/$it") })
        }
        composable(
            route = "$DetailRoute/{id}",
            arguments = listOf(navArgument("id") {}),
        ) { from ->
            val id = from.arguments?.getString("id") ?: "1"
            FoodDetail(foodId = id.toLong()) {
                navController.navigateUp()
            }
        }

        composable(route = Tabs.Cart.route) { from ->
            Cart(
                onFoodItemClick = { id -> },
                modifier = modifier
            )
        }
        composable(route = OnBoardingRoute) { from ->
            OnBoardingScreen {
                navController.navigateToBottomBarRoute(Tabs.Feed.route)
            }
        }
    }


}


fun NavController.navigateToBottomBarRoute(route: String) {
    val currentRoute = currentDestination?.route
    if (route != currentRoute) {
        navigate(route) {
            launchSingleTop = true
            restoreState = true
            popUpTo(graph.startDestinationId) {
                saveState = true
            }
        }
    }
}













