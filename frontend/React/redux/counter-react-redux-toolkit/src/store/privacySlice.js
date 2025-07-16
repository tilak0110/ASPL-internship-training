import { createSlice } from "@reduxjs/toolkit";

const privacySlice = createSlice({
    name: "privacy",
    initialState:{
        value:false
    },
    reducers:{
        toggle: (state)=>{
            return {value: !state.value}
        }
    }

});
export default privacySlice;