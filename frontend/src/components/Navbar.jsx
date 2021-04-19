import React from "react";
import { Link } from "react-router-dom";
import logoLeaf from "../images/logo-leaf.png";
import logoText from "../images/logo-text.png";

export default function Navbar({ onLogout }) {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-dark">
      <Link className="navbar-brand" to="/">
        <img src={logoLeaf} alt="Plantista leaf icon" title="Plantista logo" className="d-block d-sm-none"/>
        <img src={logoText} alt="Plantista logo text" title="Plantista logo" className="d-none d-sm-block"/>
      </Link>
      <button
        className="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarColor01"
        aria-controls="navbarColor01"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarColor01">
        <ul className="navbar-nav mr-auto">
          <li className="nav-item">
            <Link to="/" className="nav-link">
              Home
            </Link>
          </li>

          <li className="nav-item">
            <Link to="/posts" className="nav-link">
              Posts
            </Link>
          </li>

        </ul>

        <button
          className="btn btn-outline-info my-2 my-sm-0"
          onClick={onLogout}
        >
          Logout
        </button>
      </div>
    </nav>
  );
}
