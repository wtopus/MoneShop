import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import axios from "axios";
import { setUser, setLogin, notify, setCart } from "../actions";

export default function Login() {
  const state = useSelector((state) => state.itemReducer);
  const { user, isLogin } = state;
  const dispatch = useDispatch();
  let id = "";
  let pw = "";

  const login = () => {
    console.log(id, pw + "rerer")
    axios
      .post("http://localhost:8080/dunkey/mone/new", null, {
        params: {
          mid: id,
          mpw: pw,
        },
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((resp) => {
        console.log(JSON.stringify(resp));
        const { result } = resp.data;

        if (result !== "-1+") {
          dispatch(setLogin(true));
          dispatch(setUser(id));
          dispatch(
            setCart(
              result
                .substring(0, result.length)
                .split("+")
                .map((el) => Number(el))
            )
          );
          dispatch(notify(`${id}님 환영합니다.`));
        } else {
          dispatch(notify(`잘못된 정보를 입력했습니다.`));
        }
      })
      .catch((err) => {
        dispatch(notify(`로그인에 실패했습니다.`));
      });
  };

  return (
    <div id="login-list-container">
      <div id="login-list-body">
        <div id="shopping-login-container">
          <section id="login-summary-box">
            <div id="login-summary-container">
              <h4>LOGIN</h4>
              <div id="login-text">
                <input
                  type="text"
                  min={1}
                  className="login-input"
                  onChange={(e) => {
                    id = e.target.value;
                  }}
                ></input>
                <br />
                <input
                  type="password"
                  min={1}
                  className="login-input"
                  onChange={(e) => {
                    pw = e.target.value;
                  }}
                ></input>
              </div>
            </div>
            <button
              id="order-item-btn"
              onClick={(e) => {
                login();
              }}
            >
              <h2>로그인</h2>
            </button>
          </section>
        </div>
      </div>
    </div>
  );
}
