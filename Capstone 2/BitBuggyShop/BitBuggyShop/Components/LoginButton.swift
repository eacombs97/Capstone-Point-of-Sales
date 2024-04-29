//
//  LoginButton.swift
//  BitBuggyShop
//
//  Created by Emily Combs on 4/18/24.
//

import SwiftUI

struct LoginButton: View {
    var body: some View {
        NavigationLink(destination: LoginView()) {
            Text("Login")
                .foregroundColor(Color("Dark Gold"))
                .padding()
                .frame(maxWidth: .infinity)
                .background(Color.clear)
                .cornerRadius(8)
        }
    }
}

struct LoginButton_Previews: PreviewProvider {
    static var previews: some View {
        LoginButton()
    }
}
