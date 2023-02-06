import React, { Component }  from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import {NewsList} from "./components/NewsList";
import {PageNotFound} from "./components/PageNotFound";
import {NewNews} from "./components/NewNews";
import {EditNews} from "./components/EditNews";
import {Login} from "./components/Login";
import {Home} from "./components/Home";
import {ForgotPassword} from "./components/ForgotPassword";
import {Faq} from "./components/Faq";
import {Map} from "./components/Map";
import {Registration} from "./components/Registration";




function App() {
    return (

        <Router>
            <Switch>
                <Route exact strict path="/registration" component={Registration}/>
                <Route exact strict path="/map" component={Map}/>
                <Route exact strict path="/faq" component={Faq}/>
                <Route exact strict path="/forgotpassword" component={ForgotPassword}/>
                <Route exact strict path="/home" component={Home}/>
                <Route exact strict path="/login" component={Login}/>
                <Route exact strict path="/news/:id/edit" component={EditNews}/>
                <Route exact strict path="/news/new" component={NewNews}/>
                <Route exact strict path="/" component={NewsList}/>
                <Route exact strict component={PageNotFound}/>
            </Switch>
        </Router>

    );
}

export default App;
