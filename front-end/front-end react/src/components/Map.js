import React, { Component } from 'react';

export class Map extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (
        <div>
            <header>
            <div class="container">
                <div id="branding">
                    <h1><a href="/home">Food<span class= "highlight">4</span>Everyone</a></h1>
                </div>
                <nav>
                    <ul>
                        <li><a href="/home">Home</a></li>
                        <li class="current"><a href="/map">Map</a></li>
                        <li><a href="/">News</a></li>
                        <li><a href="/faq">FAQ</a></li>
                        <li><a href="/login">Login</a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <div id="map" class="container"></div>

        

	       
        
        <footer>
            <p>Food4Everyone, Copyright &copy; 2021</p>
        </footer>
        </div>)
    }
}