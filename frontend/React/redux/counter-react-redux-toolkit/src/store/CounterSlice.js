import { createSlice } from "@reduxjs/toolkit";

const CounterSlice= createSlice({
    name: "counter",
    initialState: {
        counterVal: 0
    },
    reducers:{
        increment: (state)=>{
            state.counterVal++;
        },
        decrement: (state) => {
            state.counterVal--;
        },
        add: (state,action) => {
            state.counterVal += Number(action.payload.num);
        },
        substract: (state,action) => {
            state.counterVal -= Number(action.payload.num);

        },
        reset: (state)=> {
            state.counterVal= 0;
        }
    }
});
export default CounterSlice;