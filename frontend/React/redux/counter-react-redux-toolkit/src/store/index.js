import { configureStore } from '@reduxjs/toolkit'
import CounterSlice from './CounterSlice';
import privacySlice from './privacySlice';

const counterStore = configureStore({reducer: {
   counter:  CounterSlice.reducer,
   privacy: privacySlice.reducer
}});

export const counterActions = CounterSlice.actions; 
export const privateActions = privacySlice.actions;
export default counterStore;


