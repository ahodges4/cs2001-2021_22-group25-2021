import React, { Component } from 'react';
import "./design.css"
import Image  from './assets/statmap.jpg';


export class Home extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (<div>
            <header>
                <div className="container">
                    <div id="branding">
                        <h1><a href="/home">Food<span className="highlight">4</span>Everyone</a></h1>
                    </div>
                    <nav>
                        <ul>
                            <li className="current"><a href="/home">Home</a></li>
                            <li><a href="/map">Map</a></li>
                            <li><a href="/">News</a></li>
                            <li><a href="/faq">FAQ</a></li>
                            <li><a href="/login">Login</a></li>
                        </ul>
                    </nav>
                </div>
            </header>
            <section id="home">
                <div className="container">
                    <h1><span style={{color: "#008751"}}>ABOUT US</span></h1>
                   <h2>
                    <span style={{color: "#008751"}}>Our aim is to make sure food banks are accessable to everyone.<br/>
                        <span style={{color: "#63a036"}}>Between 1 April 2020 and <br/> 31 March 2021, food banks in the Trussell Trust’s UK wide network <br/> distributed 2.5 million emergency food parcels to people in crisis, <br/> a 33% increase on the previous year. 980,000 of these went to children.</span>
                    </span>
                   <div className="homeimg">
                   <img src={Image} />
                        </div>
                        <div className="wrap">
                            <div className="search">

                                <input type="text" className="searchTerm"
                                       placeholder="Enter Your Post Code or Location"/>
                                    <button type="submit" className="searchButton">
                                        <i className="fa fa-search"></i>
                                    </button>
                            </div>
                        </div>

                    </h2>
                </div>
            </section>
        </div>)
    }
}