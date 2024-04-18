//
//  Product.swift
//  BitBuggyShop
//
//  Created by Emily Combs 
//

import Foundation

struct Product: Identifiable{
    
    //Attributes
    var id = UUID()
    var productName: String
    var categoryID: String
    var productImage: String
    var productDescription: String
    var productPrice: Float
    var productStock: Int
    var promotionID: Int
}

var productList = [Product(productName:"Moleskin Notebook", categoryID:"Office Supplies", productImage:"MoleskinNotebook", productDescription:"8x11\" Office Notebooke by Moleskin", productPrice: 14.99, productStock: 12, promotionID: 0000),
                   Product(productName:"Lenovo Think System", categoryID: "Electonics", productImage: "LenovoThinkSystem", productDescription: "Lenovo Think System PC", productPrice: 189.99, productStock: 5, promotionID: 0),
                   Product(productName:"HamiltonBeachToast", categoryID: "Kitchen Appliances", productImage: "HamiltonBeachToast", productDescription: "Two Slice Toaster", productPrice: 16.99, productStock: 22, promotionID: 0000)]

