// NPM Packages
import React from "react";
import plants from "../../images/indoor-plants.jpg";

export default function HomePage() {
  return (
    <div className="card">
        <img className="card-img-top" src={plants} alt="selection of indoor plants" title="indoor plants"/>
      <div className="card-body">
        <h4 className="card-title">Plant lovers unite!</h4>
        <p>Whether you're a seasoned plant parent or a nervous newbie, Plantista is the forum for you!</p>
        <p>Post your best green-fingered tips or seek help for your floral conundrums.</p>
        <a href="./posts">Go to posts</a>
      </div>
    </div>
  );
}
