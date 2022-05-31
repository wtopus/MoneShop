import React from "react";
import { addToCart, notify } from "../actions/index";
import { useSelector, useDispatch } from "react-redux";
import Item from "../components/Item";
import axios from "axios";

function ItemListContainer() {
  const state = useSelector((state) => state.itemReducer);
  const { items, cartItems, user } = state;
  const dispatch = useDispatch();
  console.log(user.userId);

  const handleClick = (item) => {
    console.log(user.userId);
    console.log(item.id);
    if (!cartItems.map((el) => el.itemId).includes(item.id)) {
      axios({
        url: "http://localhost:8081/mone/cart",
        method: "post",
        data: {
          mid: user.userId,
          pno: item.id,
        },
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((resp) => {
          const { result } = resp.data;
          console.log(result);
          if (result === "success") {
            dispatch(notify(`장바구니에 추가되었습니다.`));
            dispatch(addToCart(item.id));
          }
        })
        .catch((err) => {
          console.log(err);
          dispatch(notify(`장바구니에 추가에 실패했습니다.`));
        });
    } else {
      dispatch(notify("이미 추가된 상품입니다."));
    }
  };

  return (
    <div id="item-list-container">
      <div id="item-list-body">
        <div id="item-list-title">드시모네 베스트 상품 모음</div>
        {items.map((item, idx) => (
          <Item
            item={item}
            key={idx}
            handleClick={() => {
              handleClick(item);
            }}
          />
        ))}
      </div>
    </div>
  );
}

export default ItemListContainer;
