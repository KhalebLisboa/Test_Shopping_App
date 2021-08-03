package com.example.test_shopping_app.domain

class Product(
    var name : String?,
    var color : String?,
    var on_sale : Boolean,
    var regular_price : String?,
    var actual_price : String?,
    var discount_percentage : String?,
    var installments : String?,
    var image : String?,
    var sizes : List<Size>?
)