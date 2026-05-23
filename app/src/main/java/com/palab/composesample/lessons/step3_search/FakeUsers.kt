package com.palab.composesample.lessons.step3_search

data class User(val id: Int, val name: String, val email: String)

val fakeUsers: List<User> = listOf(
    User(1, "김민준", "minjun.kim@example.com"),
    User(2, "이서연", "seoyeon.lee@example.com"),
    User(3, "박지후", "jihu.park@example.com"),
    User(4, "최도윤", "doyun.choi@example.com"),
    User(5, "정하은", "haeun.jung@example.com"),
    User(6, "강시우", "siwoo.kang@example.com"),
    User(7, "조은채", "eunchae.cho@example.com"),
    User(8, "윤서진", "seojin.yoon@example.com"),
    User(9, "임채원", "chaewon.lim@example.com"),
    User(10, "한지아", "jia.han@example.com"),
    User(11, "오유준", "yujun.oh@example.com"),
    User(12, "장수아", "sua.jang@example.com"),
)
