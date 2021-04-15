// NPM Packages
import React from "react";

// Project files
import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";
import Auth from "../../services/Auth";
import logo from "../../images/logo500by400.png";

export default function LoginPage() {
    // Methods
    async function login(loginData) {
        const loginSuccess = await Auth.login(loginData);
        if (!loginSuccess) {
            alert("Invalid credentials");
        }
    }

    async function register(registrationData) {
        const registerSuccess = await Auth.register(registrationData);
        if (!registerSuccess) {
            alert("Couldn't register check credentials and try again");
        }
    }

    return (
        <div className="wrapper">
            <div className="container">
                <div className="row mt-4">
                    <div className="col-md-6 mb-4">
                        <div className="card">
                            <img className="card-img-top" src={logo} alt="Plantista logo" title="Plantista logo"/>
                            <div className="card-body">
                                <h1 className="card-title">Plant lovers unite!</h1>
                                <p className="card-text">Whether you're a seasoned plant parent or a nervous newbie,
                                    Plantista is the forum for you!</p>
                                <p>Post your best green-fingered tips or seek help for your floral conundrums.</p>
                                <p>Sign up or log in to get started.</p>
                            </div>
                        </div>
                    </div>

                    <div className="col-md-6">
                        <div className="row">
                            <div className="col-12  strong-shadow">
                                <LoginForm onSubmit={login}/>
                            </div>

                            <div className="col-12 mt-4">
                                <RegisterForm onSubmit={register}/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
