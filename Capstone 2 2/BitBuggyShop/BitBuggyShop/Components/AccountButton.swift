//
//  AccountButton.swift
//  BitBuggyShop
//
//  Created by Emily Combs on 
//

import SwiftUI

struct AccountButton: View {
    var body: some View {
        
            Image(systemName: "person.circle")
                .resizable()
                .frame(width: 30, height: 30)
                .foregroundColor(Color("Dark Gold")) // Change color as needed
                .padding()
    }
}

struct AccountButton_Previews: PreviewProvider {
    static var previews: some View {
        AccountButton()
    }
}
