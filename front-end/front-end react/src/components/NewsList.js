import React, { Component }  from 'react';
import axios from "axios";
import {Link} from "react-router-dom";
import "./newslist.css"


export class NewsList extends Component {

    constructor(props) {
        super(props)
        this.state = {news_list: []}
        this.handleNewNewsChange = this.handleNewNewsChange.bind(this)
        this.handleDeleteNews = this.handleDeleteNews.bind(this)
        this.handleLikeChange = this.handleLikeChange.bind(this)
        this.handleDisLikeChange = this.handleDisLikeChange.bind(this)
    }
// Updates dislike button
    handleDisLikeChange(id){
        axios.put('/news/' + id + "/update_dislike")
            .then(response => {
                window.location.reload()
            })
    }
// Updates like button
    handleLikeChange(id){

        axios.put('/news/' + id + "/update_like")
            .then(response => {
                window.location.reload()
            })
    }
// Directs you to NewNews page
    handleNewNewsChange() {
        this.props.history.push("/news/new");
    }
// Handles delete 
    handleDeleteNews(id) {
        // eslint-disable-next-line no-restricted-globals
        if (confirm("Are you sure?")) {
            axios.delete("/news/" + id).then(res => {
                this.setState({
                    news_list: this.state.news_list.filter(news => news.id !== id)
                })
            });
        }
    }

// Loads data from backend before render method
    componentDidMount() {
        axios.get('/news')
            .then(response => {
                this.setState({news_list: response.data})
            })
    }

// renders the view
    render() {
        const {news_list} = this.state

        return (
            <div>

                <header>
                    <div className="container">
                        <div id="branding">
                            <h1>Food<span className="highlight">4</span>Everyone</h1>
                        </div>
                        <nav>
                            <ul>
                                <li><a href="/home">Home</a></li>
                                <li><a href="/map">Map</a></li>
                                <li className="current"><a href="/">News</a></li>
                                <li><a href="/faq">FAQ</a></li>
                                <li><a href="/login">Login</a></li>
                            </ul>
                        </nav>
                    </div>
                </header>
                <section id="News">
                    <div className="container">
                        <h1 className="header-color-green">News</h1>

                        {
                            news_list.map(
                                (news, index) =>
                                    <div key={news.id} className="mt-4">

                                        <h3 className="header-underline">{news.title}</h3>
                                        <p>{news.description}</p>

                                        <p>
                                            <button onClick={() => { this.handleLikeChange(news.id) }} className="btn-button-like">{news.like_count}
                                               <span style={{marginLeft: "6px;"}}> <i className="fa fa-thumbs-up"  aria-hidden="true"></i> Like</span></button>
                                               <button onClick={() => { this.handleDisLikeChange(news.id) }} className="btn-button-dislike">{news.dislike_count}
                                                <span style={{paddingLeft: "6px;"}}> <i className="fa fa-thumbs-down" aria-hidden="true"></i> DisLike</span></button>
                                        </p>
                          

                                        <div>< Link className="btn-button-edit" to={`news/${news.id}/edit`}>Edit</Link></div>

                                        <div>
                                            <button onClick={() => {
                                                this.handleDeleteNews(news.id)
                                            }} className="btn-button-delete">Delete
                                            </button>
                                        </div>
                                        { (index + 1) < news_list.length ? <hr/> : ''}
                                    </div>
                            )}


                    </div>
                </section>
                <button className="btn-button-new-news" onClick={() => {
                    this.handleNewNewsChange()
                }}>New News
                </button>
                <footer>
                    <p>Food4Everyone, Copyright &copy; 2021</p>
                </footer>
            </div>
        )
    }
}