package com.example.uniquelux

class User {
    var id: Int = 0
    var email: String = ""
    var username: String = ""
    var password: String = ""

    constructor(email: String, username: String, password: String) {
        this.email = email
        this.username = username
        this.password = password
    }

    constructor(username: String, password: String){
        this.username = username
        this.password = password
    }

    constructor(){
    }
}