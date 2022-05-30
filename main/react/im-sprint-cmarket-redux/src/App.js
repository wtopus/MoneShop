import React, { useEffect, useState } from "react";
import Nav from "./components/Nav";
import ItemListContainer from "./pages/ItemListContainer";
import NotificationCenter from "./components/NotificationCenter";
import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import ShoppingCart from "./pages/ShoppingCart";
import Login from "./pages/Login";
import axios from "axios";
import { useSelector } from "react-redux";

function App() {
  const state = useSelector((state) => state.itemReducer);
  const { isLogin } = state;

  return (
    <Router>
      <Nav />
      <Switch>
        <Route exact={true} path="/">
          <ItemListContainer />
        </Route>
        {isLogin ? (
          <Route path="/shoppingcart">
            <ShoppingCart />
          </Route>
        ) : (
          <Route path="/login">
            <Login />
          </Route>
        )}
      </Switch>
      <NotificationCenter />
    </Router>
  );
}

export default App;
