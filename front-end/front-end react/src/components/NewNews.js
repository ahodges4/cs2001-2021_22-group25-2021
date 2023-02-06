import React, {Component} from 'react';
import axios from "axios";
import {withRouter} from "react-router";
import "./newnews.css"


export class NewNews extends Component {

    constructor(props) {
        super(props)
        this.state = {
            title: "",
            description: ""
        }
        this.handleFormSubmit = this.handleFormSubmit.bind(this)
        this.handleTitleChange = this.handleTitleChange.bind(this)
        this.handleDescriptionChange = this.handleDescriptionChange.bind(this)
    }
//Sets the title
    handleTitleChange(event) {
        this.setState({
            title: event.target.value
        })
    }
//Sets the description
    handleDescriptionChange(event) {
        this.setState({
            description: event.target.value
        })
    }
//Used to submit forms
    handleFormSubmit(e) {
        e.preventDefault()
        axios.post('/news', this.state).then(res => {
            this.props.history.push("/");
        });
    }
//Renders the view
    render() {
        return (
            <div>


                <div className="menu-bar">
                    <ul>
                        <li className="active"><a href="ControlPage.html"><i className="fa fa-home"></i>Home</a></li>
                        <li><a href="/"><i className="fa fa-newspaper"></i>News</a></li>
                        <li><a href="#"><i className="fa fa-bars"></i>More</a>
                            <div className="sub-menu-1">
                                <ul>
                                    <li><a href="#">Logout</a></li>
                                    <li><a href="changecredential.html">Change my Email and Password</a></li>
                                </ul>
                            </div>

                        </li>
                    </ul>
                </div>

                <form onSubmit={this.handleFormSubmit} className="">
                    <div className="wrapper">
                        <h2>NewsPage Content</h2>


                        <div className="form-group">
                            <input type="text"
                                   value={this.state.title}
                                   placeholder="Title"
                                   onChange={this.handleTitleChange}
                            />
                        </div>

                        <div className="form-group">
                            <textarea type="text"
                                      placeholder="Please add content here to be added to the News Page..."
                                      value={this.state.description}
                                      onChange={this.handleDescriptionChange}
                            />
                        </div>
                    </div>


                    <div className="buttons">
                        <div className="features">
                            <button type="submit" id="btn-one">Submit</button>
                        </div>
                    </div>


                </form>
            </div>
        )
    }
}

