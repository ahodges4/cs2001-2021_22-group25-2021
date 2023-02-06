import React, {Component} from 'react';
import "./design.css"

export class Login extends Component {

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
                            <li><a href="/home">Home</a></li>
                            <li><a href="/map">Map</a></li>
                            <li><a href="/">News</a></li>
                            <li><a href="/faq">FAQ</a></li>
                            <li className="current"><a href="/login">Login</a></li>
                        </ul>
                    </nav>
                </div>
            </header>
            <section id="login">
                <div className="container">
                    <h1>Login To Your Account</h1>
                    <div className="form">
                        <form action="/userinfo" method="get">
                            <input type="username" placeholder="Enter Username..."/><br/>
                            <input type="password" placeholder="Enter Password..."/><br/>
                            <button type="submit" value="login" className="button_1">Submit</button>
                            <li><a href="/forgotpassword">forgot password</a></li>
                            <li><a href="/registration">create account</a></li>
                        </form>
                    </div>
                </div>
            </section>
            <section id="placeholder">
                <div className="container">
                    <h1>placeholder</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam porta egestas enim vel
                        tincidunt. Quisque vitae purus ultrices, sagittis sapien ac, pulvinar arcu. Etiam eget tempus
                        nunc. Suspendisse nec neque in leo rhoncus finibus eget gravida quam. Nulla lobortis luctus
                        euismod. Donec quis mauris ipsum. In posuere felis tellus. Sed in elementum arcu, id convallis
                        dolor. Nullam in hendrerit est. Praesent consectetur lacus neque, eu ornare elit porttitor sit
                        amet. Praesent id vulputate nunc.</p>

                    <p>Nulla tempor scelerisque felis vel rutrum. Vestibulum iaculis lobortis iaculis. Mauris nisl est,
                        ultrices eu ex sed, volutpat convallis enim. Proin venenatis urna id pretium elementum. Praesent
                        nec ullamcorper metus. Nam facilisis sodales sem eget laoreet. Phasellus porttitor nunc
                        vestibulum ante fringilla accumsan. Cras mollis velit ac nulla iaculis, sit amet tincidunt dolor
                        sodales.</p>

                    <p> maximus diam non elit maximus feugiat. Nunc eleifend, ex sed rutrum auctor, risus lacus
                        vestibulum mauris, vitae tincidunt dolor augue eget nulla. Maecenas ullamcorper mollis leo,
                        vitae vulputate justo mattis fermentum. Fusce nec massa vitae magna vulputate auctor. Vivamus
                        gravida nulla quam, nec hendrerit sem auctor vel. Vestibulum efficitur, ante quis mollis
                        convallis, elit justo volutpat nibh, eget lobortis nisl quam non lacus. Praesent a eleifend ex.
                        Duis ullamcorper eget massa a interdum. Vivamus vel augue eget mi tempus congue ultrices non
                        est. Integer ultrices vestibulum commodo. Fusce tincidunt porttitor molestie.</p>
                </div>
            </section>
            <footer>
                <p>Food4Everyone, Copyright &copy; 2021</p>
            </footer>
        </div>)
    }
}