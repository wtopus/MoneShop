import {
  REMOVE_FROM_CART,
  ADD_TO_CART,
  SET_QUANTITY,
  SET_PRODUCTS,
  SET_ORDERS,
  SET_USER,
  SET_CART,
  SET_LOGIN,
} from "../actions/index";
import { initialState } from "./initialState";

const itemReducer = (state = initialState, action) => {
  switch (action.type) {
    case SET_LOGIN:
      return Object.assign({}, state, {
        isLogin: action.payload.isLogin,
      });
      break;
    case SET_USER:
      return Object.assign({}, state, {
        user: {
          userId: action.payload.userId,
        },
      });
      break;
    case SET_CART:
      let itemArr = action.payload.itemList.reduce((acc, curr) => {
        let item = {
          itemId: curr,
          quantity: 1,
        };
        acc.push(item);
        return acc;
      }, []);
      return Object.assign({}, state, {
        cartItems: itemArr,
      });
      break;
    case SET_PRODUCTS:
      return Object.assign({}, state, {
        items: action.payload.items,
      });
      break;
    case SET_ORDERS:
      return Object.assign({}, state, {
        orders: action.payload.orders,
      });
      break;
    case ADD_TO_CART:
      return Object.assign({}, state, {
        cartItems: [...state.cartItems, action.payload],
      });
      break;
    case REMOVE_FROM_CART:
      return Object.assign({}, state, {
        cartItems: [...state.cartItems].filter(
          (el) => el.itemId !== action.payload.itemId
        ),
      });
      break;
    case SET_QUANTITY:
      let idx = state.cartItems.findIndex(
        (el) => el.itemId === action.payload.itemId
      );
      const copiedCartItems = [...state.cartItems];
      copiedCartItems[idx] = {
        ...copiedCartItems[idx],
        quantity: action.payload.quantity,
      };
      return Object.assign({}, state, {
        cartItems: copiedCartItems,
      });
      break;
    default:
      return state;
  }
};

export default itemReducer;
