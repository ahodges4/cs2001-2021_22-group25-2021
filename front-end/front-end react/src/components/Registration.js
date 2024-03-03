import React, { Component } from 'react';


export class Registration extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (  <div class="container">
        <div class="title">Registration</div>
        <form action= "#">
            <div class="user-details">
            <div class="input-box">
                <span class="details">Full Name</span>
                <input type="text" placeholder="Enter your name" required/>
            </div>
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Username</span>
                    <input type="text" placeholder="Enter your username" required/>
                </div>
                <div class="user-details">
                    <div class="input-box">
                        <span class="details">Email</span>
                        <input type="text" placeholder="Enter your email" required/>
                    </div>
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Phone number</span>
                            <input type="text" placeholder="Enter your number" required/>
                        </div>
                        <div class="user-details">
                            <div class="input-box">
                                <span class="details">Password</span>
                                <input spellcheck="false" type="password" id="pass1"  placeholder="Enter password" onkeyup="return validate()"/ >
                                <progress max="100" value="0" id="strength" ></progress>
                               
                            </div> 
                            </div>
                                       
                            <div class="user-details">
                                <div class="input-box">
                                    <span class="details">Confirm Password</span>
                                    <input spellcheck="false" type="password" id="pass2" placeholder="Confirm password" oninput="return conform()"/>
                                    <div class="errors">
                                        <ul>
                                            <li id="upper"> Atleast one uppercase</li>
                                            <li id="lower"> Atleast one lowercase</li>
                                            <li id="special_char">Atleast one special symbol</li>
                                            <li id="number">Atleast one number</li>
                                            <li id="length">Atleast 8 characters</li>
                                        </ul>
                                    </div>
                           
                                </div>                          
                            </div>
                    </div>
                </div>
            </div>
            </div>
            <div class="button">
                <input type="submit" value="Register"/>
            </div>
        </form>
        </div>





    )
    }
}