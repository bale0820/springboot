import { configureStore } from '@reduxjs/toolkit'
import cartSlice  from '../feature/cart/cartSlice.js'
import productSlice  from '../feature/product/productSlice.js'
import authSlice from '../feature/auth/authSlice.js'

//액션 로깅 처리 담당 미들웨어
const myLoggerMiddleware = (store) => (next) => (action) =>  {
      console.log("distpatch :: ",action);
      const result =  next(action);
      console.log("next action :: ", store.getState());
      
}

export const store = configureStore({
  reducer: {
    cart: cartSlice,
    product: productSlice,
    auth: authSlice
  },
//  middleware : (getDefaultMiddeware) =>
//   getDefaultMiddeware().concat(myLoggerMiddleware)

})