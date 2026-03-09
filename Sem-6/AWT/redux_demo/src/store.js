import { configureStore } from "@reduxjs/toolkit";
import studentReducer from "./slices/studentSlice";

const store = configureStore({
    reducer: studentReducer,

});

export default store;