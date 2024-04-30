//
//  Product.swift
//  BitBuggyShop
//
//  Created by Emily Combs 
//

import Foundation

struct Product: Identifiable, Decodable{
    
    //Attributes
    var id = UUID()
    var name: String
    var category_id: String
    var product_image: String
    var product_description: String
    var price: Float
    var product_stock: Int
    var promotion_id: Int
}

var productList = [Product(name:"Lenovo Think System", category_id: "Electonics", product_image: "LenovoThinkSystem", product_description: "Lenovo Think System PC", price: 189.99, product_stock: 5, promotion_id: 0),
                    Product(name:"Hamilton Beach Toaster", category_id: "Kitchen Appliances", product_image: "HamiltonBeachToaster", product_description: "Two Slice Toaster", price: 16.99, product_stock: 22, promotion_id: 0000),
                    Product(name:"Moleskin Notebook", category_id:"Office Supplies", product_image:"MoleskinNotebook", product_description:"8x11\" Office Notebooke by Moleskin", price: 14.99, product_stock: 12, promotion_id: 0000)]

