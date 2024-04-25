//
//  LoginView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct LoginView: View {
    @State private var username: String = ""
    @State private var password: String = ""
    @State private var isLoggedIn: Bool = false //authentication stuff for here
    
    var body: some View {
        VStack {
            TitleBar()
            
            Image(systemName: "person.circle")
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 100, height: 100)
                .padding(.bottom, 30)
                .foregroundColor(Color("Light Gold"))
            
            TextField("Username", text: $username)
                .padding()
                .background(Color(UIColor.systemGray6))
                .cornerRadius(8)
                .padding(.bottom, 20)
            
            SecureField("Password", text: $password)
                .padding()
                .background(Color(UIColor.systemGray6))
                .cornerRadius(8)
                .padding(.bottom, 20)
            
            Button(action: {
                // implement your authentication logic
                
                if !username.isEmpty && !password.isEmpty {
                    isLoggedIn = true
                }
            }) {
                Text("Login")
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(Color("Dark Gold"))
                    .foregroundColor((Color("Green")))
                    .cornerRadius(8)
            }
        }
        .padding(.horizontal, 20)
        .background(Color("Dark Green")) // Set background color to dark green
        .navigationTitle("Login")
        .alert(isPresented: $isLoggedIn) {
            Alert(title: Text("Success"), message: Text("You are logged in!"), dismissButton: .default(Text("OK")))
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
