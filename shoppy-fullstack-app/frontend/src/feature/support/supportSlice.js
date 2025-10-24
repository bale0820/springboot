import { createSlice } from '@reduxjs/toolkit'



const initialState = {
  supportList: []
}
export const supportSlice = createSlice({
  name: 'support',
  initialState,
  reducers: {
    getSupportList (state, action) {
        const { jsonData } = action.payload;
        state.supportList = jsonData;
    }

  },
})

export const {  getSupportList
             } = supportSlice.actions   //API 함수 또는 컴포넌트에서 dispatch(액션함수)

export default supportSlice.reducer  //store  import