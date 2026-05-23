package com.palab.composesample.navigation

object Destinations {
    const val HOME = "home"
    const val STEP1_COUNTER = "step1/counter"
    const val STEP2_LOGIN = "step2/login"
    const val STEP3_SEARCH = "step3/search"
    const val STEP4_FLOW = "step4/flow"

    // STEP 5: nested graph "step5"
    const val STEP5_GRAPH = "step5"
    const val STEP5_LIST = "step5/list"
    const val STEP5_DETAIL_ROUTE = "step5/detail/{itemId}"
    fun step5Detail(itemId: Int) = "step5/detail/$itemId"

    const val STEP6_HYBRID = "step6/hybrid"
    const val CAPSTONE_DASHBOARD = "capstone/dashboard"
}
