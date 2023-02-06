import React, { Component } from 'react';
import "./design.css"

export class ForgotPassword extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (<div>
            <header>
                <div class="container">
                    <div id="branding">
                        <h1>Food<span class= "highlight">4</span>Everyone</h1>
                    </div>
                    <nav>
                        <ul>
                            <li><a href="home.html">Home</a></li>
                            <li><a href="map.html">Map</a></li>
                            <li><a href="news.html">News</a></li>
                            <li><a href="faq.html">FAQ</a></li>
                            <li><a href="login.html">Login</a></li>
                        </ul>
                    </nav>
                </div>
            </header>
            <section id="forgot">
                <div class="container">
                    <h1>Reset Your Account Password</h1>
                    <div class="form">
                        <form>
                            <input type="username" placeholder="Enter Username..."/><br/>
                                <button type="submit" class="button_1">Submit</button>
                        </form>
                    </div>
                </div>
            </section>
        <footer>
            <p>Food4Everyone, Copyright &copy; 2021</p>
        </footer>
        </div>)
    }
}