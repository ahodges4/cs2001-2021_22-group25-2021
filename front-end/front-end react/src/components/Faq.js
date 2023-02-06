import React, {Component} from 'react';
import "./stylesheet.css"



export class Faq extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (<div>
            <header>
    <div class="container">
      <div id="branding">
        <h1>Food<span class="highlight">4</span>Everyone</h1>
      </div>
      <nav>
        <ul>
          <li><a href="/" >Home</a></li>
          <li><a href="/" >Map</a></li>
          <li><a href="/" >News</a></li>
          <li class="current"><a href="/" >FAQ</a></li>
          <li><a href="/" >Login</a></li>
        </ul>
      </nav>
    </div>
  </header>
  <h1>Frequently Asked Questions(FAQ's)</h1>
  <div class="accordion">
    <div class="accordion-item">
      <div class="accordion-item-header">
        Where is my nearest foodbank?
      </div>
      <div class="accordion-item-body">
        <div class="accordion-item-body-content">
          You can view your nearest foodbank over <a href>here</a>
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <div class="accordion-item-header">
        What do foodbanks need?
      </div>
      <div class="accordion-item-body">
        <div class="accordion-item-body-content">
          The food banks in our network rely on donations from their local communities. Support your local food bank
          either by donating food, offering financial support, or volunteering. You can view what your local food bank
          needs by using the search bar <a href="#anchor-name">below.</a> If the foodbank need displays unknown, we
          currently don't know what's needed at that food bank so contact them directly.
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <div class="accordion-item-header">
        How can I donate?
      </div>
      <div class="accordion-item-body">
        <div class="accordion-item-body-content">
          During this time of uncertainty, any donations would be much appreciated, particularly as food banks are
          likely to see an increase in the number of food parcels given out over the next few weeks. Food banks look
          after their own food donations, so if you want to donate get in touch with your local food bank.
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <div class="accordion-item-header">
        How can I volunteer?
      </div>
      <div class="accordion-item-body">
        <div class="accordion-item-body-content">
          By volunteering for your food bank and being a voice for change in your community, you can make a real
          difference to people’s lives. Across the UK, food banks in the coming months may need extra volunteers to help
          sort and pack donations in their warehouse, collect donations from supermarkets, and deliver food to people in
          crisis. If you would like to volunteer, please view information regarding this at your local foodbank.
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <div class="accordion-item-header">
        Where does the food come?
      </div>
      <div class="accordion-item-body">
        <div class="accordion-item-body-content">
          Non-perishable, in-date food is donated by the public at a range of places, such as schools, churches, and
          businesses, as well as supermarket collection points. It is then sorted into emergency food parcels by more
          than 28,000 volunteers, to be given to people in crisis.
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <div class="accordion-item-header">
        What’s in a typical food parcel?
      </div>
      <div class="accordion-item-body">
        <div class="accordion-item-body-content">
          A typical food parcel contains a minimum of three days of nutritionally balanced, non-perishable, tinned and
          dried foods that have been donated by the local community. A typical food parcel includes: breakfast cereal,
          soup, pasta, rice, pasta sauce, baked beans, tinned meat, tinned vegetables, instant mash, UHT milk, tea,
          coffee, sugar, tinned dessert and biscuits. Some foodbanks also provide fresh produce if they are able to.
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <div class="accordion-item-header">
        What if I can’t get to the foodbank centre?
      </div>
      <div class="accordion-item-body">
        <div class="accordion-item-body-content">
          Your local foodbank may be able to deliver your food parcel to your home, especially if you have mobility
          needs or
          are unwell. Please discuss this with your local foodbank directly.
        </div>
      </div>
    </div>
  </div>
  <h2><a id="anchor-name">Foodbank Needs</a></h2>
  <p align="center">You can view what your local foodbank needs here. Simply enter your town name or postcode and click
    Go.<br/> Powered by GiveFood API.</p>


  <form class="form-inline">

    <input type="search" class="form-input-element" id="search" placeholder="Town name or postcode"/>
    <button type="submit" class="go-button" id="go-button">Go</button>

  </form>


  <div class="food-bank-details" id="foodbank_details">
  </div>
            <footer>
    <p>Food4Everyone, Copyright &copy; 2021</p>
</footer>

        </div>)
    }
}