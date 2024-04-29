//
//  BitBuggyShopApp.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

@main
struct BitBuggyShopApp: App {
    @StateObject var cartManager = CartManager()
    @State var orderManager = OrderManager()
    
    var body: some Scene {
        WindowGroup {
            ContentView()
            
        }
    }
}
