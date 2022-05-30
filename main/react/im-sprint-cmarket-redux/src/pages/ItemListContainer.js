import React from "react";
import { addToCart, notify } from "../actions/index";
import { useSelector, useDispatch } from "react-redux";
import Item from "../components/Item";
import axios from "axios";

function ItemListContainer() {
  const state = useSelector((state) => state.itemReducer);
  const { items, cartItems, user } = state;
  const dispatch = useDispatch();

  const handleClick = (item) => {
    if (!cartItems.map((el) => el.itemId).includes(item.id)) {
      axios
        .post("http://localhost:9001/addOne", {
          method: "POST",
          body: {
            mid: user.id,
            pno: item.id,
          },
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then((resp) => {
          const { result } = resp.data;
          if (result !== "-1+") {
            dispatch(notify(`장바구니에 추가되었습니다.`));
            dispatch(addToCart(item.id));
          }
        })
        .catch((err) => {
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
