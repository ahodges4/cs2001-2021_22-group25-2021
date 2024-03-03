import React, { Component }  from 'react';
import axios from "axios";
import {withRouter} from "react-router";
import "./design.css"

export class EditNews extends Component {

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
// Loads data from backend before render method
    componentDidMount() {
        console.log()
        axios.get('/news/' + this.props.match.params.id, this.state).then(res => {
            this.setState({
                title: res.data.title, description: res.data.description
            })

        });
    }
// Sets the title 
    handleTitleChange(event) {
        this.setState({
            title: event.target.value
        })
    }
// Sets the description
    handleDescriptionChange(event) {
        this.setState({
            description: event.target.value
        })
    }
// Used to submit forms
    handleFormSubmit(e) {
        e.preventDefault()
        axios.put('/news/' + this.props.match.params.id, {
            title: this.state.title,
            description: this.state.description
        }).then(res => {
            this.props.history.push("/");
        });
    }
// renders the view
    render() {
        return (<div className>
            <div className="menu-bar">
                <ul>
                    <li className="active"><a href="ControlPage.html"><i className="fa fa-home"></i>Home</a></li>
                    <li><a href="NewsPage.html"><i className="fa fa-newspaper"></i>News</a></li>
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

            <form onSubmit={this.handleFormSubmit} className>
                <div className="wrapper">
                    <h2>Edit NewsPage Content</h2>


                    <div className>
                        <input type="text"
                               value={this.state.title}
                               placeholder="Title"
                               onChange={this.handleTitleChange}
                        />
                    </div>

                    <div className>
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
        </div>)
    }
}