import axios from "axios";
import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { notify, setCart } from "../actions";

export default function OrderSummary({ totalQty, total, cartItems }) {
  const state = useSelector((state) => state.itemReducer);
  const { user } = state;
  const dispatch = useDispatch();
  const handleOrder = (orders, totalPrice) => {
    axios
      .post("http://localhost:9001/payment", {
        method: "POST",
        body: {
          mid: user.id,
          price: totalPrice,
        },
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((resp) => {
        const { result } = resp.data;
        if (result !== "-1+") {
          dispatch(setCart([]));
          dispatch(notify(`${totalQty}개의 상품을 구매했습니다.`));
        }
      })
      .catch((err) => {
        dispatch(notify(`상품 구매에 실패했습니다.`));
      });
  };
  return (
    <section id="order-summary-box">
      <div id="order-summary-container">
        <h4>주문 합계</h4>
        <div id="order-summary">
          총 아이템 개수 :{" "}
          <span className="order-summary-text">{totalQty} 개</span>
          <hr></hr>
          <div id="order-summary-total">
            합계 : <span className="order-summary-text">{total} 원</span>
          </div>
        </div>
      </div>
      <button id="order-item-btn" onClick={() => handleOrder(cartItems, total)}>
        <h2>{totalQty}개의 상품 구매하기</h2>
      </button>
    </section>
  );
}
